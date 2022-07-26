package lectures.part2oop

object Generics extends App {

  class MyList[A] { // A denotes a generic type
    // use the type A
    def add[B >: A](element: B): MyList[B] = ???  // List is B now because it overpowers A as it is its superclass
    /*
      A = Cat
      B = Animal
     */
  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal
  // 1. yes, List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? HARD QUESTION.

  // 2. NO = INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, no! CONTRAVARIANCE
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types - allow you to use your generic classes only for certain types that are either a subclass of a different type or superclass of a different type.
  // UPPER BOUNDED TYPE
  class Cage[A <: Animal] (animal: A)         // here Cage is only accepting type parameters A which are subtypes of Animal
  val cage = new Cage(new Dog)

  // expand MyList to be generic









}
