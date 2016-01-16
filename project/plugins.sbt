//**
//* Copyright (C) 2014-2015 Really Inc. <http://really.io>
//**

resolvers += "Sonatype Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Sonatype OSS Releases" at
  "https://oss.sonatype.org/service/local/staging/deploy/maven2"

addSbtPlugin("com.typesafe.sbt" % "sbt-multi-jvm" % "0.3.11")

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.4.6")

addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.6.0")

javaOptions in Global += "-Dfile.encoding=UTF-8"

scalacOptions in Global ++= Seq("-feature", "-deprecation")

addSbtPlugin("com.typesafe.sbt" % "sbt-site" % "0.8.1")
