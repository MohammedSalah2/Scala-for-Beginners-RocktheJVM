//package part4pm

object PMExercises1 extends App {

//  Implement this, and implement methods
//
//  - `eval: Double` that evaluates an expression, returning the number it represents
//  - `print: String` the returns a printed representation of an expression using normal mathematical notation. You should include brackets. E.g.  the output might be something like `“((1 + 2) + 3)”`

  sealed trait Expression{
    def eval: Double =
      this match {
        case Literal(value) => value
        case Addition(left, right) => left.eval + right.eval
        case Subtraction(left, right) => left.eval - right.eval
        case Multiplication(left, right) => left.eval * right.eval
        case Division(left, right) => left.eval / right.eval
      }
  }


    final case class Literal(value: Double) extends Expression
    final case class Addition(left: Expression, right : Expression) extends Expression
    final case class Subtraction(left: Expression, right : Expression) extends Expression
    final case class Multiplication(left: Expression, right:Expression) extends Expression
    final case class Division(left: Expression, right: Expression) extends Expression

}
