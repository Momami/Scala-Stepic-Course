import scala.io.StdIn

object Main {
  def main(args: Array[String]) {
    val string = StdIn.readLine
    val reg = raw"[a-z]+(_[a-z]+)*".r
    println(reg.pattern.matcher(string).matches())
  }
}