import java.util.Arrays;

public class QuickFindUF
{
  private int[] id;

  //constructor for quickfind
  //initialise id array 
  public QuickFindUF(int N) 
  {
    id = new int[N]; 
    for(int i = 0; i < N; i++)
      id[i] = i;
  }

  public boolean connected(int p, int q)
  {
    return id[p] == id[q];
  }

  // value assignments  
  // as we loop over the array
  // if the value of i equals the value of p
  // assign the value of q
  //
  public void union(int p, int q) 
  {
    int pid = id[p];
    int qid = id[q];
    for (int i = 0; i < id.length; i++)
      if (id[i] == pid) id[i] = qid;
  }

  public void printArray()
  {
    System.out.println(Arrays.toString(id));
  }

  //this does not operate like a tree structure
  //
  public static void main(String[] args)
  {
    System.out.println("Hello world");
    QuickFindUF test = new QuickFindUF(10);
    System.out.println("Starting Array");
    // int one = 00000002;
    // int two = one << 20;
    // System.out.println(two);
    // test.printArray();
    
    test.printArray();
    test.union(3, 7);
    System.out.println("connect 3 and 7");
    test.printArray();

    test.union(1, 7);
    System.out.println("connect 1 and 7");
    test.printArray();

    test.union(4, 5);
    System.out.println("connect 4 and 5");
    test.printArray();
    
    test.union(7, 5); 
    System.out.println("connect 7 and 5");
    test.printArray();
    //check if a connection has been made
    
  }

  // 1 2 3 4 5 6 7 8 
  // union(3, 7)
  // 1 2 7 4 5 6 7 8
  // union(1, 7)
  // 7 2 7 4 5 6 7 8
  // this implies that nodes 1, 3, and 7 are a connected unit
  // union(4, 5)
  // 7 2 7 5 5 6 7 8 
  // union(8, 6)
  // 7 2 7 5 5 6 7 6
  // we have 4 connected units
  //
}
