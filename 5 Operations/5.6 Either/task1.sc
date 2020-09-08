import java.lang.Math.abs

def divide(p: (Int, Int))(q: (Int, Int)): Either[String, (Int, Int)] = {
  if (p._2 == 0 || q._2 == 0 || q._1 == 0)
    Left("Zero divisor")
  else if (abs(p._1) >= abs(p._2) || abs(q._1) >= abs(q._2))
    Left("Invalid input")
  else {
    val res = (p._1 * q._2, p._2 * q._1)
    if (abs(res._1) >= abs(res._2))
      Left("Improper result")
    else {
      val gcd = BigInt(res._1).gcd(BigInt(res._2)).intValue
      Right((res._1 / gcd, res._2 / gcd))
    }
  }
}

divide(1, 0)(1, 2) == Left("Zero divisor")
divide(1, 2)(1, 0) == Left("Zero divisor")
divide(1, 2)(0, 2) == Left("Zero divisor")

divide(3, 4)(1, 10) == Left("Improper result")
divide(1, 2)(1, 2) == Left("Improper result")

divide(2, 1)(1, 7) == Left("Invalid input")
divide(1, 2)(7, 1) == Left("Invalid input")
divide(1, 1)(2, 2) == Left("Invalid input")
divide(2, 1)(3, 1) == Left("Invalid input")

divide(1, 2)(2, 3).isRight
divide(-1, 2)(2, 3).isRight
divide(1, -2)(2, 3).isRight
divide(1, 2)(-2, 3).isRight
divide(1, 2)(2, -3).isRight