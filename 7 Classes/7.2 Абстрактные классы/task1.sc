trait StringProcessor {
  def process(input: String): String
}

val tokenDeleter = new StringProcessor {
  override def process(input: String): String =
    input.replaceAll(",", "")
      .replaceAll(":", "")
      .replaceAll(";", "")
}

val shortener = new StringProcessor {
  override def process(input: String): String = {
    if (input.length > 20)
      input.slice(0, 20).concat("...")
    input
    }
}

val toLowerConvertor = new StringProcessor {
  override def process(input: String): String = input.toLowerCase
}
