import com.slack.api.bolt.App
import com.slack.api.bolt.jetty.SlackAppServer
import com.slack.api.methods.SlackApiException
import com.slack.api.methods.response.chat.ChatPostMessageResponse
import com.slack.api.model.Message
import com.slack.api.model.event.AppMentionEvent

import java.io.IOException
import scala.util.Try

@main def main(): Unit =
  val app: App = new App()
  val channelID: String = "research"

  val response: ChatPostMessageResponse = app.client().chatPostMessage { r =>
    r.channel(channelID).text("hello, world")
  }

  if response.isOk then
    val message: Message = response.getMessage
    println("Message sent successfully: " + message)
  else
    println("Error sending message: " + response.getError)

  val server: SlackAppServer = new SlackAppServer(app)
  server.start()