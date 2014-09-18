//this is a tree based finding algorithm
//We imagine the array as series of trees - intially we have N root nodes
//Each index corresponds to a value, and the value corresponds to its 
//parent
//When we take the union(p, q) this makes q the parent of p
//if the parent is a child of some other tree, we move up it until we
//find the root. The special propert of the root is that it its value is
//the same as its index
//

import java.util.Arrays;

public class QuickUnionUF
{
  private int[] id;

  public QuickUnionUF(int N)
  {
    id = new int[N];
    for (int i = 0; i < N; i++) id[i] = i;
  }


  private int root(int i)
  {
    while (i != id[i]) i = id[i];
    return i;
  }

  public boolean connected(int p, int q)
  {
    return root(p) == root(q);
  }

  public void union(int p, int q)
  {
    int i = root(p);
    int j = root(q);
    id[i] = j;
  }

  public void printArray()
  {
    System.out.println(Arrays.toString(id));
  }

  public static void main(String[] args)
  {

    QuickUnionUF test = new QuickUnionUF(10); 
    System.out.println("Simple Quick Union algorithm\nInitial array");
    test.printArray(); 
    test.union(4, 3);
    // System.out.println("make 9 to be the parent of 1);
    test.union(3, 8);
    test.union(6, 5);
    test.union(9, 4);
    test.union(2, 1);
    test.printArray();
    
  }
}

  //example of how this works
  //e.g say union(9, 4)
  //4 becomes parent of 9
  //we have a trees containing (8, 3, 4) and (9) respectively
  //but 3 and then 8 are parents of 4
  //Move up the tree
  //i = root(9)
  //while 9 != id[9] (9)
  //break
  //
  //i = root(4)
  //while 4 != id[4] (3)
  //i = 3
  //while 3 != id[3] (8)
  //i = 8
  //while 8 != id[8] (8)
  //break
  //-------------
  //
  //Then assign (the root of q to the root of p)
  //id[9] = 8

