import scala.io.StdIn

object FacedString {
  def apply(input: String) = s"*_*$input*_*"

  def unapply(arg: String): Option[String] = {
    val matcher = "\\*_\\*(.*)\\*_\\*".r.pattern.matcher(arg)
    if (matcher.find())
      Some(arg.substring(3, arg.length - 3)) else None
  }
}

object Main {
  def main(args: Array[String]) {
    StdIn.readLine() match {
      case FacedString(str) => println(str)
      case _ => println("Could not recognize string")
    }
  }}