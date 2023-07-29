package com.msawady.tandemtrack

import cats.effect.{IO, IOApp}

object Main extends IOApp.Simple:
  val run = TandemtrackServer.run[IO]
