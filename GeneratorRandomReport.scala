import scala.collection.mutable.ListBuffer

class Citizen(var name : String, var peaceScore : Int)

class Report(var id : Int, var position : (Int,Int), var citizenName : String, var citizenPeaceScore : Int, var words : List[String]) {

    override def toString: String =
      "Report \n id : " + id + "\n Position : " + position + "\n Citizen Name : " + citizenName + "\n Citizen PeaceScore : " + citizenPeaceScore + "\n Words heard : " + words
}

def generateRandomReport() = {
  val random = scala.util.Random
  val id = random.nextInt(100)
  val position = (random.nextInt(50), random.nextInt(50))
  val citizen1 = new Citizen("Jean", random.nextInt(100))
  val words = new ListBuffer[String]()
  val a = 0
  for (a <- 1 to 5) {
    words += random.alphanumeric.take(random.between(5,10)).mkString
  }
  val wordsList = words.toList
  val report = new Report(id, position, citizen1.name, citizen1.peaceScore, wordsList)
  print(report.toString)
}

generateRandomReport()
