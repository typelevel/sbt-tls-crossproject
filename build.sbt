import sbt._
import Keys._

organization := "org.typelevel"
moduleName   := "sbt-tls-crossproject"
description  := "sbt-crossproject plugin for Typelevel Scala"
scalaVersion := "2.10.6"
sbtPlugin    := true

scalacOptions ++= scalacAllOptions
updateOptions := updateOptions.value.withCachedResolution(true)

addSbtPlugin("org.scala-native" % "sbt-crossproject" % "0.1.0")
addSbtPlugin("org.scala-js"     % "sbt-scalajs"      % "0.6.14")

publishMavenStyle := false

/** Common scalac options useful to most (if not all) projects.*/
lazy val scalacCommonOptions = Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-unchecked",
  "-Xlint"
)

/** Scalac strict compilation options.*/
lazy val scalacStrictOptions = Seq(
  "-Xfatal-warnings",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  "-Xfuture"
)

/** Combines all scalac options.*/
lazy val scalacAllOptions = scalacCommonOptions ++ scalacStrictOptions

bintrayRepository   := "sbt-plugins"
bintrayOrganization := Some("typelevel")
