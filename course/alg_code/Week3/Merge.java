import java.util.ArrayList; //can change size dynamically, cannot work with primitive types (use wrappers instead??)
import java.util.List;
import java.util.Collections;

public class Merge
{

  private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
  {
    // System.out.println("Low " + lo + " mid " + mid + " high " + hi);
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

  public static void main(String[] args)
  {
    System.out.println("Sort the list using merge sort");
    int size = Integer.parseInt(args[0]);
    long startTime = System.nanoTime();
    //create array and auxillary array
    Integer[] array = createRandomArray(size);
    for (int i = 0; i < size; i++)
      System.out.println(array[i]);
    Integer[] arrayAux = new Integer[array.length]; 
    //sort array
    Merge sorter = new Merge();

    sorter.sort(array);
    long endTime = System.nanoTime();
    long duration = (endTime - startTime);
    //time to sort 
    System.out.println("Time to sort = " + duration );

    for (int i = 0; i < 10; i++)
      System.out.println(array[i]);
  }
}
