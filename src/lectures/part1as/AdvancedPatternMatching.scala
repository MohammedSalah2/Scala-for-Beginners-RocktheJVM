package lectures.part1as

object AdvancedPatternMatching extends App{

  val numbers =   List(1)
  val description = numbers match {
    case head :: Nil => println(s"the only element is $head.")
    case _ =>
  }

  /*
    - constants
    - wildcards
    - case classes
    - tuples
    - some special magic like above
   */

  // below is how you pattern match when you don't have a case class like Person
  // case Person ties to object Person not class Person
  class Person(val name: String, val age: Int)

  object Person {
    def unapply(person: Person): Option[(String, Int)] =
      if (person.age < 21) None
      else Some((person.name, person.age))

    def unapply(age: Int): Option[String] =
      Some(if (age < 21) "minor" else "major")
  }

  val bob = new Person("Bob", 21)
  val greeting = bob match {
    case Person(n, a) => s"Hi, my name is $n and I am $a years old."
  }
  println(greeting)

  val legalStatus = bob.age match {
    case Person(status) => s"My legal status is $status"
  }

  println(legalStatus)

  /*
    Exercise - create pattern match for the case where you want to match against multiple conditions instead of values
   */
  val n: Int = 20
  val mathProperty = n match {
    case SingleDigit() => "single digit"
    case Even() => "an even number"
    case _ => "no property"
  }

  object Even {
    def unapply(arg: Int): Boolean = arg % 2 == 0
  }

  object SingleDigit {
    def unapply(arg: Int): Boolean = arg < 10
  }

  println(mathProperty)

  // infix patterns
  // they only work when there are two values in the case class
  case class Or[A, B](a: A, b: B)
  val either = Or(2, "two")
  val humanDescription = either match {
    case number Or string => s"$number is written as $string"
  }
  println(humanDescription)

  // decomposing sequences
  val vararg = numbers match {
    case List(1, _*) => "starting with 1"
  }

  abstract class MyList[+A] {
    def head: A = ???
    def tail: MyList[A] = ???
  }
  case object Empty extends MyList[Nothing]
  case class Cons[+A](override val head: A, override val tail: MyList[A]) extends MyList[A]

  object MyList {
    def unapplySeq[A](list: MyList[A]): Option[Seq[A]] =
      if (list == Empty) Some(Seq.empty)
      else unapplySeq(list.tail).map(list.head +: _)
  }

  val myList: MyList[Int] = Cons(1, Cons(2, Cons(3, Empty)))
  val decomposed = myList match {
    case MyList(1, 2, _*) => "starting with 1, 2"
    case _ => "something else"
  }

  println(decomposed)

  // custom return types for unapply
  // isEmpty: Boolean, get: something

  abstract class Wrapper[T] {
    def isEmpty: Boolean

  }


}
