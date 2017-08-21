import ReleaseTransformations._

name := "editorial-production-metrics-lib"

description := "Scala library of shared models for production metrics."

organization := "com.gu"

scalaVersion := "2.11.11"

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

libraryDependencies ++= Seq(
  "io.circe" %% "circe-parser" % "0.8.0",
  "io.circe" %% "circe-generic" % "0.8.0",
  "com.beachape" %% "enumeratum-circe" % "1.5.14",
  "joda-time" % "joda-time" % "2.9.9"
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
