package com.gu.editorialproductionmetricsmodels.models

import enumeratum.EnumEntry.Lowercase
import enumeratum._
import io.circe.Json

sealed trait OriginatingSystem extends EnumEntry with Lowercase
case object OriginatingSystem extends Enum[OriginatingSystem] with CirceEnum[OriginatingSystem] {
  case object Composer extends OriginatingSystem
  case object InCopy extends OriginatingSystem

  val values = findValues
}

sealed trait EventType extends EnumEntry
case object EventType extends Enum[EventType] with CirceEnum[EventType] {
  case object CreatedContent extends EventType
  case object ForkedContent extends EventType
  case object CapiContent extends EventType

  val values = findValues
}

case class KinesisEvent(eventType: EventType, eventJson: Json)
