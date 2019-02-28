lazy val root = (project in file(".")).
  settings(
    name := "spark-samples",
    version := "1.0",
    scalaVersion := "2.11.12",
    mainClass in Compile := Some("S3Example")
  )

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.4.0",
  "org.apache.spark" %% "spark-streaming" % "2.4.0",
  "org.apache.spark" %% "spark-sql" % "2.4.0",
  "com.couchbase.client" %% "spark-connector" % "2.2.0",
  "com.databricks" %% "spark-csv" % "1.3.0",
  "org.apache.hadoop" % "hadoop-aws" % "2.7.2"
)

// META-INF discarding
assemblyMergeStrategy in assembly := {
       case PathList("META-INF", xs @ _*) => MergeStrategy.discard
       case x => MergeStrategy.first
   }


