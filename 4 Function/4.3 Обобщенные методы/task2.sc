def middle[A](data: Iterable[A]): A = {
  val posMiddle = data.size / 2
  data.drop(posMiddle).head
}

println(middle("Scala"))
println(middle(Seq(1, 7, 5, 9)))

require(middle("Scala") == 'a')
require(middle(Seq(1, 7, 5, 9)) == 5)