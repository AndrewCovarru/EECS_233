import java.util.*;
public class MaxHeap2
{
    private int[] Heap;
    private int size;
    private int maxsize;

    private static final int FRONT = 1;

    public MaxHeap2(int maxsize)
    {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }

    private int parent(int pos)
    {
        return pos / 2;
    }

    private int leftChild(int pos)
    {
        return (2 * pos);
    }

    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos)
    {
        if (pos >=  (size / 2)  &&  pos <= size)
        {
            return true;
        }
        return false;
    }

    private void swap(int fpos,int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    private void maxHeapify(int pos)
    {
        if (!isLeaf(pos))
        {
            if ( Heap[pos] < Heap[leftChild(pos)]  || Heap[pos] < Heap[rightChild(pos)])
            {
                if (Heap[leftChild(pos)] > Heap[rightChild(pos)])
                {
                    swap(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                }else
                {
                    swap(pos, rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(int element)
    {
        Heap[++size] = element;
        int current = size;

        while(Heap[current] > Heap[parent(current)])
        {
            swap(current,parent(current));
            current = parent(current);
        }
    }

    public void print()
    {
        for (int i = 1; i <= size / 2; i++ )
        {
            System.out.print("PARENT: " + Heap[i] + " LEFT CHILD: " + Heap[2*i]
                    + " RIGHT CHILD:" + Heap[2 * i  + 1]);
            System.out.println();
        }
    }


    public int remove()
    {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        maxHeapify(FRONT);
        return popped;
    }

    public static void main(String...arg)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("How big is your heap?");
        int size = sc.nextInt();
        int input;
        MaxHeap2 maxHeap = new MaxHeap2(size);
        for(int i = 0; i<size; i++)
        {
            System.out.println("Please enter a number that is part of your heap");
            input = sc.nextInt();
            maxHeap.insert(input);
        }
        //maxHeap.maxHeap();

        maxHeap.print();

    }
}
