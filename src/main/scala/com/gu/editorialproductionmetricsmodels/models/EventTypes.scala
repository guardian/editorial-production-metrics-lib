package com.gu.editorialproductionmetricsmodels.models

case class CapiData(
   composerId: String,
   storyBundleId: Option[String],
   newspaperBookTag: Option[String],
   creationDate: String,
   commissioningDesk: String,
   originatingSystem: OriginatingSystem)
