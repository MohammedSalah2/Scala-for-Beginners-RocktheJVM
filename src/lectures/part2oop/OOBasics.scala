package lectures.part2oop

object OOBasics extends App {

  val person = new Person("Mohammed", 26) // age is a class parameter but not a class member
                                                       // that you can access with the dot operator.
                                                       // class parameters are NOT FIELDS.
                                                       // to convert a class parameter to a field is to add val or var before it
  println(person.x)
  person.greet("Daniel")

}

// constructor - every single instance of Person must be constructed by passing in a name and age
class Person(name: String, val age: Int) {
  val x = 2

  println(1 + 3)

  // this function is defined in a class definition which makes it a method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name") // {this.name} will refer to the name parameter of class Person

  //overloading - defining methods with the same but different signatures
  def greet() :Unit = println(s"Hi, I am $name")

  // multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")


}
