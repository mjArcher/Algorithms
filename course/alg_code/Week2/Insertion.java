import java.util.ArrayList; //can change size dynamically, cannot work with primitive types (use wrappers instead??)
import java.util.List;
import java.util.Collections;

public class Insertion
{
  //left this here to show how insertion sort is used on its own
  public static void sort(Comparable[] a)
  {
    int N = a.length;
    for (int i = 0; i < N; i++)
      for (int j = i; j > 0; j--)
        if (less(a[j], a[j-1]))
          exch(a, j, j-1);
        else break;
  }

  //this is for the optimised Merge function
  public static void sort(Comparable[] a, int lo, int hi)
  {
    int N = a.length;
    for (int i = lo; i <= hi; i++) //note the change here
      for (int j = i; j > lo; j--)
        if (less(a[j], a[j-1]))
          exch(a, j, j-1);
        else break;
  }

  private static boolean less(Comparable v, Comparable w)
  {
    return v.compareTo(w) < 0; //method that all Comparable objects have implemented
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
    int size = 10;
    Integer[] array = createRandomArray(size);//integer implements comparable
    for (int i = 0; i < size; i++)
      System.out.println(array[i]);

    System.out.println("Sort the list");

    long startTime = System.nanoTime();
    Insertion sorter = new Insertion();
    sorter.sort(array);
    long endTime = System.nanoTime();
    long duration = (endTime - startTime);
    System.out.println("Time to sort = " + duration );

    for(int i = 0; i < size; i++)
      System.out.println(array[i]);
  }
}
