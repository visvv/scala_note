package lecture.part1s

import scala.util.Try

object DarkSugars extends App {
  println("Dark sugars !!!!")

  // syntax sugar #1 : Single parameter method.
  def aMethods(num: Int): String = s"Hello $num"

  println(aMethods(50))

  // calling method using  {} instead of ().
  println {
    aMethods {
      100
    }
  }

  val sample = Try {
    throw new RuntimeException("Sample exception")
  }

  val list = List(1, 2, 3).map {
    x => x * 2
  }
  println(list)

  // syntax sugar #2 : single abstract method

  trait Action {
    def action(num : Int) : Unit
  }

  val sampleAction : Action = new Action {
    override def action(num: Int): Unit = println(s"Doing $num actions");
  }

  sampleAction.action(23)
  var newAction : Action= (num :Int) => println(s"Doing $num actions....");
  newAction.action(50)

  // syntax sugar #3 : Multi word method.

  class TeenGirl(name : String) {
    def `and the said`(msg : String ) : String = s"$name said $msg"
  }

  val teenGirl : TeenGirl = new TeenGirl("Lilly")
  println(teenGirl `and the said` "Scala is a wonderful language")


  // syntax sugar #4 : infix types

  // syntax sugar #5 : update method()
  val anArray = Array(1,2,3,4)
  anArray(1) = 10 // compiler will re-write this as anArray.update(1,10)
  anArray.foreach( println(_))
 // apply() and update()

  //syntax sugar #6 : setters for mutable containers
  class Person {
    private var internalName :String = null;
    def name : String = internalName
    // writing setter
    def name_=(value : String) : Unit = {
      println ("Inside setter")
      internalName = value
    }
  }

  val person : Person = new Person
  person.name = "Sam"
  println(person.name)

}
