val Http4sVersion = "0.23.23"
val MunitVersion = "0.7.29"
val LogbackVersion = "1.4.8"
val MunitCatsEffectVersion = "1.0.7"
val TapirVersion = "1.6.4"
val SkunkVersion = "0.6.0"

lazy val root = (project in file("."))
  .settings(
    organization := "com.msawady",
    name := "tandem-track",
    version := "0.0.1-SNAPSHOT",
    scalaVersion := "3.3.0",
    libraryDependencies ++= Seq(
      "org.http4s" %% "http4s-ember-server" % Http4sVersion,
      "org.http4s" %% "http4s-ember-client" % Http4sVersion,
      "org.http4s" %% "http4s-circe" % Http4sVersion,
      "org.http4s" %% "http4s-dsl" % Http4sVersion,
      "org.scalameta" %% "munit" % MunitVersion % Test,
      "org.typelevel" %% "munit-cats-effect-3" % MunitCatsEffectVersion % Test,
      "ch.qos.logback" % "logback-classic" % LogbackVersion,
      "com.softwaremill.sttp.tapir" %% "tapir-core" % TapirVersion,
      "com.softwaremill.sttp.tapir" %% "tapir-json-circe" % TapirVersion,
      "com.softwaremill.sttp.tapir" %% "tapir-http4s-server" % TapirVersion,
      "com.softwaremill.sttp.tapir" %% "tapir-redoc-bundle" % TapirVersion,
      "com.softwaremill.sttp.tapir" %% "tapir-enumeratum" % TapirVersion,
      "org.tpolecat" %% "skunk-core" % SkunkVersion
    ),
    assembly / assemblyMergeStrategy := {
      case "module-info.class" => MergeStrategy.discard
      case x                   => (assembly / assemblyMergeStrategy).value.apply(x)
    }
  )
