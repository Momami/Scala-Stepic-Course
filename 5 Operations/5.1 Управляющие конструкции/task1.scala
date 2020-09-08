import scala.io.StdIn

object Main {
  def main(args: Array[String]) {
    val n = StdIn.readInt
    for {
      i <- 1 until n
      j <- 1 until n
    } if (BigInt(i).gcd(BigInt(j)) == 1)
        println(s"$i $j")
  }
}