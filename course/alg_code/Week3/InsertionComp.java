//comparator implementation for insertion sort
import java.util.ArrayList; //can change size dynamically, cannot work with primitive types (use wrappers instead??)
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

//we can use this to sort Students (implement comparator interface)
public class Insertion
{
  public static void sort(Object[] a, Comparator comparator)
  {
    int N = a.length;
    for (int i = 0; i < N; i++)
      for (int j = i; j > 0 && less(comparator, a[j], a[j-1]); j--)
        exch(a, j, j-1);
  }

  //sort for the merge function
  public static void sort(Object[] a, Comparator comparator, int lo, int hi)
  {
    int N = a.length;
    for (int i = lo; i <= hi; i++) //note the change here
      for (int j = i; j > lo && less(comparator, a[j], a[j-1]); j--)
        exch(a, j, j-1);
  }

  private static boolean less(Comparator c, Object v, Object w)
  {
    return c.compare(v, w) < 0;
  }

  private static void exch(Object[] a, int i, int j)
  {
    Object swap = a[i];
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
    //how do we change the sort function
    sorter.sort(array);
    long endTime = System.nanoTime();
    long duration = (endTime - startTime);
    System.out.println("Time to sort = " + duration );

    for(int i = 0; i < size; i++)
      System.out.println(array[i]);
  }
}
