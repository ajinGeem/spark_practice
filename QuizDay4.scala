package org.yeardream.scala
import org.apache.spark.mllib.linalg._
import org.apache.spark.mllib.stat.{MultivariateStatisticalSummary, Statistics}
import org.apache.spark.sql.{SaveMode, SparkSession, SQLContext}
import org.apache.spark.{SparkContext, SparkConf}
class QuizDay4 extends App {

  val dataPath = System.getenv("SPARK_DATA")
  val path = s"${dataPath}/input/2008.csv"
  val planeDataPath = s"${dataPath}/metadata/plane-data.csv"
  
  val spark = SparkSession.builder.getOrCreate()
  val df = spark.read.format("csv").option("header", "true").load(path)
 
  val delayTypes = List("CarrierDelay", "WeatherDelay", "NASDelay", "SecurityDelay", "LateAircraftDelay")

  delayTypes.foreach { delayType =>
  val correlation = df.stat.corr(delayType, "DepDelay")
  println(s"The correlation between $delayType and DepDelay is $correlation")
}

  val airports = df.select("Origin").distinct.collect.flatMap(_.toSeq)

  airports.foreach { airport =>
  println(s"Airport: $airport")
  val dfAirport = df.filter(df("Origin") === airport)
  delayTypes.foreach { delayType =>
    val correlation = dfAirport.stat.corr(delayType, "DepDelay")
    println(s"The correlation between $delayType and DepDelay at $airport is $correlation")
  }
}

  import org.apache.spark.sql.SparkSession

  val spark = SparkSession.builder.appName("Airline Data Analysis").getOrCreate()

  val airlineData = spark.read.format("csv").option("header", "true").load(path)
  val planeData = spark.read.format("csv").option("header", "true").load(planeDataPath)

  val joinedData = airlineData.join(planeData, airlineData("TailNum") === planeData("tailnum"))

  val groupedData = joinedData.groupBy("manufacturer", "model", "issue_date").agg(countDistinct("tailnum").alias("usage_count"))

  groupedData.show()
  
}
