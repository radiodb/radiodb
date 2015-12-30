/**
 * Copyright (C) 2014-2015 Really Inc. <http://really.io>
 */
package io.really

import com.github.simplyscala.{ MongodProps }
import org.scalatest.BeforeAndAfterAll

import scala.concurrent.Await
import scala.concurrent.duration._

abstract class BaseActorSpecWithMongoDB(conf: ReallyConfig = TestConf.getConfig())
    extends BaseActorSpec(conf) with BeforeAndAfterAll {

  override def beforeAll(): Unit = {
    super.beforeAll()
  }

  override def afterAll(): Unit = {
    println("Cleaning Up Database")
    Await.result(globals.mongodbConnection.drop(), 15.seconds)
    super.afterAll()
  }

}