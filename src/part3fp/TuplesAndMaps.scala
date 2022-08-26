package part3fp

import java.net.SocketImpl

object TuplesAndMaps extends App{

  // tuples = finite ordered "lists"
  val aTuple = (2, "hello, Scala") // Tuple2[Int, String] = (Int, String)

  println(aTuple._1) // 2
  println(aTuple.copy(_2 = "goodbye Java"))
  println(aTuple.swap) // ("hello, Scala", 2)

  // Maps = associate keys with values
  val aMap: Map[String, Int] = Map()

  val phonebook = Map(("Jim", 555), "Daniel" -> 789).withDefaultValue(-1) // <- this prevents an error in the compiler if what you're looking for does not exists
                                    //  ^ List[String]
  // a -> b is sugar for (a, b)

  println(phonebook)

  // map ops
  println(phonebook.contains("Jim"))
  println(phonebook("Mary")) // this is using the .apply method on phonebook

  // add a pairing
  val newPairing = "Mary" -> 678
  val newPhonebook = phonebook + newPairing // this is doable since maps are not immutable
  println(newPhonebook)

  // functionals on maps
  // map, flatMap, filter
  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys
  println(phonebook.filterKeys(x => x.startsWith("J")))
  // mapValues
  println(phonebook.mapValues(number => "0245-" + number))

  // conversions to other collections
  println(phonebook.toList)
  println(List(("Daniel", 555)).toMap)
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))

  /*
    1. What would happen if I had two original entries "Jim" -> 555 and "JIM" -> 900?

    !!! careful with mapping keys

    2. Overly simplified social network based on maps
       Person = String
       - add a person to the network
       - remove
       - friend (mutual)
       - unfriend

       - number of friends of a person
       - person with most friends
       - how many people have NO friends
       - if there is a social connection between two people (direct or not)
   */

  def add(socialNetwork: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    socialNetwork + (person -> Set())

  def friend(socialNetwork: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = socialNetwork(a)
    val friendsB = socialNetwork(b)

    socialNetwork + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unfriend(socialNetwork: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = socialNetwork(a)
    val friendsB = socialNetwork(b)

    socialNetwork + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def remove(socialNetwork: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))

    val unfriended = removeAux(socialNetwork(person), socialNetwork)
    unfriended - person

  }







}
