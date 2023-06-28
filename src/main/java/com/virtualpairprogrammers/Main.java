package com.virtualpairprogrammers;

import javassist.expr.Cast;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StringType;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import scala.Char;
import scala.Function;
import scala.Serializable;

import org.apache.spark.sql.functions.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> inputData = new ArrayList<>();
        System.setProperty("hadoop.home.dir", "C:/hadoop");
        Logger.getLogger("org.apache").setLevel(Level.WARN);
        SparkSession spark = SparkSession.builder().appName("testingSql").master("local[*]").getOrCreate();




        Dataset<Row> dataset = spark.read().option("header", "true").csv("src/main/resources/exercise1info");

        dataset.show();

        dataset = dataset.withColumn("split", functions.expr("split(VALUES, Delimiter)"));



        dataset.printSchema();
        dataset.show();












//        dataset = dataset.groupBy("subject").pivot("year").agg(  round(  avg(("score")),2).alias("avg score") ,
//                                                                          round(stddev(("score")),2).alias("std deviation"));


//        Dataset<Row> results = spark.sql
//        ("select level, date_format(datetime, 'MMMM') as month, count(1) as total " +
//        "from logging_table group by level, month order by cast(first(date_format(datetime,'M')) as int), level");

//        dataset = dataset.select(col("level"), date_format(col("datetime"), "MMMM").as("month"),
//                date_format(col("datetime"), "M").alias("monthnum").cast(DataTypes.IntegerType));
//
//
//        dataset = dataset.groupBy(col("level"), col("month"),col("monthnum")).count();
//        dataset = dataset.orderBy("monthnum", "level");
//        dataset = dataset.drop("monthnum");


//        dataset.show(100);


       spark.close();






    }
}
