
object Main {
  def main(args: Array[String]) {
    val points: List[Int] = List(1, 3)
    val chr1: List[Char] = List('x', 'x', 'x', 'x', 'x')
    val chr2: List[Char] = List('y', 'y', 'y', 'y', 'y')

    def crossingover (list1: List[Char], list2: List[Char], points: List[Int], point: Int = 0,
                      acc1: List[Char] = Nil, acc2: List[Char] = Nil, swap: Boolean = false)
                      : (List[Char], List[Char]) = {
      if (list1.isEmpty) 
        return (acc1.reverse, acc2.reverse)
      val swap1 = if (points.nonEmpty) (points.head == point) ^ swap else swap
      val pnts = if (points.nonEmpty && points.head == point) points.tail else points
      if (swap1)
        crossingover(list1.tail, list2.tail, pnts, point + 1, list2.head :: acc1, list1.head :: acc2, swap1)
      else
        crossingover(list1.tail, list2.tail, pnts, point + 1, list1.head :: acc1, list2.head :: acc2, swap1)
    }
    val (acc1, acc2) = crossingover(chr1, chr2, points)
    println(acc1.mkString(""))
    println(acc2.mkString(""))
  }
}