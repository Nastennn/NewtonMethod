package Graph;

import org.jfree.data.function.Function2D;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class Dataset {
    private XYSeries points;
    private XYSeries first;
    private XYSeries second;

    public XYDataset createDataset() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(points);
        dataset.addSeries(first);
        dataset.addSeries(second);
        return dataset;
    }

    public void createDatasetPoints(double[] x, double[] y) {
        final XYSeries series = new XYSeries("Исходные точки");
        for (int i = 0; i < x.length; i++) {
            series.add(x[i], y[i]);
        }
        points = series;
    }

    public void createDatasetFirst(Function2D func2D){
        first = DatasetUtilities.sampleFunction2DToSeries(func2D,
                points.getMinX(),
                points.getMaxX(),
                100,
                "Исходная функция");
    }

    public void createDatasetSecond(Function2D func2D){
        second = DatasetUtilities.sampleFunction2DToSeries(func2D,
                points.getMinX(),
                points.getMaxX(),
                100,
                "Интерполяция");
    }


}
