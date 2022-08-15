package lectures.part2oop

import java.nio.BufferUnderflowException


object Exceptions extends App {

  val x: String = null
  // println(x.length)
  // this ^^ will crash with a Null Pointer Exception

  // 1. throwing and catching exceptions

  // exceptions are instances of classes

  //val aWeirdValue: String = throw new NullPointerException

  // throwable classes extend the Throwable class.
  // Exception and Error are the major Throwable subtypes
  // both exceptions and errors will crash but exceptions denote something that went wrong with the program eg. NPE
  // errors denote something that went wrong with the system

  // 2. how to catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if(withExceptions) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try {
    // code that might throw
    getInt(true)  // inside try block you put your code that might throw an exception
  } catch {
    case e: RuntimeException => 43 // in catch block you try match against all exceptions you might have
  } finally {
    // code that will get executed NO MATTER
    // optional
    // does not influence the return type of this expression
    // use finally only for side effects
    println("finally")
  }
  println(potentialFail)

  // 3. how to define your own exceptions
  class MyException extends Exception
  val exception = new MyException

  // throw exception

  /*
    1. Crash your programme with an OutOfMemoryError
    2. Crash with SOError
    3. PocketCalculator
      - add(x, y)
      - subtract(x, y)
      - multiply(x, y)
      - divide(x, y)

      Throw
        - OverflowException if add(x, y) exceeds Int.MAX_VALUE
        - UnderflowException if subtract(x, y) exceeds Int.MIN_VALUE
        - MathCalculationException for division by 0
   */

  // 1. OOM
  // val array = Array.ofDim(Int.MaxValue)

  // 2. StackOverflow Error
  // def infinite: Int = 1 + infinite
  // val noLimit = infinite

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator {
    def add(x: Int, y: Int) = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      if ( x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int) = {
      val result = x - y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      if ( x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
  }

    def multiply(x: Int, y: Int) = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int) = {
    if (y == 0) throw new MathCalculationException
    else x / y
    }
  }

  println(PocketCalculator.add(Int.MaxValue, 2))
  println(PocketCalculator.divide(2, 0))

}
