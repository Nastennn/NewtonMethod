package computations;

import org.jfree.data.function.Function2D;

public class Function {

    double[] X;
    double[] Y;

    public double func(double x){
        return Math.pow(Math.sin(x), 3);
    }

    public Function2D comp(int intervalNum){
    X = getInterval(intervalNum);
    Y = new double[X.length];
    for( int i = 0; i< X.length; i++){
        Y[i] = func(X[i]);
    }
    if(intervalNum == 3){
        Y[3] =100;
    }
    NewtonMethod interpolation = new NewtonMethod();
    Function2D function = interpolation.getValue(X, Y);
    return function;
    }

    public double[] getInterval(int intervalNum){
        double[] array;
        switch (intervalNum){
            case(1):
                array = new double[]{0, 5, 10};
                break;
            case(2):
            case(3):
                array =  new double[]{0, 2, 4, 6, 8, 10};
                break;
            case(4):
                array =  new double[]{0, 10, 20, 30, 40, 50, 60, 70, 80, 90};
                break;
            default:
                array = new double[]{};
        }
        return array;
    }

    public double[] getX() {
        return X;
    }

    public double[] getY() {
        return Y;
    }
}
