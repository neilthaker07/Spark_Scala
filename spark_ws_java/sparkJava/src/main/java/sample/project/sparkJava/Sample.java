package sample.project.sparkJava;

import scala.Tuple2;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.spark.sql.SparkSession;

public class Sample {

	private static final Pattern SPACE = Pattern.compile(" ");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String logFile = "/home/neil/Desktop/spark-2.2.0-bin-hadoop2.7/README.md";

		SparkSession spark = SparkSession.builder().master("local")
				.appName("Java Word Count")
				.config("spark.some.config.option", "some-value").getOrCreate();

		JavaRDD<String> lines = spark.read().textFile(logFile).javaRDD();

		JavaRDD<String> words = lines.flatMap(s -> Arrays
				.asList(SPACE.split(s)).iterator());

		JavaPairRDD<String, Integer> ones = words.mapToPair(s -> new Tuple2<>(
				s, 1));

		JavaPairRDD<String, Integer> counts = ones.reduceByKey((i1, i2) -> i1
				+ i2);

		List<Tuple2<String, Integer>> output = counts.collect();

		for (Tuple2<?, ?> tuple : output) {
			System.out.println(tuple._1() + ": " + tuple._2());
		}
		spark.stop();
	}
}