package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App{


  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)

      result
    }
  }

  println(factorial(10))
// too large of a factorial number will result in a StackOverflowError for the function above


  def anotherFactorial (n: Int): Int = {
    def factHelper(x: Int, accumulator: Int): Int =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression
    // we wrote factHelper here as the last expression of its code path, this allows Scala to preserve the same stack
    // frame, and not use additional stack frames for recursive cause

    factHelper(n, 1)
  }

  // WHEN YOU NEED LOOPS, USE_TAIL_RECURSION

  /*
    1. Concatenate a string n times
    2. IsPrime function tail recursive
    3. Fibonacci function, tail recursive
   */

  def greeting(x: String, n: Int, accumulator: String): String =
    if (n <= 0) accumulator
    else greeting(x, n - 1, x + accumulator)

  println(greeting("hello", 3, ""))
  // In this instance we are looping, therefore we add an accumulator

  def isPrime(n: Int): Boolean = {
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n & t != 0 && isStillPrime)

      isPrimeTailrec(n / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(269))





}
