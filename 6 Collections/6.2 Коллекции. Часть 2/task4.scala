object Naval {

  type Point = (Int, Int) // Клетка корабля - пара координат этой клетки на поле
  type Field = Vector[Vector[Boolean]] // Игровое поле - двумерный массив, хранящий для каждой ячейки булево значение - стоит ли на этой клетке корабль?
  type Ship = List[Point] // Корабль как список точек
  type Fleet = Map[String, Ship] // Множество всех кораблей на поле как ассоциативный массив. По строковому ключу (имени корабля) находится список точек корабля
  type Game = (Field, Fleet) // Игровое поле и список кораблей
}

object Lesson {
  val field = Vector(
    Vector(false, false, false, false, false, false, false, false, false, false),
    Vector(false, false, false, false, false, false, false, false, false, false),
    Vector(false, false, false, false, false, false, false, false, false, false),
    Vector(false, false, false, false, false, false, false, false, false, false),
    Vector(false, false, false, false, false, false, false, false, false, false),
    Vector(false, false, false, false, false, false, false, false, false, false),
    Vector(false, false, false, false, false, false, false, false, false, false),
    Vector(false, false, false, false, false, false, false, false, false, false),
    Vector(false, false, false, false, false, false, false, false, false, false),
    Vector(false, false, false, false, false, false, false, false, false, false)
  )
}
import Naval.{Field, Fleet, Game, Point, Ship}
import Lesson.field
import scala.io.StdIn

object Main extends App {

  var zeroGame: Game = (field, Map())
  val countShip = StdIn.readInt
  for (i <- 1 to countShip){
    val Array(name, length) = StdIn.readLine.split(" ")
    val lengthShip = length.toInt
    if (lengthShip > 0 && lengthShip <= 4) {
      val ship: List[Point] = createShip(lengthShip)
      zeroGame = tryAddShip(zeroGame, name, ship)
    }
  }
  zeroGame._2.foreach(ship => println(ship._1))

  // считывание корабля с консоли
  def createShip(length: Int, i: Int = 0, acc: List[Point] = Nil) : List[Point] = {
    if (i == length)
      acc.reverse.sorted
    else {
      val List(coordOne, coordTwo) = StdIn.readLine.split(" ").toList.map(_.toInt)
      createShip(length, i + 1, (coordOne, coordTwo) :: acc)
    }
  }

  // является ли корабль вертикальным
  def isVertical(ship: Ship): Boolean = {
    ship.forall(p => p._2 == ship.head._2)
  }

  // является ли корабль горизонтальным
  def isHorizontal(ship: Ship): Boolean = {
    ship.forall(p => p._1 == ship.head._1)
  }

  // Есть ли разрывы
  def checkGap(list: List[Int]): Boolean = {
    val lst = list
    for (i <- 0 until lst.size - 1){
      if (lst(i) != lst(i + 1) - 1)
        return true
    }
    false
  }

  // определить, подходит ли корабль по своим характеристикам
  def validateShip(ship: Ship): Boolean = {
    if (isVertical(ship) && !checkGap(ship.map(c1 => c1._1)) ||
        isHorizontal(ship) && !checkGap(ship.map(c1 => c1._2)))
      return true
    false
  }

  def checkArea(point: Point, field: Field): Boolean = {
    val xBegin = 0 max point._1 - 1
    val yBegin = 0 max point._2 - 1
    val xEnd = point._1 + 1 min field.head.length - 1
    val yEnd = point._2 + 1 min field.length - 1
    !field.slice(yBegin, yEnd + 1).flatMap(x => x.slice(xBegin, xEnd + 1)).exists(x => x)
  }

  // определить, можно ли его поставить
  def validatePosition(ship: Ship, field: Field): Boolean = {
    val x1 = ship.head._1
    val x2 = ship.last._1
    val y1 = ship.head._2
    val y2 = ship.last._2
    if (x1 < 0 || x2 >= field.head.length || y1 < 0 || y2 >= field.length)
      return false
    ship.forall(p => checkArea(p, field))
  }

  // добавить корабль во флот
  def enrichFleet(fleet: Fleet, name: String, ship: Ship): Fleet = {
    fleet + (name -> ship)
  }

  // пометить клетки, которые занимает добавляемый корабль
  def markUsedCells(field: Field, ship: Ship): Field = {
    var fieldNew = Vector[Vector[Boolean]]()
    var p = 0
    var (c1, c2) = ship(p)
    for (i <- field.indices) {
      var fieldOne = Vector[Boolean]()
      for (j <- field.head.indices) {
        if (j == c1 && i == c2) {
          fieldOne :+= true
          if (p + 1 < ship.size) {
            p += 1
            c1 = ship(p)._1
            c2 = ship(p)._2
          }
        }
        else
          fieldOne :+= field(i)(j)
      }
      fieldNew :+= fieldOne
    }
    fieldNew
  }

  def tryAddShip(game: Game, name: String, ship: Ship): Game = { // логика вызовов методов выше
    if (validateShip(ship) && validatePosition(ship, game._1))
      return (markUsedCells(game._1, ship), enrichFleet(game._2, name, ship))
    game
  }
}

