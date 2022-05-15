import Dependencies._

ThisBuild / scalaVersion     := "2.13.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

val catsVersion = "2.0.0"

lazy val root = (project in file("."))
  .settings(
    name := "tagless",
    libraryDependencies ++= Seq(
      scalaTest        % Test,
      "org.typelevel"  %% "cats-core" % catsVersion
    )
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
