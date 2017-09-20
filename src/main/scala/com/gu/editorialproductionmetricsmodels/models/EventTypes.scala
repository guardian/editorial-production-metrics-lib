package com.gu.editorialproductionmetricsmodels.models

import io.circe._
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import org.joda.time.DateTime

case class CapiData(
   composerId: String,
   storyBundleId: Option[String],
   newspaperBookTag: Option[String],
   creationDate: String,
   firstPublicationDate: String,
   commissioningDesk: String,
   originatingSystem: OriginatingSystem,
   productionOffice: Option[ProductionOffice])

case class ForkData(
   composerId: String,
   time: DateTime,
   wordCount: Int,
   revisionNumber: Int)

object ForkData {
  import DateTimeHelper._
  implicit val metricEncoder: Encoder[ForkData] = deriveEncoder
  implicit val metricDecoder: Decoder[ForkData] = deriveDecoder
}