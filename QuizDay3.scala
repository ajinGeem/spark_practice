package org.yeardream.scala
import org.apache.spark.mllib.linalg._
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.stat.{MultivariateStatisticalSummary, Statistics}
import org.apache.spark.sql.{SaveMode, SparkSession, SQLContext}
import org.apache.spark.{SparkContext, SparkConf}

class QuizDay3 extends App {

//  val aggregatedDf2 = groupByDf2.agg(avg(col(colName = "depdelay")), avg(col(colName = "arrdelay")))
//  aggregatedDf2.limit(10).show()
//  val aggregateDf3 = groupByDf2.agg(stddev(col("depdelay")), stddev(col("arrdelay")))
//  aggregatedDf3.limit(10).show()
//  export SPARK_LOCAL_IP="127.0.0.1"
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

  val rdd = spark.sparkContext.textFile(path)
