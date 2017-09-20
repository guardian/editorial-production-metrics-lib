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
  productionOffice: Option[ProductionOffice] = None)

object MetricOpt {
  import DateTimeHelper._
  implicit val metricEncoder: Encoder[MetricOpt] = deriveEncoder
  implicit val metricDecoder: Decoder[MetricOpt] = deriveDecoder

  // Because this lib is using Circe, but apps that use it might be using play-json, we've provided this
  // toJsonString method to allow parsing with the correct one on the app side.
  def toJsonString(metricOpt: MetricOpt): String = metricOpt.asJson.noSpaces
}