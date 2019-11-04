package chartadvancedscatter;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ChartAdvancedScatter extends Application {

    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));
        root.getChildren().add(createChart());
    }

    protected ScatterChart<Number, Number> createChart() {
        final NumberAxis xAxis = new NumberAxis();
        xAxis.setSide(Side.TOP);
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setSide(Side.RIGHT);
        final ScatterChart<Number,Number> sc = new ScatterChart<Number,Number>(xAxis,yAxis);
        // setup chart
        xAxis.setLabel("X Axis");
        yAxis.setLabel("Y Axis");
       XYChart.Series<Number, Number> series1 = new XYChart.Series<Number, Number>();
        //a)
        series1.setName("f(x)=0");
        for (int i=0; i<5; i++) series1.getData().add(new XYChart.Data<Number, Number>(i, 0));

        //b)
        XYChart.Series<Number, Number> series2 = new XYChart.Series<Number, Number>();
        series2.setName("f(x)=-x^2");
        for (int i=-5; i<5; i++) series2.getData().add(new XYChart.Data<Number, Number>(i, -Math.pow(i, 2)));

        //c)
        XYChart.Series<Number, Number> series3 = new XYChart.Series<Number, Number>();
        series3.setName("f(x)=x^2-x+3");
        for (int i=-5; i<5; i++) series3.getData().add(new XYChart.Data<Number, Number>(i, Math.pow(i, 2)-i+3));

        sc.getData().addAll(series1, series2, series3);

        return sc;
    }

    @Override public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX 
     * application. main() serves only as fallback in case the 
     * application can not be launched through deployment artifacts,
     * e.g., in IDEs with limited FX support. NetBeans ignores main().
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
