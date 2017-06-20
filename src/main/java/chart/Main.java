package chart;

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
        primaryStage.setTitle("JavaFX Chart (Series)");

        NumberAxis x = new NumberAxis();
        NumberAxis y = new NumberAxis();

        LineChart<Number, Number> numberLineChart = new LineChart<Number, Number>(x,y);
        numberLineChart.setTitle("Series");
        numberLineChart.setCreateSymbols(false);
        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();

        series2.setName("cos(x)");
        series1.setName("sin(x)");

        ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
        ObservableList<XYChart.Data> datas2 = FXCollections.observableArrayList();
        for(int xx=0; xx<10; xx++){

            for (int i=0;i<100;i++){

            Double d = ((double)i) /100;
            datas.add(new XYChart.Data(xx + d,Math.sin(xx + d)));
            }
            datas2.add(new XYChart.Data(xx,Math.sin(xx)));
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