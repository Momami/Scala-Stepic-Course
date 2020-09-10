case class Pair[S <% Ordered[S]] (first: S, second: S) {
  def smaller =
    if (first < second) first
    else second
}

val p = Pair(BigInt("1000000000000000"),BigInt("7000000000000000"))
p.smaller == BigInt("1000000000000000")