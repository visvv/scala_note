package lecture.part2.functional

object ChatBot extends App {
 val botFunction: String => String = {
  case "Hi" => "Hi..."
  case "Bye" => "Bye.."
  case "What is your name" => "My name is Scala Bot..."
 }
 scala.io.Source.stdin.getLines().foreach((line) => println(botFunction(line)))
}
