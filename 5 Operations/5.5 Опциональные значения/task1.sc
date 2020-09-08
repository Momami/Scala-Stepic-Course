def foo(list: List[Int]): Int =
  list.find(_ % 3 == 0).map(_ * 2).getOrElse(0)

foo(List(1,2,3,4,5,6))
foo(List(1,2,4,4,5,6))
foo(List(1,2,1,4,5,7))