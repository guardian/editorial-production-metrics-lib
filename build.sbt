import ReleaseTransformations._

name := "editorial-production-metrics-lib"

description := "Scala library of shared models for production metrics."

organization := "com.gu"

scalaVersion := "2.13.10"

scmInfo :=  Some(ScmInfo(
  url("https://github.com/guardian/editorial-production-metrics-lib"),
  "scm:git:git@github.com:guardian/editorial-production-metrics-lib.git"
))


sonatypeProfileName := "com.gu"

pomExtra := (
  <url>https://github.com/guardian/editorial-production-metrics-lib</url>
    <developers>
      <developer>
        <id>susiecoleman</id>
        <name>Susie Coleman</name>
        <url>https://github.com/susiecoleman</url>
      </developer>
    </developers>
  )

licenses := Seq("Apache V2" -> url("https://www.apache.org/licenses/LICENSE-2.0.html"))

resolvers ++= Resolver.sonatypeOssRepos("releases")

publishTo := sonatypePublishTo.value

libraryDependencies ++= Seq(
  "io.circe" %% "circe-parser" % "0.14.3",
  "io.circe" %% "circe-generic" % "0.14.3",
  "com.beachape" %% "enumeratum-circe" % "1.7.2",
  "joda-time" % "joda-time" % "2.12.2"
)

lazy val root = project in file(".")

releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  ReleaseStep(action = Command.process("publishSigned", _)),
  setNextVersion,
  commitNextVersion,
  ReleaseStep(action = Command.process("sonatypeReleaseAll", _)),
  pushChanges
)
