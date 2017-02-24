package tls
package sbtplugin

import sbt._
import sbtcross._

import scala.language.implicitConversions

case object TlsJvmPlatform extends Platform {
  def identifier: String                = "tlsJvm"
  def sbtSuffix: String                 = "TlsJvm"
  def enable(project: Project): Project = project.enablePlugins(TlsJvmPlugin)
  val crossBinary: CrossVersion         = CrossVersion.binary
  val crossFull: CrossVersion           = CrossVersion.patch
}

trait TlsJvmCrossProject {
  val TlsJvmPlatform = sbtplugin.TlsJvmPlatform

  implicit def TlsJvmCrossProjectBuilderOps(
      builder: CrossProject.Builder): TlsJvmCrossProjectOps =
    new TlsJvmCrossProjectOps(builder.crossType(CrossType.Full))

  implicit class TlsJvmCrossProjectOps(project: CrossProject) {
    def tlsJvm: Project = project.projects(TlsJvmPlatform)

    def tlsJvmSettings(ss: Def.SettingsDefinition*): CrossProject =
      tlsJvmConfigure(_.settings(ss: _*))

    def tlsJvmConfigure(transformer: Project => Project): CrossProject =
      project.configurePlatform(TlsJvmPlatform)(transformer)
  }
}

case object TlsJvm1Platform extends Platform {
  def identifier: String                = "tlsJvm1"
  def sbtSuffix: String                 = "TlsJvm1"
  def enable(project: Project): Project = project.enablePlugins(TlsJvm1Plugin)
  val crossBinary: CrossVersion         = CrossVersion.binary
  val crossFull: CrossVersion           = CrossVersion.patch
}

trait TlsJvm1CrossProject {
  val TlsJvm1Platform = sbtplugin.TlsJvm1Platform

  implicit def TlsJvm1CrossProjectBuilderOps(
                                             builder: CrossProject.Builder): TlsJvm1CrossProjectOps =
    new TlsJvm1CrossProjectOps(builder.crossType(CrossType.Full))

  implicit class TlsJvm1CrossProjectOps(project: CrossProject) {
    def tlsJvm1: Project = project.projects(TlsJvm1Platform)

    def tlsJvm1Settings(ss: Def.SettingsDefinition*): CrossProject =
      tlsJvm1Configure(_.settings(ss: _*))

    def tlsJvm1Configure(transformer: Project => Project): CrossProject =
      project.configurePlatform(TlsJvm1Platform)(transformer)
  }
}