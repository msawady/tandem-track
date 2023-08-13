package com.msawady.tandemtrack.db

import com.msawady.tandemtrack.models.User
import com.msawady.tandemtrack.models.User.UserId
import munit.CatsEffectSuite

class UserDaoTest extends CatsEffectSuite {

  test("UserDaoTest") {
    val user  = User(UserId("id1"), "name", "email1")
    assertIO(UserDao.insert(user), ())
    assertIO(UserDao.findById(UserId("id1")), Some(user))
    assertIO(UserDao.deleteById(UserId("id1")), ())
    assertIO(UserDao.findById(UserId("id1")), None) // FIXME: failing with skunk.exception.ColumnAlignmentException
  }
}
