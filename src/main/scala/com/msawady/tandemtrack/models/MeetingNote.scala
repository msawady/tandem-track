package com.msawady.tandemtrack.models

case class MeetingNote(
  content: String,
  publicSummary: Option[String],
  editableUsers: Set[User],
  readableUsers: Set[User]
)
