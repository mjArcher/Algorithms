import java.util.ArrayList; //can change size dynamically, cannot work with primitive types (use wrappers instead??)
import java.util.List;
import java.util.Collections;
import java.util.Random;

public class Merge
{

  private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
  {
    // System.out.println("Low " + lo + " mid " + mid + " high " + hi);
    System.out.println("merge(a, " + lo + ", " + mid + ", " + hi + ")");
    assert isSorted(a, lo, mid); // precondition a[lo..mid] sorted
    assert isSorted(a, mid+1, hi); // precondition: a[mid+1..hi] sorted

    //copy to auxillary array
    for (int k = lo; k <= hi; k++)
      aux[k] = a[k];

    int i = lo, j = mid+1;
    for (int k = lo; k <= hi; k++)
    {
      if (i > mid)
        a[k] = aux[j++];
      else if (j > hi) 
        a[k] = aux[i++];
      else if (less(aux[j], aux[i])) //1. these are the two important compares 
        a[k] = aux[j++]; 
      else 
        a[k] = aux[i++]; //2. 
    }
    assert isSorted(a, lo, hi); // postcondition: a[lo..hi] sorted
  }


  //recursive sort 
  public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
  {
    if (hi <= lo)
      return;
    int mid = lo + (hi - lo) / 2;
    sort (a, aux, lo, mid);
    sort (a, aux, mid + 1, hi);
    merge(a, aux, lo, mid, hi); //note the alignment of the method names
  }

  public static void sort(Comparable[] a)
  {
    Comparable[] aux = new Comparable[a.length];
    sort(a, aux, 0, a.length - 1);
  }

  //returns 1 depending on whether list is sorted or not
  private static boolean isSorted(Comparable[] a, int lo, int hi)
  {
    for (int i = lo + 1; i < hi; i++)
      if (less(a[i], a[i-1])) 
        return false;
    return true;
  }
  //need to implement less and exch
  //helper functions
  private static boolean less(Comparable v, Comparable w)
  {
    return v.compareTo(w) < 0;
  }

  private static void exch(Comparable[] a, int i, int j)
  {
    Comparable swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }

  public static Integer[] createRandomArray(int size)
  {
    //create simple random array and sort
    List<Integer> list = new ArrayList<Integer>();
    for (int i = 0; i < size; i++) {
      list.add(i);
    }

    // Shuffle it
    Collections.shuffle(list);

    // Get an Integer[] array
    Integer[] array1 = list.toArray(new Integer[list.size()]);

    // Get an int[] array
    Integer[] array2 = new Integer[list.size()];
    for (int i = 0; i < list.size(); i++) {
      array2[i] = list.get(i);
    }
    return array2;
  }

  public static Integer[] createRandomArray2(int size)
  {

    Random generator = new Random();

    Integer[] array = new Integer[size];

    for(int i = 0; i < size; i++)
    {
      array[i] = generator.nextInt(size);
    }

    return array;

  }

  public static void main(String[] args)
  {
    if (args.length < 1){
      System.out.println("Insufficient parameters, args = " + args.length);
      return;
    }

    System.out.println("Sort the integers using merge sort");
    int size = Integer.parseInt(args[0]);
    long startTime = System.nanoTime();
    //create array and auxillary array
    Integer[] array = createRandomArray2(size);
    for (int i = 0; i < size; i++)
      System.out.println(array[i]);
    //sort array
    Merge sorter = new Merge();

    sorter.sort(array);
    long endTime = System.nanoTime();
    long duration = (endTime - startTime);
    //time to sort 
    System.out.println("Time to sort = " + duration);

    for (int i = 0; i < size; i++)
      System.out.println(array[i]);

    System.out.println("Sort the characters using merge sort");

    String mergeExample = "MERGESORTEXAMPLE"; //I think in C++ we can access each character form the string array
    //in java we cannot do this and must deal explicitly with character arrays

    char[] initial = mergeExample.toCharArray(); //does the char[] support comparable like Integer does?

    Character[] array2 = new Character[mergeExample.length()];

    for(int i = 0; i < mergeExample.length(); i++)
     array2[i] = initial[i]; 

    //print out the character array
    for(int i = 0; i < mergeExample.length(); i++)
      System.out.println(array2[i]);
    
    sorter.sort(array2);

    for(int i = 0; i < mergeExample.length(); i++)
      System.out.println(array2[i]);
  }
}
