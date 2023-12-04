
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReaderClass
{    
    public static RedBlackTree rbt;
    public static HeapImpl hp;
    public static int period;
    public static int node_count = 0;
    public static int n;
	
    public static void main(String[] args) throws FileNotFoundException
    {
        // rbt first node
        rbt = new RedBlackTree();
        ArrayList<Process> processes = new ArrayList<Process>();
  
        Scanner consoleInput = new Scanner(System.in);
        //choose input
        System.out.println("Choose file input:");
        System.out.println("1->MySampleInput.txt");
        System.out.println("2->Input100.txt");
        System.out.println("3->Input1000.txt");
        System.out.println("4->Input10000.txt");
        int chs = consoleInput.nextInt();
        Scanner scanner = null;
        switch (chs)
        {
            case 1:
                scanner = new Scanner(new File("MySampleInput.txt"));
                break;
            case 2:
                scanner = new Scanner(new File("Input100.txt"));
                break;
            case 3:
                scanner = new Scanner(new File("Input1000.txt"));
                break;
            case 4:
                scanner = new Scanner(new File("Input10000.txt"));
                break;
            default:
                System.out.println("Wrong input, will return errors. Run this program again.");
                break;
        }       
        n = scanner.nextInt();
        period = scanner.nextInt();
        hp = new HeapImpl();
        System.out.println("Number of inputs = " + n);
        System.out.println("Quantum period = " + period);
        System.out.println("\nChoose a metric:\n1->Time in CPU\n2->Remaining Execution Time \n3->Time in CPU + Remaining Execution Time");
        int ch = consoleInput.nextInt();
        for(int j = 0; j < n; j++)
        {
            int l, m, p;
            processes.add(new Process(hp, l = scanner.nextInt(), m = scanner.nextInt(), p = scanner.nextInt()));
            processes.add(new Process(rbt,l,m,p));
            node_count++;
        }			
        consoleInput.close();
        scanner.close();			
        Scheduler sc = new Scheduler();
        switch (ch) 
        {
            case 1:
                sc.scheduleHeap(hp);
                sc.scheduleRBTree(rbt);
                break;
            case 2:
                sc.scheduleHeapRe(hp);
                sc.scheduleRBTreeWtRe(rbt);
                break;
            case 3:
                sc.scheduleHeapBoth(hp);
                sc.scheduleRBTreeBoth(rbt);
                break;
            default:
                System.out.println("Wrong Input");
                break;
        }
    }
}
