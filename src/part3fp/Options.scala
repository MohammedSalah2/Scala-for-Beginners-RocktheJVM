package part3fp

object Options extends App{

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)

  // Options were invented to deal with unsafe APIs
  def unsafeMethod(): String = null
  // val result = Some(null) // WRONG
  val result = Option(unsafeMethod()) // Some or None
  println(result)
  // the whole point of options is that we should never do null checks ourselves, the Option would do that for us

  // chained methods
  def backupMethod(): String = "A valid result"
  def chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

  // DESIGN unsafe APIs
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A valid result")
  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()

  // functions on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // UNSAFE - DO NOT USE THIS




}
