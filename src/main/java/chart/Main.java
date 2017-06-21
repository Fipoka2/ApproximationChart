package chart;

import chart.Approximation.EulerMethod;
import chart.Approximation.OriginalFunction;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/hello.fxml"));
        primaryStage.setTitle("Атландида 2.0");

        NumberAxis x = new NumberAxis();
        NumberAxis y = new NumberAxis();

        LineChart<Number, Number> numberLineChart = new LineChart<Number, Number>(x,y);
        numberLineChart.setTitle("Y(x)");
        numberLineChart.setCreateSymbols(false);
        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();

        series1.setName("Явный метод Эйлера");
        series2.setName("Базовое уравнение");

        EulerMethod eulerMethod = new EulerMethod();
        double[][] xs = eulerMethod.getApproximationPointsY();


        ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
        ObservableList<XYChart.Data> datas2 = FXCollections.observableArrayList();
        for(int i=0; i<xs.length; i++){
            datas.add(new XYChart.Data(xs[i][2],xs[i][1]));
        }
        for(int i = 0; i< OriginalFunction.length;i++)
        {
            double[][] xz = OriginalFunction.getArrayZ();
            datas2.add(new XYChart.Data(xz[i][0],xz[i][1]));
        }

        series1.setData(datas);
        series2.setData(datas2);


        Scene scene = new Scene(numberLineChart, 600,600);
        numberLineChart.getData().add(series1);
        numberLineChart.getData().add(series2);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

}
