package com.msawady.tandemtrack.db

import cats.effect.IO
import cats.syntax.all.*
import com.msawady.tandemtrack.models.User
import com.msawady.tandemtrack.models.User.UserId
import skunk.*
import skunk.data.*
import skunk.codec.*
import skunk.codec.all.varchar
import skunk.implicits.*

object UserDao {

  val idCodec: Codec[UserId] = Codec.simple(_.value, _.toString.asRight.map(UserId.apply), Type.varchar)
  val userCodec: Codec[User] = (idCodec *: varchar *: varchar).to[User]

  def insert(user: User): IO[Unit] = {
    val enc = userCodec.values
    val c = sql"""
          INSERT INTO "user" (id, name, email)
          VALUES $userCodec.values
          """.command
    SkunkSession.session.use(s => s.prepare(c).flatMap(_.execute(user))).void
  }

  def findById(id: UserId): IO[Option[User]] = {
    val q: Query[UserId, Option[User]] =
      sql"""
          SELECT * FROM "user" WHERE id = $idCodec
          """.query(userCodec.opt)
    SkunkSession.session.use(s => s.prepare(q).flatMap(q => q.unique(id)))
  }

  def deleteById(id: UserId): IO[Unit] = {
    val q: Command[UserId] =
      sql"""
          DELETE FROM "user" WHERE id = $idCodec
          """.command
    SkunkSession.session.use(s => s.prepare(q).flatMap(_.execute(id))).void
  }
}
