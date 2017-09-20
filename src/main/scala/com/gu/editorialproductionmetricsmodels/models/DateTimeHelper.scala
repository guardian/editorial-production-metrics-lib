package com.gu.editorialproductionmetricsmodels.models

import io.circe._
import io.circe.syntax._
import org.joda.time.DateTime

object DateTimeHelper {
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
}
