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

  /*
    1. a function which takes 2 strings and concatenates them
    2. transform the MyPredicate and MyTransformer into function types
    3. define a function which takes and int and returns another function which takes an int and returns an int
      - what's the type of this function
      - how to do it
   */


      def concatenator = new ((String, String) => String) {
        override def apply(a: String, b: String): String = a + b
      }
      println(concatenator("Mohammed ", "Salah"))

      // Function1[Int, Function1[Int, Int]]
      val superAdder: Function1[Int, Function1[Int, Int]] = new Function[Int, Function1[Int, Int]] {
        override def apply(x: Int): Function1[Int, Int] = new Function[Int, Int] {
          override def apply(y: Int): Int = x + y
        }
      }

  val adder3 = superAdder(1000)
  println(adder3(4))
  println(superAdder(3)(4)) // curried function - can be called with multiple parameter lists












  trait MyFunction[A, B] {
    def apply(element: A): B
  }

}
