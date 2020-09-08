import scala.io.StdIn

object Main {
  def main(args: Array[String]) {
    val k = StdIn.readInt
    val list = StdIn.readLine.split(" ").map(_.toInt).toList
    def kOrder(list: List[Int], k: Int): Int = {
      val (left, right) = list.partition(_ <= list.head)
      if (left.length == k)
        list.head
      else if (k <= left.length)
        kOrder(left.tail, k)
      else
        kOrder(right, k - left.length)
    }
    println(kOrder(list, k))
  }
}
