trait Animal {
  val sound: String
  def voice: Unit = println("voice: " + sound)
}

class Cat extends Animal {
  override val sound: String = "Meow!"
}
class Dog extends Animal {
  override val sound: String = "Woof!"
}

class Fish extends Animal {
  override val sound: String = "Fishes are silent!"
  override def voice: Unit = println(sound)
}

object Main extends App {
  val animals = Seq(new Cat, new Dog, new Fish)
  animals.foreach(_.voice)
}