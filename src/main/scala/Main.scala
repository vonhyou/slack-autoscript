import com.slack.api.bolt.App
import com.slack.api.bolt.jetty.SlackAppServer
import com.slack.api.methods.SlackApiException
import com.slack.api.methods.response.chat.ChatPostMessageResponse
import com.slack.api.model.Message
import com.slack.api.model.event.AppMentionEvent

import java.io.IOException
import scala.util.Try

@main def main(): Unit =
  SlackBot.sendMessage("hello, world!")
