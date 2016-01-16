/**
 * Copyright (C) 2014-2015 Really Inc. <http://really.io>
 */
package io.really.model.materializer

import akka.cluster.sharding.ShardRegion
import io.really.ReallyConfig
import io.really.model.materializer.CollectionViewMaterializer.{ RoutableToMaterializer, Envelope }

class MaterializerSharding(config: ReallyConfig) {

  implicit val implicitConfig = config
  val maxShards = config.Sharding.maxShards

  /**
   * ID Extractor for Akka Sharding extension
   * ID is the BucketId
   */
  val idExtractor: ShardRegion.ExtractEntityId = {
    case Envelope(bucketId, message) => bucketId -> message
    case req: RoutableToMaterializer => req.bucketId -> req
  }

  /**
   * Shard Resolver for Akka Sharding extension
   */
  val shardResolver: ShardRegion.ExtractShardId = {
    case req: RoutableToMaterializer => (req.bucketId.hashCode % maxShards).toString
  }

}
