package com.msawady.tandemtrack.models

import com.msawady.tandemtrack.models.ActionItem.ActionItemId
import com.msawady.tandemtrack.models.Meeting.MeetingId

import java.time.ZonedDateTime

case class ActionItem(
  id: ActionItemId,
  title: String,
  description: String,
  status: ActionItem.Status,
  assignedTo: Option[User],
  dueDate: Option[ZonedDateTime],
  meetingId: Option[MeetingId],
)

object ActionItem {
  case class ActionItemId(value: String)

  enum Status {
    case Open
    case InProgress
    case Done
    case Canceled
  }
}
