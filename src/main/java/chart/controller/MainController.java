package chart.controller;

import chart.Approximation.EulerMethod;
import chart.Approximation.OriginalFunction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class MainController {

    @FXML
    private Button buildY;

    @FXML
    private Button buildZ;

    @FXML
    private LineChart chartY;

    private XYChart.Series originalFunc;

    private XYChart.Series eulerFunc;


    @FXML
    private void initialize() {

        //chartY.setTitle("Y(x)");
        chartY.setCreateSymbols(false);
        originalFunc = new XYChart.Series();
        eulerFunc = new XYChart.Series();
        eulerFunc.setName("Явный метод Эйлера");
        originalFunc.setName("Базовое уравнение");
    }


    public void buildYx(MouseEvent mouseEvent) {

        //clearData();

        chartY.setTitle("Y(x)");
        EulerMethod eulerMethod = new EulerMethod();
        double[][] xs = eulerMethod.getApproximationPointsY();
        ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
        ObservableList<XYChart.Data> datas2 = FXCollections.observableArrayList();

        for(int i=0; i<xs.length; i++){
            datas.add(new XYChart.Data(xs[i][2],xs[i][0]));
        }

        double[][] xz = OriginalFunction.getArray();

        for(int i = 0; i< OriginalFunction.length; i++)
        {

            datas2.add(new XYChart.Data(xz[i][0],xz[i][1]));
        }



        originalFunc.setData(datas2);
        eulerFunc.setData(datas);
        chartY.getData().add(originalFunc);
        chartY.getData().add(eulerFunc);

    }

    public void buildZx(MouseEvent mouseEvent) {

        //clearData();

        chartY.setTitle("Z(x)");
        EulerMethod eulerMethod = new EulerMethod();
        double[][] xs = eulerMethod.getApproximationPointsY();
        ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
        ObservableList<XYChart.Data> datas2 = FXCollections.observableArrayList();

        for(int i=0; i<xs.length; i++){
            datas.add(new XYChart.Data(xs[i][2],xs[i][1]));
        }

        double[][] xz = OriginalFunction.getArrayZ();

        for(int i = 0; i< OriginalFunction.length; i++)
        {

            datas2.add(new XYChart.Data(xz[i][0],xz[i][1]));
        }



        originalFunc.setData(datas2);
        eulerFunc.setData(datas);
        chartY.getData().add(originalFunc);
        chartY.getData().add(eulerFunc);

    }

    private void clearData()
    {
        originalFunc.getData().clear();
        eulerFunc.getData().clear();
        chartY.getData().clear();
    }
}
