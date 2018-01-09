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
   productionOffice: Option[ProductionOffice],
   commissionedWordCount: Option[Int],
   path: String,
   wordCount: Option[Int],
   headline: Option[String])

case class ForkData(
   time: DateTime,
   timeToPublication: Int,
   printDetails: PrintDetails,
   digitalDetails: DigitalDetails)

case class PrintDetails(
   bookSectionName: String,
   bookSectionCode: String,
   octopusStatus: String,
   forkApplication: String,
   issueDate: Option[DateTime],
   wordCount: Int)

object PrintDetails {
  import DateTimeHelper._
  implicit val printDetailsEncoder: Encoder[PrintDetails] = deriveEncoder
  implicit val printDetailsDecoder: Decoder[PrintDetails] = deriveDecoder
}

case class DigitalDetails(
   revisionNumber: Int,
   composerId: String,
   workflowStatus: Option[String],
   newspaperBook: Option[String],
   newspaperBookSection: Option[String],
   creationTime: DateTime)

object DigitalDetails {
  import DateTimeHelper._
  implicit val digitalDetailsEncoder: Encoder[DigitalDetails] = deriveEncoder
  implicit val digitalDetailsDecoder: Decoder[DigitalDetails] = deriveDecoder
}

object ForkData {
  import DateTimeHelper._
  implicit val forkDataEncoder: Encoder[ForkData] = deriveEncoder
  implicit val forkDataDecoder: Decoder[ForkData] = deriveDecoder
}
