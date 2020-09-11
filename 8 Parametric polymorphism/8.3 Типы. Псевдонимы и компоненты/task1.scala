import Vect.Aux

import scala.annotation.tailrec

trait Vect extends Any{
  type Item
  def length: Int
  def get(index: Int): Item
  def set(index: Int, item: Item): Aux[Item]
}

object Vect {
  type Aux[I] = Vect { type Item = I }
}

final case class StringVect(str: String) extends  AnyVal with Vect {
  type Item = Char
  def length = str.length
  def get(index: Int) = str.charAt(index)
  def set(index: Int, item: Char): Aux[Char] = StringVect(str.updated(index, item))
}

final case class BoolVect64(values: Long) extends AnyVal with Vect {
  type Item = Boolean
  def length          = 64
  def get(index: Int): Item = ((values >> index) & 1L) == 1
  def set(index: Int, item: Boolean): Aux[Boolean] =
    if (item) BoolVect64(values | (1L << index)) else BoolVect64(values & ~(1L << index))
}

final case class BoolVect8(values: Byte) extends AnyVal with Vect {
  type Item = Boolean
  def length = 8
  def get(index: Int): Item = ((values >> index) & 1) == 1
  def set(index: Int, item: Boolean): Aux[Boolean] =
    if (item) BoolVect8((values | (1 << index)).toByte) else BoolVect8((values & ~(1 << index)).toByte)
}
def toList(vect: Vect): List[vect.Item] = {
  @tailrec
  def createList(res: List[vect.Item] = Nil, index: Int = 0): List[vect.Item] = {
    if (index == vect.length)
      res.reverse
    else
      createList(vect.get(index) +: res, index + 1)
  }
  createList()
}

object Main extends App {
  print(BoolVect64(453141517689L).set(63, item = true).set(0, item = false).get(42))
}