/*
 * Copyright (C) 2009-2023 Lightbend Inc. <https://www.lightbend.com>
 */

package akka.cluster.sharding.typed

import akka.testkit.NativeImageUtils
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

object NativeImageMetadataSpec {

  val metadataDir = NativeImageUtils.metadataDirFor("akka-cluster-sharding-typed")

  val additionalEntries = Seq()

  val modulePackages = Seq("akka.cluster.sharding.typed")

  // run this to regenerate metadata 'akka-cluster-sharding-typed/Test/runMain akka.cluster.sharding.typed.NativeImageMetadataSpec'
  def main(args: Array[String]): Unit = {
    NativeImageUtils.writeMetadata(metadataDir, additionalEntries, modulePackages)
  }
}

class NativeImageMetadataSpec extends AnyWordSpec with Matchers {
  import NativeImageMetadataSpec._

  "Native-image metadata for akka-cluster-sharding-typed" should {

    "be up to date" in {
      val (existing, current) = NativeImageUtils.verifyMetadata(metadataDir, additionalEntries, modulePackages)
      existing should ===(current)
    }
  }

}