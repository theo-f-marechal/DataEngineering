import scala.collection.mutable.ListBuffer

class Citizen(var name : String, var peaceScore : Int) {
  override def toString: String = 
    "(Name : " + name + " PeaceScore : " + peaceScore + ")"
}

class Report(var id : Int, var position : (Int,Int), var citizens : List[Citizen], var words : List[String]) {
    override def toString: String =
      "Report \n id : " + id + "\n Position : " + position + "\n Citizens : " + citizens.toString + "\n Words heard : " + words
}

def generateRandomReport() = {
  val random = scala.util.Random
  val id = random.nextInt(100)
  val position = (random.nextInt(50), random.nextInt(50))
  val citizens = new ListBuffer[Citizen]()
  val words = new ListBuffer[String]()
  val a = 0
  for(a <- 1 to 3) {
    citizens += new Citizen(random.alphanumeric.take(random.between(3,5)).mkString, random.nextInt(100))
  }
  for (a <- 1 to 5) {
    words += random.alphanumeric.take(random.between(5,10)).mkString
  }
  val wordsList = words.toList
  val citizenList = citizens.toList
  val report = new Report(id, position, citizenList, wordsList)
  print(report.toString)
}

generateRandomReport()
