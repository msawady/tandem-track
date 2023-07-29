package com.msawady.tandemtrack.models

import com.msawady.tandemtrack.models.User.UserId

case class User(id: UserId, name: String, email: String)

object User {

  case class UserId(value: String)

}
