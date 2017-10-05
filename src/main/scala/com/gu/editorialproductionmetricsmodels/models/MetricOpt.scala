package com.gu.editorialproductionmetricsmodels.models

import io.circe._
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.syntax._
import org.joda.time.DateTime

case class MetricOpt(
  id: Option[String] = None,
  originatingSystem: Option[OriginatingSystem] = None,
  composerId: Option[String] = None,
  storyBundleId: Option[String] = None,
  commissioningDesk: Option[String] = None,
  userDesk: Option[String] = None,
  inWorkflow: Option[Boolean] = None,
  inNewspaper: Option[Boolean] = None,
  creationTime: Option[DateTime] = None,
  firstPublicationTime: Option[DateTime] = None,
  roundTrip: Option[Boolean] = None,
  productionOffice: Option[ProductionOffice] = None,
  issueDate: Option[DateTime] = None,
  bookSectionName: Option[String] = None,
  bookSectionCode: Option[String] = None,
  newspaperBook: Option[String] = None,
  newspaperBookSection: Option[String] = None)

object MetricOpt {
  import DateTimeHelper._
  implicit val metricEncoder: Encoder[MetricOpt] = deriveEncoder
  implicit val metricDecoder: Decoder[MetricOpt] = deriveDecoder

  def apply(forkData: ForkData): MetricOpt = MetricOpt(
    composerId = Some(forkData.digitalDetails.composerId),
    creationTime = Some(forkData.digitalDetails.creationTime),
    issueDate = forkData.printDetails.issueDate,
    bookSectionName = Some(forkData.printDetails.bookSectionName),
    bookSectionCode = Some(forkData.printDetails.bookSectionCode),
    newspaperBook = forkData.digitalDetails.newspaperBook,
    newspaperBookSection = forkData.digitalDetails.newspaperBookSection
  )

  // Because this lib is using Circe, but apps that use it might be using play-json, we've provided this
  // toJsonString method to allow parsing with the correct one on the app side.
  def toJsonString(metricOpt: MetricOpt): String = metricOpt.asJson.noSpaces
}