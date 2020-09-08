import scala.annotation.tailrec
@tailrec
def fibs[A](n: Int, currentNumber: BigInt = 1, f1: BigInt = 0, f2: BigInt = 1): BigInt = {
  if (n <= 0)
    f1
  else {
    fibs(n - 1, currentNumber, f2, f1 + f2)
  }
}
println(fibs(1))

println(fibs(2))

println(fibs(3))

println(fibs(6))

println(fibs(100))