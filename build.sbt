name := "editorial-production-metrics-lib"

organization := "com.gu"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.11"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-parser" % "0.7.0",
  "io.circe" %% "circe-generic" % "0.7.0",
  "com.beachape" %% "enumeratum-circe" % "1.5.14"
)