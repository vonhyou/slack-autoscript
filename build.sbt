ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.0"

lazy val root = (project in file("."))
  .settings(
    name := "slack-autoscript"
  )

libraryDependencies += "com.slack.api" % "bolt" % "1.29.2"
libraryDependencies += "com.slack.api" % "bolt-servlet" % "1.29.2"
libraryDependencies += "com.slack.api" % "bolt-jetty" % "1.29.2"
libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.36"