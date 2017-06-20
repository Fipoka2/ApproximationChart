package chart.Approximation;

/**
 * Created by Дима on 20.06.2017.
 */
public class EulerMethod
{
    public EulerMethod()
    {
        startPoint = 0.0;
        endPoint = 1.0;
        length = (int) (1/h+1);
        h = 0.1;

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
    public static double func(double x, double y)
    {
        return x * x - 2 * y;
    }

    //шаг
    private double iteration(double xi, double yi)
    {
        return yi + h * func(xi, yi);
    }

    public double[] getApproximationPoints()
    {
        double[] array = new double[length+1];
        array[0] = 1;
        for(int i=1;i<length;i++)
        {
            array[i] = iteration(startPoint + i*h,array[i-1]);
        }

        return  array;
    }

    public double[] getArrayOfX()
    {
        double[] array = new double[length];
        for(int i=0;i<length;i++)
        {
            array[i] = startPoint + i*h;
        }
        return array;
    }


}
