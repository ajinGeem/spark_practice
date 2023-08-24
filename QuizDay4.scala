package org.yeardream.scala
import org.apache.spark.mllib.linalg._
import org.apache.spark.mllib.stat.{MultivariateStatisticalSummary, Statistics}
import org.apache.spark.sql.{SaveMode, SparkSession, SQLContext}
import org.apache.spark.{SparkContext, SparkConf}
class QuizDay4 extends App {
  val sparkHome = System.getenv("SPARK_HOME")
  val logDir = s"file:${sparkHome}/event"
  val spark = SparkSession.builder()
    .master("local[1]")
    .appName("SparkExample")
    .config("spark.eventLog.enabled", "true")
    .config("spark.eventLog.dir", logDir)
    .getOrCreate();

  val sc = spark.sparkContext

  val dataPath = System.getenv("SPARK_DATA")
  val path = s"${dataPath}/input/2008.csv"
  val planeDataPath = s"${dataPath}/metadata/plane-data.csv"

}
