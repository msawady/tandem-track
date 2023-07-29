package com.msawady.tandemtrack.models

import com.msawady.tandemtrack.models.Meeting.MeetingId

import java.time.{Duration, ZonedDateTime}

case class Meeting(
  id: MeetingId,
  host: User,
  guest: User,
  others: Set[User],
  startDateTime: ZonedDateTime,
  time: Duration
)

object Meeting {
  case class MeetingId(value: String)
}
