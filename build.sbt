name := "iqo-server"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  "org.springframework.boot" % "spring-boot-starter-web" % "1.5.13.RELEASE",

  "org.springframework" % "spring-jdbc" % "4.3.17.RELEASE",
  "org.springframework" % "spring-tx" % "4.3.17.RELEASE",
  "org.apache.tomcat" % "tomcat-jdbc" % "8.5.31",
  "org.xerial" % "sqlite-jdbc" % "3.15.1",
  "org.flywaydb" % "flyway-core" % "4.1.1",

  "com.fasterxml.jackson.core" % "jackson-databind" % "2.8.11",
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.8.11",

  "org.apache.commons" % "commons-lang3" % "3.0"
)

cancelable in Global := true
