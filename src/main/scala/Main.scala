import com.github.javafaker.Faker

import scala.io.StdIn.readLine
import scala.util.Random

@main def main(): Unit =
  val endTime: Long = getEndTime
  
  var messageCount: Int = 1
  var byteCount: Int = 0
  while System.currentTimeMillis() < endTime do
    val message: String = generateMessage(Random.nextInt(3) + 1)
    sendMessage(messageCount, message)
    messageCount += 1
    byteCount += message.length

  println(s"$messageCount messages sent in total, $byteCount bytes")

def generateMessage(sentenceCount: Int = 1): String = new Faker().lorem().paragraph(sentenceCount)

def sendMessage(sender: Int, message: String): Unit =
  Thread.sleep(2000)
  sender % 2 match
    case 1 => Emulator.sendMessage(message)
    case 0 => SlackBot.sendMessage(message)

def getEndTime: Long =
  print("Please enter the duration in minutes: ")
  val duration = readLine().toInt
  duration * 60 * 1000 + System.currentTimeMillis()
