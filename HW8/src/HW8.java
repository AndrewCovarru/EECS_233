import java.util.Scanner;

public class HW8 {

    public static Integer[] idTable = new Integer[20];
    public static String[] nameTable = new String[20];

    public static void quadInsert(Integer ID, String name) {
        int index = ID % idTable.length;
        int i = 1;
        int temp = index;
        while (idTable[index] != null) {
                index = temp;
                index += (int) Math.pow(i, 2);
                if (index > idTable.length - 1)
                    index %= idTable.length;
                i++;
        }
        idTable[index] = ID;
        nameTable[index] = name;
    }

    public static void doubleInsert(Integer ID, String name) {
        int index = ID % idTable.length;
        int hashKey = 7 - (ID % 7);
        int temp = index;
        int i = 1;
        while (idTable[index] != null){
            index = temp;
            index += i * hashKey;
            if(index > idTable.length - 1)
                index %= idTable.length;
            i++;
        }
        idTable[index] = ID;
        nameTable[index] = name;
    }

    public static void tablePrint() {
        for (int i = 0; i < idTable.length; i++) {
            if (idTable[i] == null)
                System.out.println(i + ": " + idTable[i]);
            else
                System.out.println(i + ": " + idTable[i] + ", " + nameTable[i]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Quadratic Probing or Double Hash: ");
        String choice = input.nextLine();
        Integer[] IDs = {0, 1, 19, 200, 201, 219, 220, 820, 821, 839};
        String[] names = {"Touch the Sky", "Everything I Am", "Roses", "Touch the Sky", "Monster", "Otis", "Saint Pablo", "Homecoming", "Good Morning", "Spaceship"};

        switch (choice){
            case "Quadratic Probing":
                for (int i = 0; i < IDs.length; i++)
                    quadInsert(IDs[i], names[i]);
                tablePrint();
                break;

            case "Double Hash":
                for (int i = 0; i < IDs.length; i++)
                doubleInsert(IDs[i], names[i]);
                tablePrint();
                break;
        }
    }
}