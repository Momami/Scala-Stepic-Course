class Waiter(name: String, var order: List[String]) {
  println(s"My name $name")
  def giveMe(title: String): Waiter = {
    this.order :+= title
    this
  }

  def complete(): List[String] = {
    order
  }
}

val waiter = new Waiter("Ivan", List[String]())
val positions = waiter.giveMe("pizza").giveMe("bread").complete()
println(s"Order: ${positions.mkString(",")}")