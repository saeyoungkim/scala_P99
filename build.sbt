ThisBuild / scalaVersion := "2.12.7"
ThisBuild / organization := "p99.project"

lazy val hello = (project in file("."))
  .settings(
    name := "Scala P99",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test,
  )