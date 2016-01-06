/**
 * Copyright (C) 2014-2015 Really Inc. <http://really.io>
 */
package io.really.model

import akka.cluster.sharding.ShardRegion
import _root_.io.really.{ RoutableToCollectionActor, ReallyConfig }

class CollectionSharding(config: ReallyConfig) {

  implicit val implicitConfig = config
  val maxShards = config.Sharding.maxShards

  /**
   * ID Extractor for Akka Sharding extension
   * ID is the BucketId
   */
  val idExtractor: ShardRegion.ExtractEntityId = {
    case req: RoutableToCollectionActor => Helpers.getBucketIDFromR(req.r) -> req
  }

  /**
   * Shard Resolver for Akka Sharding extension
   */
  val shardResolver: ShardRegion.ExtractShardId = {
    case req: RoutableToCollectionActor => (Helpers.getBucketIDFromR(req.r).hashCode % maxShards).toString
  }
}