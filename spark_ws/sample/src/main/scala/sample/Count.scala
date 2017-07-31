package sample

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object Count {
  def main(args: Array[String]) {
    
    val logFile = "/home/neil/Desktop/spark-2.2.0-bin-hadoop2.7/README.md"
    val conf = new SparkConf().setAppName("Simple App").setMaster("local[*]")
    val sc = new SparkContext(conf)
    
    val logData =  sc.textFile(logFile, 2).cache() 
    
    val counts = logData.flatMap(line => line.split(" "))
                 .map(word => (word, 1))
                 .reduceByKey(_ + _)
    counts.saveAsTextFile("/home/neil/Desktop/abc")
  }
}