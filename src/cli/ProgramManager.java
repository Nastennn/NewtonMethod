package cli;



import Graph.Dataset;
import Graph.Graph;
import computations.Function;
import org.jfree.data.function.Function2D;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import static org.jfree.ui.RefineryUtilities.centerFrameOnScreen;

public class ProgramManager {
    ReaderCLI reader;
    Writer writer;
    Function function;
    int intervalNum;
    Function2D function2D;
    Dataset dataset;

    public ProgramManager(InputStream in, OutputStream out) {
        reader = new ReaderCLI(new Scanner(in));
        writer = new Writer(out);
        function = new Function();
        dataset = new Dataset();
    }

    public void start() {
        System.out.println("Интерполяция методом Ньютона функции - f(x) = x^3 - 3*x^2 - 8*|x|");
        System.out.println("Выберите промежуток и количество точек для интерполирования:");
        writer.writeIntervals();
        intervalNum = reader.readInt();
        if(intervalNum == 1 || intervalNum == 2 || intervalNum== 3|| intervalNum == 4){
            function2D = function.comp(intervalNum);
        }
        System.out.println("Найти значение y? (д/н)");
        if(reader.isAnswerIsYes()){
            System.out.println("Введите x: ");
            double x = reader.readDouble();
            double y = function2D.getValue(x);
            System.out.println("Значение y в х = " + x + " равно " + y);
            System.out.println("Действительное значение y = " + function.func(x));
        }
        dataset.createDatasetPoints(function.getX(), function.getY());
        dataset.createDatasetFirst(x -> function.func(x));
        dataset.createDatasetSecond(function2D);
        Graph graph = new Graph("Интерполяция методом Ньютона", dataset.createDataset());
        graph.createGraphic();
        graph.pack();
        centerFrameOnScreen(graph);
        graph.setVisible(true);
    }


}
