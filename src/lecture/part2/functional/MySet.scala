package lecture.part2.functional

trait MySet[A] extends (A => Boolean)  {

  def contains(elem:A):Boolean
  def +(elem: A ) : MySet[A]
  def ++(anotherMySet: MySet[A]): MySet[A]

  def map[B](f: A => B) : MySet[B]
  def flatMap[B](f:A => B) : MySet[B]

  def filter(predicate : A => Boolean) : MySet[A]
  def forach(f : A => Unit) : Unit


}