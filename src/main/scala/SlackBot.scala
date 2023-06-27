import com.slack.api.bolt.App
import com.slack.api.methods.response.chat.ChatPostMessageResponse
import com.slack.api.model.Message

object SlackBot {
  private val app: App = new App()

  def sendMessage(message: String, channel: String = "research"): Unit =
    val response: ChatPostMessageResponse = app.client().chatPostMessage { r =>
      r.channel(channel).text(message)
    }

    if response.isOk then
      val message: Message = response.getMessage
      println("Message sent successfully: " + message)
    else
      println("Error sending message: " + response.getError)
}