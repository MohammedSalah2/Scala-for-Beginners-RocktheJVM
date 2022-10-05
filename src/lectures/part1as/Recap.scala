package lectures.part1as

import scala.annotation.tailrec

object Recap extends App{

  val aCondition: Boolean = false
  val aConditionedVal = if (aCondition) 42 else 65
  println(aConditionedVal)
  // Instruction - executed to do something in sequence
  // Expression - in functional programmes like Scala we construct our programmes through expressions

  // compiler infers types for us
  val aCodeBlock = {
    if (aCondition) 54
    56
  }
  // the value of a code block is its last expression

  // Unit - the types of expressions that do not return anything meaningful, but only do side effects, equivalent to void
  val theUnit = println("hello, Scala")

  // functions
  def aFunction(x: Int): Int = x + 1

  // recursion: stack and tail
  @tailrec def factorial(n: Int, accumulator: Int): Int =
    if (n <= 0) accumulator
    else factorial(n - 1, n * accumulator)

  // object-oriented programming

  class Animal
  class Dog extends Animal
  val aDog: Animal = new Dog // subtyping polymorphism

  trait Carnivore {
    def eat(a: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override def eat(a: Animal): Unit = println("crunch")
  }

  // method notations
  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // natural language

  // anonymous classes
  val aCarnivore = new Carnivore {
    override def eat(a: Animal): Unit = println("roar!")
  }

  // generics
  abstract class MyList[+A] // variance and variance problems in THIS course

  // singletons and companions
  object MyList // this MyList and the MyList above are companions

  // case classes
  case class Person(name: String, age: Int)

  // exceptions and try/catch/finally

//  val throwsException = throw new RuntimeException // Nothing
//  val aPotentialFailure = try {
//    throw new RuntimeException
//  } catch {
//    case e: Exception => "I caught an exception"
//  } finally {
//    println("some logs")
//  }
  // package and imports

  // functional programming
  val incrementer = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 + 1
  }

  incrementer(1)

  val anonymousIncrementer = (x: Int) => x + 1
  List(1,2,3).map(anonymousIncrementer) // HOF
  // map, flatMap, filter

  // for-comprehension
  val pairs = for {
    num <- List(1,2,3) // if condition
    char <- List('a', 'b', 'c')
  } yield num + "-" + char









}
