object Config {
  val name = "Hello, "
}

import Config.{name => prefix}
def greeting(name: String) {
  println(prefix + name)
}
val name = "Oleg"
greeting(name)