package lectures.part1basics

object DefaultArgs extends App{

   def trFact(n: Int, acc: Int = 1): Int =
     if(n <= 1) acc
     else trFact(n-1, n*acc)

  // the '= 1' above means that if the accumulator isn't passed a value, it is going to be implied as one unless
  // it is overwritten below
  val fact10 = trFact(10, 1)

  def savePicture(format: String = "jpg", width: Int, height: Int): Unit = println("saving picture")
  savePicture(width = 800, height = 700)

  // the first parameters in functions cannot be assigned a default value as the compiler would get confused

  /*
    1. pass in every first argument
    2. name the arguments
   */

}
