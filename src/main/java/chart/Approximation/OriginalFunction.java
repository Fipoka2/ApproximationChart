package chart.Approximation;

/**
 * Created by Дима on 20.06.2017.
 */
public class OriginalFunction
{
    public static double originalStart;
    public static double originalEnd;
    private static double h;
    public static int length;

    static {
        h = 0.001;
        length = (int) (1/h+1);
        originalStart = 1.0;
        originalEnd = 2.0;
    }

    public static double[][] getArray()
    {
        double[][] array = new double[length][2];
        for (int i=0;i<length;i++)
        {
            double x = originalStart + (double) i*h;
            array[i][0] = x;
            array[i][1] = getY(x);
        }
        return  array;

    }

    public static double[][] getArrayZ()
    {
        double[][] array = new double[length][2];
        for (int i=0;i<length;i++)
        {
            double x = originalStart + (double) i*h;
            array[i][0] = x;
            array[i][1] = getZ(x);
        }
        return  array;

    }

    public static double getY(double x)
    {
        return  Math.pow(Math.E,x*x);
    }

    public static double getZ(double x)
    {
        return  x * 2 * Math.pow(Math.E,Math.pow(x,2));
    }


}
