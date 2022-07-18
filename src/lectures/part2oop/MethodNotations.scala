package lectures.part2oop
import scala.language.postfixOps

object MethodNotations extends App{

  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // infix notation = operator notation (syntactic sugar)

  // infix notation works because there is only a single parameter

  // "operators in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(1.+(2))

  // ALL OPERATORS ARE METHODS
  // Akka actors have ! ?

  // prefix notation
  val x = -1 // - is a unary operator so x is equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  //postfix notation
  println(mary.isAlive)
  println(mary isAlive)
  //postfix notation is only available to methods with no parameters

  //apply
  println(mary.apply())
  println(mary()) //equivalent
  // whenever the compiler sees an object being called like a function, it looks for a definition of apply




}
