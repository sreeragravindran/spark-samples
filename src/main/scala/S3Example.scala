import com.databricks.spark.csv
import org.apache.spark._
import org.apache.spark.sql.{SQLContext, SparkSession}

object S3Example {

  def main(args: Array[String]): Unit = {

    val accessKeyId = "";
    val secretAccessKey = "";

    val spark = SparkSession
      .builder
      .appName("s3Example")
      .master("local[*]")
      //.config("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
      .config("spark.hadoop.fs.s3a.access.key", accessKeyId)
      .config("spark.hadoop.fs.s3a.secret.key", secretAccessKey)
//      .config("spark.hadoop.fs.s3a.impl", "org.apache.hadoop.fs.s3a.S3AFileSystem")
//      .config("spark.hadoop.fs.s3a.multiobjectdelete.enable","false")
//      .config("spark.hadoop.fs.s3a.fast.upload","true")
//      .config("spark.sql.parquet.filterPushdown", "true")
//      .config("spark.sql.parquet.mergeSchema", "false")
//      .config("spark.hadoop.mapreduce.fileoutputcommitter.algorithm.version", "2")
//      .config("spark.speculation", "false")
      .getOrCreate

    case class Clubcard(clubcardNumber: String, uuid: String);

    val myRdd = spark.read
      .format("csv")
      .option("sep", ",")
      .option("header", false)
      .option("mode", "DROPMALFORMED")
      //.schema(Clubcard)
      .load("s3a://identity-reconciliation/NGC.csv");



    println(myRdd.count());

  }

}
