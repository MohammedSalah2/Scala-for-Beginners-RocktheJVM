package lectures.part2oop

object CaseClasses extends App{

  // case classes are a useful short hand for defining a class and the companion object

  case class Person(name: String, age: Int)

  // 1. case classes promote all parameters to fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  // println(instance) = println(instance.toString) // syntactic sugar
  println(jim.toString)
  println(jim)

  // 3. equals and hashCode implemented OOTB
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. CCs have handy copy method
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // 5. CCs have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)
  // no need to instantiate Person with 'new'

  //6. CCs are serializable
  // AKKA

  // 7. CCS have extractor patterns == CCs can be used in PATTERN MATCHING

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  /*
    Expand MyList - use case classes and case objects

   */






}
