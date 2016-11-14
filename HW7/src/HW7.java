import java.util.Scanner;
import java.util.Random;

public class HW7{

    //Method for problem 3
    //Allows variable hypothetical array size
    public static void prob3(int size){

        int[] hashIndex = new int[size];
        int maxCol = 0;
        int totCol =0;
        int temp;

        //Performs the hash function
        //Increases index value based on hash function
        for(int i = 0; i <= 10000; i++){
            temp = i % size;
            hashIndex[temp]++;
        }

        //totCol sums the number of times each key index was used
        //maxCol performs linear search to find the most used index value
        for(int k = 0; k < size; k++){
            totCol = totCol + hashIndex[k] - 1 ;

            if(maxCol < hashIndex[k])
                maxCol = hashIndex[k];
        }

        System.out.println("Total Collisions: " + totCol + ", " + "Max Collisions: " + (maxCol - 1));
    }

    //Method for problem 4
    //Allows for variable array size, number of key values, and range of numbers
    public static void prob4(int size, int key, int max){
        Random rand = new Random();

        //Loops through 3 trials
        for (int j = 0; j < 3; j++) {
            int[] hashIndex = new int[size];
            int maxCol = 0;
            int totCol = 0;
            int temp;

            //Performs the hash function for however many key values
            //Counts the number of times each key index is used
            for (int i = 0; i < key; i++) {
                int randNum = rand.nextInt(max) + 1;
                temp = randNum % size;
                hashIndex[temp]++;
            }

            //totCol sums the number of times each key index was used
            //maxCol performs linear search to find the most used index value
            for (int k = 0; k < size; k++) {
                if (hashIndex[k] == 0)
                    totCol = totCol + hashIndex[k];
                else
                    totCol = totCol + hashIndex[k] - 1;

                if (maxCol < hashIndex[k])
                    maxCol = hashIndex[k];
            }
            System.out.println("Total Collisions: " + totCol + ", " + "Max Collisions: " + (maxCol - 1));
        }
    }
    public static void main (String args[]){

        Scanner input = new Scanner(System.in);
        int arraySize;
        int keySize;
        int maxKey;

        System.out.print("Problem 3 or Problem 4: ");
        String prob = input.nextLine();

        switch (prob){

            case "Problem 3":
                System.out.print("Input array size: ");
                arraySize = input.nextInt();
                prob3(arraySize);
                break;

            case "Problem 4":
                System.out.print("Input array size: ");
                arraySize = input.nextInt();
                System.out.print("Input number of key values: ");
                keySize = input.nextInt();
                System.out.print("Input maximum for key values: ");
                maxKey = input.nextInt();
                prob4(arraySize,keySize,maxKey);
                break;
        }
    }
}