package part3fp

object WhatsAFunction extends App {

  // GOAL : use functions as first class elements
  // problem : OOP


  trait Action[A, B] {
    def execute(element: A): B // <<<<< This is an example of OOP
  }

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }
  println(doubler(100))

  // function types = Function[A, B]
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  // Function types Function2[A, B, R] === (A,B) => R

  // ALL SCALA FUNCTIONS ARE OBJECTS


  trait MyFunction[A, B] {
    def apply(element: A): B
  }

}
