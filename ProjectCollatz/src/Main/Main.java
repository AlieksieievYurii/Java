package Main;

public final class Main
{
    public static void main(String[] args)
    {
        long N = 0;
        long max = 0;
        long element = 0;

        for(int i = 13; i < 1000000; i++)
        {
            element = Run(i,1);
            if(element > max)
            {
                max = element;
                System.out.println("MAX:"+max+" NUM:"+i);
            }
        }
    }

    private static long Run(int startElement, int K)
    {
        if(startElement == 1) return K;
        else if(startElement %2 == 0) return Run(startElement/2,K+1);
        else return Run(3*startElement + 1, K+1);
    }
}
