package lecture.part1s

import scala.None

object Recap extends App {
  println("Hello")
  val condition: Boolean = false
  val aConditionalValue = if (condition) 25 else 50

  val aConditionBlock = {
    if (condition) 100
    else 200
  }

  // Unit == void
  println(aConditionBlock)

  // function
  def sum(a: Int, b: Int): Int = a + b

  // tail-recursion

  // object-orientation

  class Animal

  class Dog extends Animal

  val aDog: Animal = new Dog // subtyping-polymorphism

  trait Carnivore {
    def eat(animal: Animal): Unit

  }

  class Crocodile extends Animal with Carnivore {
    override def eat(animal: Animal): Unit = {
      println("Crunching...." + animal)
    }
  }

  //  val crocodile :Carnivore = new Crocodile
  val crocodile = new Crocodile
  crocodile.eat(new Dog)
  // or
  crocodile eat new Dog // natural language

  // anonymous classes

  val newCarnivore = new Carnivore {
    override def eat(animal: Animal): Unit = println("Roar !!!")
  }

  // generics

  // singletons and companions

  // case classes
  case class Person(name: String, age: Int)

  //exceptions
  val aPotentialFailure = try {
    throw new RuntimeException
  } catch {
    case e: Exception => println("Failed with runtime exception")
  } finally {
    println("Final operations...")
  }

  // packaging and imports

  // functional programming
  val incrementer = new Function1[Int, Int] {
    override def apply(value: Int): Int = value + 1
  }

  // using lambdas
  val newIncrement = (a: Int) => a + 1;
  println(newIncrement(5))
  // scala collections
  // Seqs, Arrays, Lists, Vectors,Map

  val map = Map(
    "one" -> 1,
    "two" -> 2,
    "three" -> 3
  )

  // options

  val anOption = Some(3) // & None

  // pattern matching

  val number = 2;

  val ranking = number match {
    case 1 => "First"
    case 2 => "Second"
    case 3 => "Third"
  }

  println(ranking)


}
