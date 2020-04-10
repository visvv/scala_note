package lecture.part1s

import lecture.part1s.Recap.Person

object AdvancedPatternMatching extends App {


  class Person(var name: String, var age: Int) {
    override def toString(): String = s"Name : $name, Age : $age"
  }

  val person: Person = new Person("sam", 27)
  println(person)

  // Only cased classes are qualified for the pattern matching.
  // the class is not cases class. Create an Object of the same class with unapply method
  // implementation.
  object PersonPattern {
    def unapply(arg: Person): Option[(String, Int)] = Some(arg.name, arg.age)

    def unapply(age: Int): Option[String] = {
      if(age > 18)
        Some("Major")
      else
        Some("Minor")
    }
  }

  val greeting = person match {
    case PersonPattern(name, age) => "Hello"
    case _ => "Default"
  }
  println(greeting)


  val legalStatus = person.age match {
    case PersonPattern(status) => s"My legal status is $status"
  }

  println(legalStatus)

  val digit : Int = 10;


  val str = digit match {
    case x if x == 0 => "Zero"
    case x if x == 1 => "One"
    case x if x == 2 => "Two"
    case _ => "Something else"
  }

  println(str)

  object DigitPattern {
    def unapply(number: Int): Option[String] =  {
      if(number == 0) Some("Zero")
      else if (number == 1 ) Some("One")
      else
        Some("Something else")
    }
  }

  val newDigit = 1
  val newStr = newDigit match {
    case DigitPattern(word) => s"$word"
  }

  println(newStr)

  // return type of unapply doesn't need to be Option, instead any implementation with
  // isEmpty & get methods.

  val bob : Person = new Person("bob", 25)

  abstract class Wrapper[A] {
    def isEmpty() : Boolean = ???
    def get() : A = ???
  }

  object PersonWrapper {
    def unapply(person: Person): Wrapper[String] = new Wrapper[String] {
      override def isEmpty(): Boolean = false;
      override def get(): String = s"${person.name}"
    }
  }

  val message = person match {
    case PersonWrapper(n) => s"Name is $n"
  }

  println(message)

}
