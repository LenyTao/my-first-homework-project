import Dependencies._

name := "My-Homework-Project"

version := "0.1"

scalaVersion := "2.13.4"

lazy val fuzzy = (project in file("fuzzy-set"))
  .settings(
    libraryDependencies += scalaTest
  )
lazy val data = project

lazy val core = project
  .dependsOn(data)

  .settings(
    libraryDependencies += scalaTest
  )

lazy val app = project.dependsOn(data, core)


lazy val root = (project in file("."))
  .aggregate(data, core, app,fuzzy)


