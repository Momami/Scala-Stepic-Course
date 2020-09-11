class A (val value: String)

case class B (override val value: String)
  extends A(value)

val objB = B("It is a B.value")
val objA = new A("It is a A.value")

class FunctionPrint[-T <: A](prefix: String) {
  def apply(t: T): Unit = println(prefix + " " + t.value)
}

object FunctionPrint {
  def apply[T <: A](prefix: String) = new FunctionPrint[T](prefix)
}

def methodPrint(f: FunctionPrint[B], obj: B) = {
  f(obj)
}

val printA = FunctionPrint[A]("A-value:")
val printB = FunctionPrint[B]("B-value:")

methodPrint(printB, objB)
methodPrint(printA, objB)