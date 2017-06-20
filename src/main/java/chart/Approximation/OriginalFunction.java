package chart.Approximation;

/**
 * Created by Дима on 20.06.2017.
 */
public class OriginalFunction
{
    public static int length = 1000;
    public static double originalStart;
    public static double originalEnd;

    static {
        originalStart = 0.0;
        originalEnd = 1.0;
    }

    public static double[][] getArray()
    {
        double[][] array = new double[length][2];
        for (int i=0;i<length;i++)
        {
            double x = (originalEnd - originalStart)/length * i;
            array[i][0] = x;
            array[i][1] = getY(x);
        }
        return  array;

    }

    public static double getY(double x)
    {
        return  (0.75 * Math.pow(Math.E,-2*x) + 0.5 *x*x - 0.5 * x + 0.25);
    }
}
