import scala.io.StdIn

object Main {
  def main(args: Array[String]) {
    val Array(startIndex, endIndex) = StdIn.readLine.split(" ").map(_.toInt)
    val res = StdIn.readLine
    println(res.take(startIndex) + res.substring(startIndex, endIndex + 1).reverse + res.drop(endIndex + 1))
  }
}