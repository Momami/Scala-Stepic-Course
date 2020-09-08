object Main {
  def main(args: Array[String]) {
    val ints: List[Int] = List(0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0)
    val (zeros, ones) = ints.sorted.span(_ == 0)
    println(zeros.mkString(","))
    println(ones.mkString(","))
  }
}