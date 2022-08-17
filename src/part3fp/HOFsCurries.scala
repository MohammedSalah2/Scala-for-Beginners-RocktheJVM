package part3fp

object HOFsCurries extends App{

  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null
  // higher order function (HOF) - where a function is taken as a parameter or returns a function as a result
  // map, flatMap, filter in MyList

  // function that applies a function n times over a value of x
  // nTimes(f, n, x)
  // nTimes(f, 3, x) = f(f(f(x)))    <<< function taken as a parameter and applied a number of times
  // nTimes(f, 3, x) = f(f(f(x))) = nTimes(f, 2, f(x)) = f(f(f(x)))
  // nTimes(f, n, x) = f(f(...f(x))) = nTimes(f, n-1, f(x))

  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n-1, f(x))

  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 87 , 1))   // here we are calling plusOne on the value 1, 10 times which means we are incrementing 1 10 times so we should expect 11 in the console

  // nTimesBetter(f, n) = x => f(f(f...(x)))
  // increment10 = nTimesBetter(plusOne, 10) = x => plusOne(plusOne....(x))
  // val y = increment10(1)
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1) (f(x))

  val plus10 = nTimesBetter(plusOne, 10)
  println(plusOne(1))

  // curried functions
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3) // y => 3 + y
  println(add3(10))

  // functions with multiple parameter lists
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter(("%4.2f"))
  val preciseFormat: (Double => String) = curriedFormatter(("%10.8f"))

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))

}
