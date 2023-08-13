package com.msawady.tandemtrack.db

import cats.effect.*
import skunk.*
import natchez.Trace.Implicits.noop

object SkunkSession {
  val session: Resource[IO, Session[IO]] = Session.single(
    host = "localhost",
    port = 5433,
    user = "user",
    password = Some("password"),
    database = "tandem_track"
  )
}
