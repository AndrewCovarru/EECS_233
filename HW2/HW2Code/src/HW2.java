//Andrew Covarrubias (axc554)
import java.io.*;
import java.util.Scanner;

public class HW2{

    //Creates an array of size N
    //Fills each array element with it's corresponding integer value
    public static int[] fillArray(int N){
        int[] filledArray = new int[N];

        for (int i = 0; i < filledArray.length; i++){
            filledArray[i] = i;
        }

        return filledArray;
    }

    //Goes through each element in the array and calculates how many subsequences it can form
    public static int subseq(int[] filledArray){
        int subseq_total = 0;

        for(int i = 0; i < filledArray.length; i++){
            for(int j = i; j < filledArray.length; j++){
                subseq_total++;
            }
        }

        return subseq_total;
    }

    //Goes through each element in the array and calculates the amount of times an element or a sequence of elements repeats
    public static int redund(int[] filledArray){
        int redund_total = 0;

        for(int i = 0; i < filledArray.length; i++){
            for (int j = i; j < filledArray.length; j++){
                for (int k = i; k < j; k++)
                    redund_total++;
            }
        }
        return redund_total;
    }

    public static void main (String args[]){

        int n_value;
        Scanner input = new Scanner(System.in);
        System.out.print("Input your N value: ");
        n_value = input.nextInt();

        System.out.print("N = " + n_value + "." + " Subsequences = " + subseq(fillArray(n_value)) + "." + " Redundancies = " + redund(fillArray(n_value)) + ".");

    }
}