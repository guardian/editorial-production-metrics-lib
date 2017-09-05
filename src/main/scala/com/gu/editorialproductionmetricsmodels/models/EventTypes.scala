package com.gu.editorialproductionmetricsmodels.models

import org.joda.time.DateTime

case class CapiData(
   composerId: String,
   storyBundleId: Option[String],
   newspaperBookTag: Option[String],
   creationDate: String,
   commissioningDesk: String,
   originatingSystem: OriginatingSystem,
   productionOffice: Option[ProductionOffice])

case class ForkData(
   composerId: String,
   time: DateTime,
   wordCount: Int,
   revisionNumber: Int)
