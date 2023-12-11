import Dependencies._

ThisBuild / scalaVersion     := "3.3.1"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.solynaranjas"
ThisBuild / organizationName := "SolYNaranjaS"

val catsVersion = "2.9.0"

lazy val root = (project in file("."))
  .settings(
    name := "tagless",
    semanticdbEnabled := false,
    libraryDependencies ++= Seq(
      scalaTest        % Test,
      "org.typelevel"  %% "cats-core" % catsVersion
    )
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
