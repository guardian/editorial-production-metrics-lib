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
  inWorkflow: Option[Boolean] = Some(false),
  inNewspaper: Option[Boolean] = Some(false),
  creationTime: Option[DateTime] = None,
  roundTrip: Option[Boolean] = Some(false),
  productionOffice: Option[ProductionOffice] = None)

object MetricOpt {
  private val datePattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
  implicit val timeEncoder = new Encoder[DateTime] {
    def apply(d: DateTime): Json = d.toString(datePattern).asJson
  }
  implicit val dateDecoder = new Decoder[DateTime] {
    def apply(c: HCursor): Decoder.Result[DateTime] = {
      val dateTime = for {
        value <- c.focus
        string <- value.asString
      } yield new DateTime(string)
      dateTime.fold[Decoder.Result[DateTime]](Left(DecodingFailure("could not decode date", c.history)))(dt => Right(dt))
    }
  }

  implicit val metricEncoder: Encoder[MetricOpt] = deriveEncoder
  implicit val metricDecoder: Decoder[MetricOpt] = deriveDecoder

  // Because this lib is using Circe, but apps that use it might be using play-json, we've provided this
  // toJsonString method to allow parsing with the correct one on the app side.
  def toJsonString(metricOpt: MetricOpt): String = metricOpt.asJson.noSpaces
}