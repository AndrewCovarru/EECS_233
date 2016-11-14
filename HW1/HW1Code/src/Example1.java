// Chris Fietkiewicz (cxf47)
// Andrew Covarrubias (axc554)
public class Example1 {
    public static void main(String[] args) {
        long startTime, stopTime; // For recording start/stop times
        long x = 0;

        for (int n_step = 1; n_step <= 9; n_step++) {

            long n = 100000000L;

            for (int samples = 0; samples < 5; samples++) {

                startTime = System.currentTimeMillis();

                for (long i = 0; i < (n * n_step); i++) {
                    x = x + 1;
                }

                stopTime = System.currentTimeMillis();
                System.out.printf("%-5d",(stopTime - startTime));

                if (samples == 4) {
                    System.out.println(" ");
                }
            }

        }
    }
}
