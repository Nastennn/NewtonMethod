package computations;


import org.jfree.data.function.Function2D;

public class NewtonMethod {
    public Function2D getValue(double[] X, double[] Y) {
        double[] divDiff = new double[X.length - 1];
        for (int i = 0; i < divDiff.length; i++) {
            divDiff[i] = divDif(X, Y, 0, i +1);
        }

        return x ->{

            double res = Y[0];
            double differX=1;
            for (int i = 0; i < divDiff.length; i++) {
                res += divDiff[i] * (x - X[0])*differX;
                differX = 1;
                for (int j = 1; j <= i+1; j++ )
                    differX *= (x - X[j]);
            }
            return res;
        };

    }


    public double divDif(double[] X, double[] Y, int start, int end) {
        if(end - start ==1) return ((Y[end]-Y[start]) / (X[end]-X[start]));
        return (divDif(X, Y, start + 1, end) -
                divDif(X, Y, start, end - 1)) / (X[end] - X[start]);
    }

}
