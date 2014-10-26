import java.util.ArrayList; //can change size dynamically, cannot work with primitive types (use wrappers instead??)
import java.util.List;
import java.util.Collections;


public class Selection 
{
  public static void sort(Comparable[] a)
  {
    int N = a.length;
    for (int i = 0; i < N; i++) //loop over all elements in a
    {
      int min = i;
      for (int j = i + 1; j < N; j++) //increment the search to be the next one along
        if (less(a[j], a[min]))
          min = j;
      exch(a, i, min);
    }
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

  public static int[] createRandomArray(int size)
  {
    //create simple random array and sort
    List<Integer> list = new ArrayList<Integer>();
    for (int i = 1; i < size; i++) {
      list.add(i);
    }

    // Shuffle it
    Collections.shuffle(list);

    // Get an Integer[] array
    Integer[] array1 = list.toArray(new Integer[list.size()]);

    // Get an int[] array
    int[] array2 = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      array2[i] = list.get(i);
    }
    return array2;
  }

  public static void main(String[] args)
  {
    int[] array = createRandomArray(10);
    for (int i = 0; i < 10; i++)
      System.out.println(array[i]);

    System.out.println("Sort the list");

    Selection selSortInt = new Selection();
    selSortInt.sort(array);

    for (int i = 0; i < 10; i++)
      System.out.println(array[i]);
  }

}
