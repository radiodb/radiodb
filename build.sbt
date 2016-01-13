import com.typesafe.sbt.SbtMultiJvm.MultiJvmKeys.MultiJvm

version in Global := "0.1-SNAPSHOT"

scalaVersion in Global := "2.11.7"

scalacOptions in Global ++= Seq("-feature", "-deprecation")

fork in test in Global := true

lazy val `really-utils` = project in file("modules/really-utils") settings (UtilsBuild.settings: _*) settings (scalariformSettings: _*)

lazy val `really-core` = project in file("modules/really-core") settings (CoreBuild.settings: _*) settings (scalariformSettings: _*) configs (MultiJvm) dependsOn `really-utils`

lazy val `really-simple-auth` = project in file("modules/really-simple-auth") settings (AuthBuild.settings: _*) settings (scalariformSettings: _*) enablePlugins(PlayScala) dependsOn `really-utils`

lazy val really = project in file(".") dependsOn(`really-core`, `really-simple-auth`) aggregate(`really-utils`, `really-core`, `really-simple-auth`) enablePlugins(PlayScala) settings (IOBuild.settings: _*) settings (scalariformSettings: _*)
