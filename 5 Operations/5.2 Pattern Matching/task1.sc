case class Pet(name: String, says: String)
val pet = Pet("Kleo", "meow")

// Ваш код
val kind = pet match {
    case Pet("Rex", _) => "dog"
    case Pet(_, "meow" | "nya") => "cat"
    case Pet(_, says) if says.contains("0") || says.contains("1") => "robot"
    case _ => "unknown"
}
println(kind)