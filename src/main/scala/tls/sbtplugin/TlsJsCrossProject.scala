package tls
package sbtplugin


import sbt._
import sbtcross._

import scala.language.implicitConversions

case object TlsJsPlatform extends Platform {
  def identifier: String                = "tlsJs"
  def sbtSuffix: String                 = "TlsJs"
  def enable(project: Project): Project = project.enablePlugins(TlsJsPlugin)
  val crossBinary: CrossVersion         = CrossVersion.binary
  val crossFull: CrossVersion           = CrossVersion.patch
}

trait TlsJsCrossProject {
  val TlsJsPlatform = sbtplugin.TlsJsPlatform

  implicit def TlsJsCrossProjectBuilderOps(
                                             builder: CrossProject.Builder): TlsJsCrossProjectOps =
    new TlsJsCrossProjectOps(builder.crossType(CrossType.Full))

  implicit class TlsJsCrossProjectOps(project: CrossProject) {
    def tlsJs: Project = project.projects(TlsJsPlatform)

    def tlsJsSettings(ss: Def.SettingsDefinition*): CrossProject =
      tlsJsConfigure(_.settings(ss: _*))

    def tlsJsConfigure(transformer: Project => Project): CrossProject =
      project.configurePlatform(TlsJsPlatform)(transformer)
  }
}

case object TlsJs1Platform extends Platform {
  def identifier: String                = "tlsJs1"
  def sbtSuffix: String                 = "TlsJs1"
  def enable(project: Project): Project = project.enablePlugins(TlsJs1Plugin)
  val crossBinary: CrossVersion         = CrossVersion.binary
  val crossFull: CrossVersion           = CrossVersion.full
}

trait TlsJs1CrossProject {
  val TlsJs1Platform = sbtplugin.TlsJs1Platform

  implicit def TlsJs1CrossProjectBuilderOps(
                                              builder: CrossProject.Builder): TlsJs1CrossProjectOps =
    new TlsJs1CrossProjectOps(builder.crossType(CrossType.Full))

  implicit class TlsJs1CrossProjectOps(project: CrossProject) {
    def tlsJs1: Project = project.projects(TlsJs1Platform)

    def tlsJs1Settings(ss: Def.SettingsDefinition*): CrossProject =
      tlsJs1Configure(_.settings(ss: _*))

    def tlsJs1Configure(transformer: Project => Project): CrossProject =
      project.configurePlatform(TlsJs1Platform)(transformer)
  }
}