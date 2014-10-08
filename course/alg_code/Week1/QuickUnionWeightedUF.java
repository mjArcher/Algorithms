//this is the same as quick union but we maintain an extra array sz[i]
//to count the number of objects in tree rooted at i
import java.util.Arrays;

public class QuickUnionWeightedUF
{
  private int[] id;
  private int[] sz;

  public QuickUnionWeightedUF(int N)
  {
    id = new int[N];
    sz = new int[N];

    for (int i = 0; i < N; i++) 
    {
      id[i] = i; 
      sz[i] = 1;
    }
  }

  private int root(int i)
  {
    while (i != id[i]) 
      i = id[i];
    return i;
  }

  public boolean connected(int p, int q)
  {
    return root(p) == root(q);
  }

  //link the root of the smaller tree to root of larger tree
  //update the sz[] array
  //Always makes sure the smaller tree goes below.
  public void union(int p, int q)
  {
    int i = root(p);
    int j = root(q);
    // id[i] = j;
    if (i == j) return;
    if (sz[i] < sz[j])
    { 
      id[i] = j; 
      sz[j] += sz[i]; //increment by size
    }
    else
    {
      id[j] = i; 
      sz[i] += sz[j];  //increment by size 
    }
  }

  public void printArray()
  {
    System.out.println(Arrays.toString(id));
    System.out.println(Arrays.toString(sz));
  }

  public static void main(String[] args)
  {

    QuickUnionWeightedUF test = new QuickUnionWeightedUF(10); 
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

