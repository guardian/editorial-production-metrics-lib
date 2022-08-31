import ReleaseTransformations._

name := "editorial-production-metrics-lib"

description := "Scala library of shared models for production metrics."

organization := "com.gu"

scalaVersion := "2.12.8"

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

licenses := Seq("Apache V2" -> url("http://www.apache.org/licenses/LICENSE-2.0.html"))

resolvers ++= Seq(
  "Guardian Github Releases" at "http://guardian.github.io/maven/repo-releases",
  Resolver.sonatypeRepo("releases")
)

publishTo := sonatypePublishTo.value

libraryDependencies ++= Seq(
  "io.circe" %% "circe-parser" % "0.12.0",
  "io.circe" %% "circe-generic" % "0.12.0",
  "com.beachape" %% "enumeratum-circe" % "1.5.18",
  "joda-time" % "joda-time" % "2.10.1"
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
