package part3fp

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App{
  // Exceptions are handled inside try-catch blocks

  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("SUPER FAILURE"))

  println(aSuccess)
  println(aFailure)

  // most of the time you don't need to construct success and failure yourself, the
  // apply method inside the try will do it for you

  def unsafeMethod(): String = throw new RuntimeException("NO STRING FOR YOU BUSTER")

  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)

  // syntax sugar
  val anotherPotentialFailure = Try {
    // code that might throw
  }

  // check if success or failure
  println(potentialFailure.isSuccess)

  // orElse
  def backupMethod(): String = "A valid result"
  val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))
  println(fallbackTry)

// IF YOU HAVE A HUNCH THAT YOUR CODE MIGHT RETURN NULL, USE OPTION
  // IF THROWING EXCEPTIONS THEN USE TRY

  // map, flatMap, filter
  println(aSuccess.map(_ * 2))
  println(aSuccess.flatMap(x => Success(x * 10)))
  println(aSuccess.filter(_ > 10))


  /*
    Exercise
   */
  val host = "localhost"
  val port = "8080"
  def renderHTML(page: String) = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) "<html>...</html>"
      else throw new RuntimeException(("Connection interrupted"))
    }

    def getSafe(url: String): Try[String] = Try(get(url))
    // by wrapping these in a TRY, you contain the exceptions that might be thrown along the way
  }

  object HttpService {
    val random = new Random(System.nanoTime())

    def getConnection(host: String, port:String): Connection =
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException(("Someone else took the port"))

    def getSafeConnection(host: String, port: String): Try[Connection] = Try(getConnection(host, port))


  }

  val possibleConnection = HttpService.getSafeConnection(host, port)
  val possibleHTML = possibleConnection.flatMap(connection => connection.getSafe("/home"))
  // possibleHTML above is a TRY of String
  possibleHTML.foreach(renderHTML)

  // shorthand version
  HttpService.getSafeConnection(host, port)
    .flatMap(connection => connection.getSafe("/home"))
    .foreach(renderHTML)

}
