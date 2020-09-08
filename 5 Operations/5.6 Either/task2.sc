def foo(options: List[Option[Int]]): List[Int] =
  options.filter(_.isDefined).map(_.get)

foo(List(Some(6), None))