case class Jar(name: String, value: Int, price: Double)
val jars = List(
  Jar("Морской синий 6л", 6, 3000.0),
  Jar("Огненно-красный 12л", 12, 5000.0),
  Jar("Зеленый 1л", 1, 500.0)
)

val discount: PartialFunction[Jar, String] = {
  case Jar(name, value, price) if value > 10 => s"$name ${price * 0.1}"
  case Jar(name, value, price) if value >= 5 => s"$name ${price * 0.05}"
}
jars.collect(discount)

