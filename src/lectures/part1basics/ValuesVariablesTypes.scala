package lectures.part1basics

object ValuesVariablesTypes extends App {

  val x: Int = 42
  println(x)



  // VALS ARE IMMUTABLE

  // COMPILER can infer types

  val aString: String = "hello"
  val anotherString = "goodbye"

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aLong: Long = 46287392
  val aShort: Short = 1234
  val aDouble: Double = 3.14

  // variables
  var aVariable: Int = 4

  aVariable = 5
  //VARIABLES ARE NOT IMMUTABLE

}
