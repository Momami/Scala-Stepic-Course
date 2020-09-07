import scala.io.StdIn

object Main {
  def main(args: Array[String]) {
    val number = StdIn.readInt.toBinaryString
    println(number.replaceAll("0", "").length)
  }
}