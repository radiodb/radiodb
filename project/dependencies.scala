import sbt._

object Dependencies {
  val scalatest = "org.scalatest" %% "scalatest" % "2.2.6" % "test"
  val logback = "ch.qos.logback" % "logback-classic" % "1.1.3"
  val wsClient = "io.backchat.hookup" %% "hookup" % "0.2.3"
  val snakeyaml = "org.yaml" % "snakeyaml" % "1.16"
  val commonsIO= "commons-io" % "commons-io" % "2.4"
  val parserCombinator = "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4"
  val reactivemongoPlay = "org.reactivemongo" %% "play2-reactivemongo" % "0.11.9"
  val reactivemongoJson = "org.reactivemongo" %% "reactivemongo-play-json" % "0.11.9"
  val embedmongo = "com.github.simplyscala" %% "scalatest-embedmongo" % "0.2.2" % "test"
  val slick = "com.typesafe.slick" %% "slick" % "2.1.0"
  val h2 = "com.h2database" % "h2" % "1.4.190"
  val playScalaTest = "org.scalatestplus" %% "play" % "1.4.0" % "test"
  val leveldb = "org.iq80.leveldb" % "leveldb" % "0.7"
  val jwtScala = "io.really" %% "jwt-scala" % "1.2.2"
  val akkaPersistenceMongo = "com.github.ironfish" %% "akka-persistence-mongo"  % "1.0.0-SNAPSHOT" % "compile"

  object Akka {
    private val akkaBase = "com.typesafe.akka"
    private val version = "2.4.1"

    val agent = akkaBase %% "akka-agent" % version
    val testKit = akkaBase %% "akka-testkit" % version % "test"
    val actor = akkaBase %% "akka-actor" % version
    val cluster = akkaBase %% "akka-cluster" % version
    val clusterTools = akkaBase %% "akka-cluster-tools" % version
    val contrib = akkaBase %% "akka-contrib" % version
    val sharding = akkaBase %% "akka-cluster-sharding" % version
    val slf4j = akkaBase %%  "akka-slf4j" % version
    val persistance = akkaBase %% "akka-persistence" % version
    val sharedInMemJournal =  "com.github.dnvriend" %% "akka-persistence-inmemory" % "1.1.6"
    val multiNode = akkaBase %% "akka-multi-node-testkit" % version
  }

}
