@main def main(): Unit =

  while true do
    Emulator.sendMessage("hello, world")
    Thread.sleep(1000)
    SlackBot.sendMessage("Ok")
    Thread.sleep(5000)
