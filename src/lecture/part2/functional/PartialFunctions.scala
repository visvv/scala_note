package lecture.part2.functional

object PartialFunctions extends App {

 val aFunction: Function1[Int, Int] = (x: Int) => x + 1
 println(aFunction(5))

 val bFunction: Int => Int = (x: Int) => x + 1
 println(bFunction(5))

 val cFunction: Int => String = (x: Int) => {
  if (x == 1) "One"
  else
   throw new ElementNotfoundException()
 }

 class ElementNotfoundException extends RuntimeException

 println(cFunction(1))

 val dFunction : Int=> Int = (x: Int) => x match {
  case 1 => 100
  case 2 => 200
 }

 println(dFunction(2))

 val partialFunction: PartialFunction[Int, Int] =  {
  case 1 => 1000
  case 2 => 2000
 }

 println(partialFunction(2))

 //print even
 List(1,2,3,4).filter((x) => x%2 == 0).foreach(print(_))

 println()
 // print odd
 List(1,2,3,4,5,6).filter(_%2 == 1).foreach(print(_))

 println()
 List(1,2,3,4,5).map(_*2).foreach(print(_))

}
