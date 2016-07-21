organization := "tv.cntt"
name         := "mydit"
version      := "1.7-SNAPSHOT"

scalaVersion := "2.11.8"

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked")
javacOptions  ++= Seq("-source", "1.8", "-target", "1.8")

//------------------------------------------------------------------------------

// jul-to-slf4j: mysql-binlog-connector-java logs to JUL
// janino:       for writing condition in logback.xml
libraryDependencies += "ch.qos.logback"      % "logback-classic"   % "1.1.3"
libraryDependencies += "org.slf4j"           % "jul-to-slf4j"      % "1.7.12"
libraryDependencies += "org.codehaus.janino" % "janino"            % "2.7.8"

libraryDependencies += "com.typesafe" % "config" % "1.3.0"

libraryDependencies += "mysql"             % "mysql-connector-java"        % "5.1.35"
libraryDependencies += "com.github.shyiko" % "mysql-binlog-connector-java" % "0.1.3"

libraryDependencies += "org.mongodb" % "mongo-java-driver" % "2.13.0"

//EclipseKeys.withSource := true

// Put config directory in classpath for easier development --------------------

// For "sbt console"
unmanagedClasspath in Compile <+= (baseDirectory) map { bd => Attributed.blank(bd / "config") }

// For "sbt run"
unmanagedClasspath in Runtime <+= (baseDirectory) map { bd => Attributed.blank(bd / "config") }

// Copy these to target/xitrum when sbt xitrum-package is run
XitrumPackage.copy("config", "script")
