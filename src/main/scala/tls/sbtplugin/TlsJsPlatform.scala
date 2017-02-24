package tls
package sbtplugin

import org.scalajs.sbtplugin.ScalaJSPlugin
//import org.scalajs.sbtplugin.impl.ScalaJSGroupID

import sbtcrossproject.CrossPlugin.autoImport._
import sbt._

object TlsJsPlugin extends AutoPlugin {
  override def requires: Plugins = ScalaJSPlugin

  val autoImport = AutoImport

  object AutoImport extends TlsJsCrossProject

  override def projectSettings: Seq[Setting[_]] =Seq(
    crossPlatform := TlsJsPlatform,
    Keys.scalaOrganization := "org.typelevel"
  )
}

object TlsJs1Plugin extends AutoPlugin {
  override def requires: Plugins = ScalaJSPlugin

  val autoImport = AutoImport

  object AutoImport extends TlsJs1CrossProject

  override def projectSettings: Seq[Setting[_]] =Seq(
    crossPlatform := TlsJs1Platform,
    Keys.scalaOrganization := "org.typelevel"
  )
}
