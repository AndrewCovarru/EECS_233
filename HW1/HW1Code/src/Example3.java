// Chris Fietkiewicz (cxf47)
// Andrew Covarrubias (axc554)

public class Example3 {
    public static void main(String[] args) {
        long startTime, stopTime; // For recording start/stop times
        long x = 0;

        for (int n_step = 1; n_step <= 9; n_step++) {

            long n = 10000L;

            for (int samples = 0; samples < 5; samples++) {

                startTime = System.currentTimeMillis();

                for (long i = 0; i < (n * n_step); i++) {
                    x = x + 1;
                }
                for (long i = 0; i < (n * n_step); i++) {
                    for (long j = 0; j < (n * n_step); j++) {
                        x = x + 1;
                    }
                }
                stopTime = System.currentTimeMillis();
                System.out.printf("%-6d", (stopTime - startTime));

                if (samples == 4) {
                    System.out.println(" ");
                }
            }
        }
    }
}
