package chart.Approximation;

/**
 * Created by Дима on 20.06.2017.
 */
public class EulerMethod
{
    public EulerMethod()
    {
        startPoint = 1.0;
        endPoint = 2.0;
        h = 0.01;
        length = (int) (1/h+1);


    }

    //private Pair<Double, Double> koshi = new Pair<Double, Double>(0.0,1.0);

    //x0
    private double startPoint;

    //x1
    private double endPoint;

    //отрезок разбиения
    private double h = 0.1;

    private int length;

    public int getLength()
    {
        return (int) (1/h+1);
    }

    //hardcoded Function
    public static double funcY(double z)
    {
        return z;
    }

    public static double funcZ(double z,double y,double x)
    {
        return z*z/y + z/x;
    }

    //шаг
    private double iterationY(double zi, double yi)
    {
        return yi + h * funcY(zi);
    }

    private double iterationZ(double zi, double yi, double xi)
    {
        return zi + h * funcZ(zi,yi, xi);
    }

    public double[][] getApproximationPointsY()
    {
        double[][] array = new double[length][3];
        array[0][0] = Math.E;
        array[0][1] = 2*Math.E;
        array[0][2] = startPoint;
        for (int i = 1; i <length; i++)
        {
            array[i][0] = iterationY(array[i - 1][1], array[i - 1][0]);
            array[i][1] = iterationZ(array[i-1][1],array[i-1][0],startPoint + i*h);
            array[i][2] = startPoint + i*h;

        }

        return  array;
    }

//    public double[] getArrayOfX()
//    {
//        double[] array = new double[length];
//        for(int i=0;i<length;i++)
//        {
//            array[i] = startPoint + i*h;
//        }
//        return array;
//    }


}
