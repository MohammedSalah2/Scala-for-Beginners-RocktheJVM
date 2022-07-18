package lectures.part2oop

object Objects extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  object Person { // type + its only instance
    // "static/class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method - its whole purpose is to build Persons given some parameters
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }
  // an object can have values or vars and can also have method definitions

  class Person (val name: String) {
    // instance-level functionality
  }
  //object Person and class Person are companions


  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = SINGLETON INSTANCE
  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john)

  val bobbie = Person(mary, john)

  // Scala Applications = Scala object with
  // def main(args:Array[String]): Unit

}
