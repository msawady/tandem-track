package com.msawady.tandemtrack.models

case class Problem(title: String, detail: Option[String])

object Problem {
  def apply(title: String, detail: String): Problem = Problem(title, Some(detail))
}
