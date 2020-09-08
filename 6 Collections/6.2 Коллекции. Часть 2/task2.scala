import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine

object Main {
  def main(args: Array[String]) {
    var input = readLine
    val list: ListBuffer[Int] = ListBuffer()
    while (input != "END") {
      list += input.toInt
      input = readLine
    }
    println(list.zipWithIndex
      .filter { case (_, i) => i % 2 != 0 }
      .map { case (e, _) => e * 2 }
      .sum
      )
  }
}