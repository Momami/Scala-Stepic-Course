// Здесь можно объявить регулярные выражения
val regName = "[a-zA-Z]+".r
val regEmail = "\\w+@\\w+.\\w+".r
val regAll = s"($regName)\\s+($regEmail)".r
val input = List("oleg", "oleg@mail.ru", "jiov89wehv")

def f (input: List[String]): String = input match {
    case List(regAll(name, domain), _*) =>
      name + " " + domain.drop(domain.indexOf("@") + 1)
    case List(name@regName(), email@regEmail(), _*) =>
      name + " " + email.drop(email.indexOf("@") + 1)
    case _ => "invalid"
}


println(f(List()) == "invalid")
println(f(List("")) == "invalid")
println(f(List("oleg")) == "invalid")
println(f(List("oleg@ email.com")) == "invalid")
println(f(List("oleg@email.com oleg")) == "invalid")
println(f(List("oleg ", " oleg@email.com")) == "invalid")

println(f(List("oleg oleg@email.com")) == "oleg email.com")
println(f(List("oleg Oleg5@email.com")) == "oleg email.com")
println(f(List("oleg oleg@email.com", "alex@email.com")) == "oleg email.com")
println(f(List("oleg oleg@email.com", "7bdaf0a1be3", "a8af118b1a2", "28d74b7a3fe")) == "oleg email.com")
println(f(List("oleg", "oleg@email.com")) == "oleg email.com")
println(f(List("oleg", "oleg@email.com", "alex@email.com")) == "oleg email.com")
println(f(List("oleg", "oleg@email.com", "7bdaf0a1be3", "a8af118b1a2", "28d74b7a3fe")) == "oleg email.com")

println(f(List("Oleg 123@gmail.com", "123@gmaiasdl.com")) == "Oleg gmail.com")
println(f(List("Oleg ol@gmail.com", "asdasdasdasd")) == "Oleg gmail.com")
println(f(List("Oleg oleg@gmail.com", "7bdaf0a1be3", "a8af118b1a2", "28d74b7a3fe")) == "Oleg gmail.com")