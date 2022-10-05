package lectures.part2afp

object PartialFunctions extends App {

  val aFunction = (x: Int) => x + 1 // Function1[Int, Int] === Int => Int

  val aFussyFunction = (x: Int) =>
    if (x == 1) 42
    else if (x == 12) 56
    else if (x == 5) 999
    else throw new RuntimeException()

  println(aFussyFunction(1))

  val aNicerFussyFunction = (x: Int) => x match {
    case 1 => 42
    case 2 => 56
    case 5 => 999
    case _ => "Choose another number!!!"
  }

  val aPartialFunction: PartialFunction[Int, Int] = {
    case 1 => 42
    case 2 => 56
    case 5 => 999
  } // partial function value
    // equivalent to the pattern match above
    // partial functions are based on pattern matches so a diff number would give a MatchError

  println(aPartialFunction(2))
  // println(aPartialFunction(61994))

  // PF utilities
  println(aPartialFunction.isDefinedAt(67))

  // lift
  val lifted = aPartialFunction.lift // Int => Option[Int]
  println(lifted(2))
  println(lifted(98))

  val pfChain = aPartialFunction.orElse([Int, Int] {
    case 45 => 67
  }

  println(pfChain(2))
  print(pfChain(45))


}

