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
  val crossFull: CrossVersion           = CrossVersion.full
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
