import java.net.URL
import sys.process._
import scala.util.chaining._

object Emulator {
  def sendMessage(message: String): Unit =
    Command.apply(420, 2930)
    Command.apply(message)
    Command.apply(1330, 1840)
    Command.apply(100, 180)
}

object Command {
  private val BASE = "adb shell \"input"
  private val DELAY_MS: Int = 500

  def apply[T](args: T): Unit =
    val command = args match
      case args: String => s"$BASE text \'$args\'\""
      case (x: Int, y: Int) => s"$BASE tap $x $y\""

    command.!
    Thread.sleep(DELAY_MS)
}