package lectures.part1basics

object CBNvsCBV extends App{

  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }
  // the type functions in Scala and on the JVM return Longs
  // system.nanoTime here is computed before the function evaluates and the same value is used in the function definition

  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }
  //system.nanoTime is evaluated here 2 different times hence the change in numbers

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  printFirst(34, infinite())
}
