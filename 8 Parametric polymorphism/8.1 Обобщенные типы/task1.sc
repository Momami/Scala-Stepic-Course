case class Pair[T, S] (first: T, second: S) {
  def swap: Pair[S, T] = {
    Pair(second, first)
  }
}

Pair(123, "Oleg").swap
