import NativePackagerHelper._

enablePlugins(JavaAppPackaging, DockerPlugin)

name := "hello-akka-http"

version := "1.0"

scalaVersion := "2.12.8"

organization := "com.example"

libraryDependencies ++= {
  val akkaVersion = "2.5.3"
  Seq(
    "com.typesafe.akka" %% "akka-actor"    % akkaVersion,
    "com.typesafe.akka" %% "akka-stream"   % akkaVersion,
    "com.typesafe.akka" %% "akka-http"     % "10.0.9",
    "com.typesafe.akka" %% "akka-slf4j"    % akkaVersion,
    "org.slf4j"         %  "slf4j-log4j12" % "1.7.25"
  )
}

// ------------------------------------------------ //
// ------------- Kubernetes configmaps ------------ //
// ------------------------------------------------ //
// javaOptions in Universal ++= Seq(
//   "-Dconfig.file=/usr/local/etc/container.conf",
//   "-Dlog4j.configuration=file:/usr/local/etc/log4j.properties"
// )


// ------------------------------------------------ //
// ------------- Docker configuration ------------- //
// ------------------------------------------------ //

packageName in Docker := packageName.value

version in Docker := version.value

dockerExposedPorts := List(8001)

dockerLabels := Map("maintainer" -> "noreply@example.com")

dockerBaseImage := "openjdk"

dockerRepository := Some("index.docker.io")

dockerUsername := Some("aterefe/ordering-system")

defaultLinuxInstallLocation in Docker := "/usr/local"

daemonUser in Docker := "daemon"

mappings in Universal ++= directory( baseDirectory.value / "src" / "main" / "resources" )
