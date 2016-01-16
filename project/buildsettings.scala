import sbt._
import Keys._

object BuildSettings {
  val default = Seq(
    organization := s"io.really",
    homepage := Some(url("https://github.com/radiodb/radiodb")),
    testOptions in Test += Tests.Argument("-oD"),
    resolvers ++= Seq(
      Resolver.sonatypeRepo("releases"),
      "Typesafe repository releases" at "http://repo.typesafe.com/typesafe/releases/",
      "krasserm at bintray" at "http://dl.bintray.com/krasserm/maven",
      "dnvriend at bintray" at "http://dl.bintray.com/dnvriend/maven",
      "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases",
      "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
    )
  )
}
