
class Point(val x: Double, val y: Double, val z: Double) {
  def divideLen(len: Int): Point = {
    new Point(this.x / len, this.y / len, this.z / len)
  }
}

object Point {
  def apply(x: Double, y: Double, z: Double): Point = {
    new Point(x, y, z)
  }

  def sum(point1: Point, point2: Point): Point =
    new Point(point1.x + point2.x, point1.y + point2.y, point1.z + point2.z)

  def average(points: List[Point]): Point = {
    if (points.isEmpty)
      return new Point(0, 0, 0)
    points.reduce((p1, p2) => sum(p1, p2)).divideLen(points.length)
  }

  def show(point: Point): String = s"${point.x} ${point.y} ${point.z}"
}

val list = List(new Point(1, 2.5, 4), new Point(4, 3.5, 6))
println(Point.show(Point.average(list)))