package scripts;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.chart.*;
import javafx.util.Duration;

import java.util.*;

public class ChartGenerator
{
    public static LineChart createLineChart(String title,String xAxisTitle, String yAxisTitle, ArrayList<String> lineTitles, ArrayList<LinkedHashMap> values)
    {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel(xAxisTitle);
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel(yAxisTitle);

        LineChart<String, Number> lineChart = new LineChart(xAxis, yAxis);
        lineChart.setTitle(title);

        for (int i = 0; i < lineTitles.size(); i++)
        {
            XYChart.Series series = new XYChart.Series();
            series.setName(lineTitles.get(i));

            LinkedHashMap lineValues = values.get(i);

            for (int j = 0; j < lineValues.size(); j++)
            {
                Object key = lineValues.keySet().toArray()[j];
                series.getData().add(new XYChart.Data(key, lineValues.get(key)));
            }

            lineChart.getData().add(series);
        }

        lineChart.getStylesheets().add("/style/Misc/Charts.css");
        lineChart.setAnimated(true);
        return lineChart;
    }

    public static AreaChart createAreaChart(String title,String xAxisTitle, String yAxisTitle, ArrayList<String> lineTitles, ArrayList<LinkedHashMap> values)
    {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel(xAxisTitle);
        xAxis.setTickLabelRotation(45);
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel(yAxisTitle);
        AreaChart<String, Number> areaChart = new AreaChart(xAxis, yAxis);

        areaChart.setTitle(title);

        float highestVal = 0;
        for (int i = 0; i < lineTitles.size(); i++)
        {
            XYChart.Series series = new XYChart.Series();
            series.setName(lineTitles.get(i));

            LinkedHashMap lineValues = values.get(i);

            for (int j = 0; j < lineValues.size(); j++)
            {
                Object key = lineValues.keySet().toArray()[j];
                series.getData().add(new XYChart.Data(key, (Float)lineValues.get(key)/100));
                highestVal = ((Float)lineValues.get(key) > highestVal) ? (Float)lineValues.get(key) : highestVal;
            }

            areaChart.getData().add(series);
        }

        yAxis.setAutoRanging(false);
        yAxis.setUpperBound(Math.round(highestVal * 1.2));

        Timeline timeline = new Timeline();

        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(20000),
                new EventHandler<ActionEvent>()
                {
                    @Override public void handle(ActionEvent actionEvent)
                    {
                        for (XYChart.Series<String, Number> series : areaChart.getData())
                        {
                            for (XYChart.Data<String, Number> data : series.getData())
                            {
                                data.setYValue(data.getYValue().floatValue()*100);
                            }
                        }
                    }
                }));
        timeline.setRate(500);
        timeline.play();

        areaChart.getStylesheets().add("/style/Misc/Charts.css");
        areaChart.setAnimated(true);
        return areaChart;
    }

    public static BarChart createBarChart(String title, String xAxisLabel, String yAxisTitle, LinkedHashMap<String, Number> values)
    {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel(xAxisLabel);
        yAxis.setLabel(yAxisTitle);
        yAxis.setAutoRanging(false);

        BarChart<String, Number> barChart = new BarChart(xAxis, yAxis);
        barChart.setTitle(title);

        XYChart.Series series = new XYChart.Series();

        float highestVal = 0;

        for (Object key: values.keySet())
        {
            series.getData().add(new XYChart.Data(key, (Float)values.get(key)/100));
            highestVal = ((Float)values.get(key) > highestVal) ? (Float)values.get(key) : highestVal;
        }

        yAxis.setUpperBound(Math.round(highestVal * 1.2));
        barChart.getData().add(series);
        barChart.getStylesheets().add("/style/Misc/Charts.css");
        barChart.setAnimated(true);
        barChart.setLegendVisible(false);

        Timeline timeline = new Timeline();

        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(20000),
                new EventHandler<ActionEvent>()
                {
                    @Override public void handle(ActionEvent actionEvent)
                    {
                        for (XYChart.Series<String, Number> series : barChart.getData())
                        {
                            for (XYChart.Data<String, Number> data : series.getData())
                            {
                                data.setYValue(data.getYValue().floatValue()*100);
                            }
                        }
                    }
                }));
        timeline.setRate(500);
        timeline.play();

        return barChart;
    }

    public static StackedBarChart createStackedBarChart(String title, String xAxisLabel, String yAxisTitle, String[] types, LinkedHashMap<Object, Float>[] data)
    {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        yAxis.setMinorTickVisible(false);

        List categories = new ArrayList();
        ArrayList<XYChart.Series> stacks = new ArrayList<>();

        for (Object key: data[0].keySet())
        {
            categories.add(key.toString());
        }

        xAxis.setTickLabelRotation(45);
        xAxis.setCategories(FXCollections.<String>observableArrayList(categories));
        xAxis.setLabel(xAxisLabel);
        yAxis.setLabel(yAxisTitle);

        StackedBarChart<String, Number> stackedBarChart = new StackedBarChart(xAxis, yAxis);
        stackedBarChart.setTitle(title);

        int currentSeries = 0;
        float highestVal = 0;

        for (LinkedHashMap dataSet: data)
        {
            XYChart.Series series = new XYChart.Series();
            series.setName(types[currentSeries]);

            for (Object key : dataSet.keySet())
            {
                highestVal = ((Float)dataSet.get(key) > highestVal) ? (Float)dataSet.get(key) : highestVal;
                series.getData().add(new XYChart.Data<>(key, ((Float)dataSet.get(key))/100.0));
            }

            currentSeries++;
            stacks.add(series);
        }

        for (XYChart.Series series : stacks)
            stackedBarChart.getData().add(series);

        yAxis.setAutoRanging(false);
        yAxis.setUpperBound(Math.round(highestVal * 2));

        Timeline timeline = new Timeline();

        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(20000),
                new EventHandler<ActionEvent>()
                {
                    @Override public void handle(ActionEvent actionEvent)
                    {
                        for (XYChart.Series<String, Number> series : stackedBarChart.getData())
                        {
                            for (XYChart.Data<String, Number> data : series.getData())
                            {
                                data.setYValue(data.getYValue().floatValue()*100);
                            }
                        }
                    }
                }));
        timeline.setRate(50);
        timeline.play();

        stackedBarChart.getStylesheets().add("/style/Misc/Charts.css");
        stackedBarChart.setAnimated(true);
        return stackedBarChart;
    }
}
