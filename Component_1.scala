import scala.collection.mutable.ListBuffer


object Component_1
{
  val random = scala.util.Random

  def main(args: Array[String]): Unit = {
    val report = generateRandomReport()
    print(report.toString)
  }

  def generateRandomReport(): Report = {
    val id = random.nextInt(100)
    val position = (random.nextInt(50), random.nextInt(50))
    val citizens = new ListBuffer[Citizen]()
    val words = new ListBuffer[String]()
    createCitizen(5, citizens)
    createWord(5, words)
    val wordsList = words.toList
    val citizenList = citizens.toList
    val report = new Report(id, position, citizenList, wordsList)
    report
  }

  def createCitizen(range : Int, citizens : ListBuffer[Citizen]): Unit = {
    if(range == 0){print("Citizens created")}
    else {createCitizen(range-1, citizens += new Citizen(random.alphanumeric.take(3 + random.nextInt(5-3 + 1)).mkString, random.nextInt(100)))
    }
  }

  def createWord(range : Int, words : ListBuffer[String]) : Unit = {
    if(range == 0){print("Words created")}
    else {createWord(range-1, words += random.alphanumeric.take(5 + random.nextInt(10-5 + 1)).mkString)}
  }

  def storeMessage() : Unit = {

  }

}


class Citizen(var name : String, var peaceScore : Int) {
  override def toString: String =
    "(Name : " + name + " PeaceScore : " + peaceScore + ")"
}

class Report(var id : Int, var position : (Int,Int), var citizens : List[Citizen], var words : List[String]) {
  override def toString: String =
    "Report \n id : " + id + "\n Position : " + position + "\n Citizens : " + citizens.toString + "\n Words heard : " + words + "\n"
}
