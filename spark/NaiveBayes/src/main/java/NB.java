import java.io.*;
import java.util.Arrays;
import org.apache.spark.api.java.*;
import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.function.*;
import org.apache.spark.mllib.linalg.Vector;
import java.util.Iterator;
import org.apache.spark.mllib.regression.LabeledPoint;
import org.apache.spark.mllib.classification.*;
import scala.Tuple2;
import org.apache.spark.mllib.classification.NaiveBayes;
import org.apache.spark.mllib.classification.NaiveBayesModel;
import org.apache.spark.mllib.util.MLUtils;
import org.apache.spark.mllib.feature.HashingTF;
import org.apache.spark.mllib.feature.IDF;
import org.apache.spark.mllib.feature.IDFModel;
import org.apache.spark.mllib.classification.LogisticRegressionModel;
import org.apache.spark.mllib.classification.LogisticRegressionWithLBFGS;
import org.apache.spark.mllib.evaluation.BinaryClassificationMetrics;

public class NB implements Serializable {
  public static void main(String[] args) {
    SparkConf sparkConf = new SparkConf().setAppName("Naive Bayes");
    JavaSparkContext sc = new JavaSparkContext(sparkConf);

    String posPath = "file path for pos training data";
    String negPath = "file path for neg training data";
    String testPosPath = "file path for pos testing data";
    String testNegPath = "file path for neg testing data";
    JavaRDD<String> pos = sc.textFile(posPath);
    JavaRDD<String> neg = sc.textFile(negPath);
    JavaRDD<String> testpos = sc.textFile(testPosPath);
    JavaRDD<String> testneg = sc.textFile(testNegPath);

    NB obj = new NB();
    JavaRDD<LabeledPoint> posData = obj.getLabeledPoint(pos, 1, false);
    JavaRDD<LabeledPoint> negData = obj.getLabeledPoint(neg, 0, false);
    JavaRDD<LabeledPoint> trainingData = posData.union(negData);
    JavaRDD<LabeledPoint> testposData = obj.getLabeledPoint(testpos, 1, false);
    JavaRDD<LabeledPoint> testnegData = obj.getLabeledPoint(testneg, 0, false);
    JavaRDD<LabeledPoint> testingData = testposData.union(testnegData);
    final NaiveBayesModel model = NaiveBayes.train(trainingData.rdd(), 1.0);

    JavaPairRDD<Double, Double> predictionAndLabel =
      testingData.mapToPair(new PairFunction<LabeledPoint, Double, Double>() {
        @Override
        public Tuple2<Double, Double> call(LabeledPoint p) {
          return new Tuple2<Double, Double>(model.predict(p.features()), p.label());
        }
      });

      double accuracy = predictionAndLabel.filter(new Function<Tuple2<Double, Double>, Boolean>() {
        @Override
        public Boolean call(Tuple2<Double, Double> pl) {
          // System.out.println(pl._1);
          return pl._1().equals(pl._2());
        }
      }).count() / (double) testingData.count();
      System.out.println(accuracy);
  }


  JavaRDD<LabeledPoint> getLabeledPoint(JavaRDD<String> srdd, int label, boolean useidf) {
    final HashingTF hashingTF = new HashingTF();
    final IDF idf = new IDF();
    final int l = label;

    if (useidf) {
      /* calculate term frequencies */
      JavaRDD<Vector> tf = srdd.map(new Function<String, Vector>() {
        @Override
        public Vector call(String line) {
          WordParser p = new WordParser(line);
          return hashingTF.transform(Arrays.asList(p.parse()));
        }
      });

      tf.cache();
      /* calculate inverse document frequencies */
      final IDFModel idfModel = idf.fit(tf);
      /* create tf-idf vector */
      JavaRDD<Vector> tfidf = idfModel.transform(tf);

      /* convert RDD of tfidf Vectors to RDD of LabeledPoints */
      JavaRDD<LabeledPoint> result = tfidf.map(new Function<Vector, LabeledPoint>() {
        @Override
        public LabeledPoint call(Vector v) {
          return new LabeledPoint(l, v);
        }
      });
      return result;
    }
    else {
      return srdd.map(new Function<String, LabeledPoint>() {
        @Override
        public LabeledPoint call(String line) {
          WordParser p = new WordParser(line);
          return new LabeledPoint(l, hashingTF.transform(Arrays.asList(p.parse())));
          // return new LabeledPoint(l, hashingTF.transform(Arrays.asList(line.toCharArray())));
        }
      });
    }
  }





}
