package tls
package sbtplugin

import sbtcross.CrossPlugin.autoImport._
import sbt._

object TlsJvmPlugin extends AutoPlugin {
  override def requires: Plugins = plugins.JvmPlugin

  val autoImport = AutoImport

  object AutoImport extends TlsJvmCrossProject

  override def projectSettings: Seq[Setting[_]] =Seq(
    crossPlatform := TlsJvmPlatform,
    Keys.scalaOrganization := "org.typelevel"
  )
}

object TlsJvm1Plugin extends AutoPlugin {
  override def requires: Plugins = plugins.JvmPlugin

  val autoImport = AutoImport

  object AutoImport extends TlsJvm1CrossProject

  override def projectSettings: Seq[Setting[_]] =Seq(
    crossPlatform := TlsJvm1Platform,
    Keys.scalaOrganization := "org.typelevel"
  )
}


