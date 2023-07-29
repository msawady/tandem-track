package com.msawady.tandemtrack.spec

import com.msawady.tandemtrack.models.Problem
import io.circe.generic.auto.*
import sttp.tapir.*
import sttp.tapir.json.circe.*
import sttp.tapir.generic.auto.*

object Endpoints {
  val baseEndpoint: Endpoint[Unit, Unit, Problem, Unit, Any] = endpoint.in("api" / "v1").errorOut(jsonBody[Problem])
}
