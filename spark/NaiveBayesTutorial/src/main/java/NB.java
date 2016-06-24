import java.io.*;
import java.util.Arrays;
import org.apache.spark.api.java.*;
import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.function.*;
import org.apache.spark.mllib.linalg.Vectors;
import java.util.Iterator;
import org.apache.spark.mllib.regression.LabeledPoint;
import org.apache.spark.mllib.classification.*;
import scala.Tuple2;
import org.apache.spark.mllib.classification.NaiveBayes;
import org.apache.spark.mllib.classification.NaiveBayesModel;
import org.apache.spark.mllib.util.MLUtils;
import org.apache.spark.mllib.feature.HashingTF;
import org.apache.spark.mllib.classification.LogisticRegressionModel;
import org.apache.spark.mllib.classification.LogisticRegressionWithLBFGS;
import org.apache.spark.mllib.evaluation.BinaryClassificationMetrics;

public class NB implements Serializable {
  public static void main(String[] args) {
    SparkConf sparkConf = new SparkConf().setAppName("Naive Bayes");
    JavaSparkContext jsc = new JavaSparkContext(sparkConf);

    JavaRDD<LabeledPoint> trainingData = MLUtils.loadLibSVMFile(jsc.sc(), "train.svm").toJavaRDD();
    JavaRDD<LabeledPoint> testingData = MLUtils.loadLibSVMFile(jsc.sc(), "test.svm").toJavaRDD();

    final NaiveBayesModel model = NaiveBayes.train(trainingData.rdd(), 1.0);

    System.out.println("Number of classes: " + model.pi().length);
    for (double d : model.labels()) {
      System.out.println("class: " + d + " prior probability: " + Math.exp(model.pi()[(int) d]));
    }
    for (int i = 0; i < model.theta().length; i++) {
      System.out.println("\nConditional Probabilities for Class " + i);
      for (int j = 0; j < model.theta()[i].length; j++) {
        System.out.println("index " + j + ": " + Math.exp(model.theta()[i][j]));
      }
    }

   JavaPairRDD<Double, Double> predictionAndLabel = 
      testingData.mapToPair(new PairFunction<LabeledPoint, Double, Double>() {
        @Override
        public Tuple2<Double, Double> call(LabeledPoint p) {
          double[] probs = model.predictProbabilities(p.features()).toArray();
          System.out.println("\nTest: " + p.features());
          int max = 0;
          for (int i = 0; i < probs.length; i++) {
            max = (probs[i] > probs[max]) ? i : max;
            System.out.println("Class " + i + " Probability: " + probs[i]);
          }
          return new Tuple2<Double, Double>(new Double(max), p.label());
        }
      });

      double accuracy = predictionAndLabel.filter(new Function<Tuple2<Double, Double>, Boolean>() {
        @Override
        public Boolean call(Tuple2<Double, Double> pl) {
          // System.out.println(pl._1);
          return pl._1().equals(pl._2());
        }
      }).count() / (double) testingData.count();

      System.out.println("Accuracy: " + accuracy);


  }
}

