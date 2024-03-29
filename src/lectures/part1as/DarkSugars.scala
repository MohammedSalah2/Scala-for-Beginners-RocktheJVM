package lectures.part1as

import scala.::
import scala.util.Try

object DarkSugars extends App {

  // syntax sugar #1: methods with single param
  def singleArgMethod(arg: Int): String = s"$arg little ducks"

  val description = singleArgMethod {
    42
  }

  val aTryInstance = Try {
    throw new RuntimeException
  }

  val result = List(1,2,3).map { x =>
    x + 1
  }
  println(result)

  // syntax sugar #2: single abstract method
  trait Action {
    def act(x: Int): Int
  }

  val anInstance: Action = new Action {
    override def act(x: Int): Int = x + 1
  }

  val aFunkyInstance: Action = (x: Int) => x + 1 // magic

  // single abstract method allows us to reduce an instance of a single method trait to a lambda

  // example: Runnables
  val aThread = new Thread(new Runnable {
    override def run(): Unit = println("hello, Scala")
  })

  val aSweeterThread = new Thread(() => println("sweet, Scala"))

  abstract class AnAbstractType {
    def implemented: Int = 23
    def f(a: Int): Unit
  }

  val anAbstractInstance: AnAbstractType = (a: Int) => println("sweet")

  // syntax sugar #3: the :: and #:: methods are very special

  val prependedList = 2 :: List(3,4)
  // 2.::(List(3,4))
  // List(3,4).::(2)
  // ?!

  // scala spec: last char decides associativity of method
  1 :: 2 :: 3 :: List(4, 5)
  List(4,5).::(3).::(2).::(1) // equivalent

  class MyStream[T] {
    def -->:(value: T): MyStream[T] = this // actual implementation here
  }

  val myStream = 1 -->: 2 -->: 3 -->: new MyStream[Int]

  // syntax sugar #4: multi word method naming

  class TeenGirl(name: String) {
    def `and then said`(gossip: String) = println(s"$name said gossip")
  }

  val lilly = new TeenGirl("Lilly")
  lilly `and then said` "Scala is sweet"

  // syntax sugar #5: infix types
  class Composite[A, B]
  val composite: Int Composite String = ???

  class -->[A,B]
  val towards: Int --> String = ???

  // syntax sugar #6: update() is very special, much like apply()
  val anArray = Array(1,2,3)
  anArray(2) = 7 // rewritten to anArray.update(2, 7)
  // used in mutable collections
  // remember apply() AND update()!









}
