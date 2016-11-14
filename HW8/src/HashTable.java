
public class HashTable {

    static Integer[] ID = new Integer[20];
    static String[] names = new String[20];

    public static void insert(Integer key, String name)
    {
        int index = key%20;
        if(ID[index] == null)
        {
            ID[index]= key;
            names[index] = name;
        }
        else
        {
            while(ID[index]!=null)
            {
                int i = 1;
                index += (i*i) -1;
                if(index>19)
                {
                    index%=20;
                }
                i++;
            }
            ID[index] = key;
            names[index] = name;
        }
    }

    public static void doubleInsert(Integer key, String name)
    {
        int index = key%20;
        int stepDistance = (7 - (key%7));
        int i =1;
        while(ID[index] != null)
        {
            index += stepDistance;
            index %= 20;
            while(index>=20)
            {
                index -= 20;
                i++;
            }
        }
        ID[index] = key;
        names[index] = name;
    }
    public static void print()
    {
        for(int i =0; i<20;i++)
        {
            System.out.println(i + ":" + " " + ID[i] + ", " + names[i]);
        }
    }


    public static void main(String[] args)
    {
        insert(0,"Amy");
        insert(1, "Bob");
        insert(19, "Julia");
        insert(200, "Steve");
        insert(201, "Andrew");
        insert(219, "Helen");
        insert(220, "Derrick");
        insert(820, "David");
        insert(821, "Timmy");
        insert(839, "Pablo");
        print();
        System.out.println("\n");
        ID = new Integer[20];
        names = new String[20];
        doubleInsert(0,"Amy");
        doubleInsert(1, "Bob");
        doubleInsert(19, "Julia");
        doubleInsert(200, "Steve");
        doubleInsert(201, "Andrew");
        doubleInsert(219, "Helen");
        doubleInsert(220, "Derrick");
        doubleInsert(820, "David");
        doubleInsert(821, "Timmy");
        doubleInsert(839, "Pablo");
        print();

    }

}
