package cli;

import java.io.OutputStream;
import java.io.PrintWriter;

public class Writer {
    PrintWriter writer;

    public Writer(OutputStream os) {
        writer = new PrintWriter(os);
    }

    public void writeIntervals() {
        System.out.println("1 - 3 точки на промежутке [0; 10]");
        System.out.println("2 - 6 точек на промежутке [0; 10]");
        System.out.println("3 - 6 точек на промежутке [0; 10] с измененным значением y");
        System.out.println("4 - 10 точек на промежутке [0; 90]");
    }



}
