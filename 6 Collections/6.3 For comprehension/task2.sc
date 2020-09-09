def service1: Either[String, Double] = Left("service1")
def service2(res1: Double): Either[String, Int] = Right(7)
def service3: String = "Hello"
def service4(res1: Double, res2: Int, res3: String): Either[String, String] =
  Left(s"$res1 $res2 $res3")

val result = for {
                x <- service1
                y <- service2(x)
                result <- service4(x, y, service3)
              } yield result