// Chris Fietkiewicz (cxf47)
// Andrew Covarrubias (axc554)

public class Example4 {

    public static void main(String[] args) {

        long startTime, stopTime;

        for (int n_step = 1; n_step <= 9; n_step++) {

            int n = 40;

            for (int samples = 0; samples < 5; samples++) {

                startTime = System.currentTimeMillis();
                long x = fib(n + n_step);
                stopTime = System.currentTimeMillis();

                System.out.printf("%-10d", (stopTime - startTime));

                if (samples == 4) {
                    System.out.println(" ");
                }
            }
        }
    }

    public static long fib( int n )
    {
        if( n <= 1 )
            return 1;
        else
            return fib( n - 1 ) + fib( n - 2 );
    }
}

