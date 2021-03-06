package sample.project.sparkJava;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SparkSession;
import org.easyrules.api.RulesEngine;
import org.easyrules.core.RulesEngineBuilder;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SparkSession spark = SparkSession.builder().master("local")
				.appName("Rule Engine")
				.config("spark.some.config.option", "some-value").getOrCreate();
  
		String inputFile = "/home/neil/Neil_Work/MS_SJSU/scala_spark_learning/Spark_Scala/spark_ws_java/inputfile.json";

		SQLContext sqlContext = new org.apache.spark.sql.SQLContext(spark);

		Dataset<Row> people = sqlContext.read().json(inputFile);
		people.printSchema();
		people.groupBy("LOG_ID");
		people.createOrReplaceTempView("people");	
		
		for(int i=2;i<=13;i++)
		{
			RuleEngine ruleLocal = new RuleEngine();

			Dataset<Row> pressure = spark.sql("SELECT PRESSURE FROM people WHERE LOG_ID="+i);
			Dataset<Row> temperature = spark.sql("SELECT TEMPERATURE FROM people WHERE LOG_ID="+i);
			/*pressure.show();
			temperature.show();
			*/
			//System.out.println(pressure.col("PRESSURE")+" "+pressure.head());
			
			int q = (int) (pressure.head()).getLong(0);
			ruleLocal.setPressure(q);
			
			int r = (int)(temperature.head()).getLong(0);
			ruleLocal.setTemperature(r);
			
			ruleLocal.setId(i);
		
			RulesEngine rulesEngine = RulesEngineBuilder.aNewRulesEngine().build();
			rulesEngine.registerRule(ruleLocal);
			rulesEngine.fireRules();
		}
		spark.stop();
		/*
		List<String> jsonData = Arrays.asList(
		        "{\"name\":\"Yin\",\"address\":{\"city\":\"Columbus\",\"state\":\"Ohio\"}}");
		Dataset<String> anotherPeopleDataset = spark.createDataset(jsonData, Encoders.STRING());
		Dataset<Row> anotherPeople = spark.read().json(anotherPeopleDataset);
		anotherPeople.show();
		*/
		//JavaRDD<Row> lines = spark.read().json(inputFile).javaRDD();
		/*
		JavaRDD<Object> words = lines.flatMap(s -> Arrays
				.asList(SPACE.split(s)).iterator());

		JavaPairRDD<String, Integer> ones = words.mapToPair(s -> new Tuple2<>(
				s, 1));

		JavaPairRDD<String, Integer> counts = ones.reduceByKey((i1, i2) -> i1
				+ i2);
*/
	}

}
