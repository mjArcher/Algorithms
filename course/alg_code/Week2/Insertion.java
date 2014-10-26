import java.util.ArrayList; //can change size dynamically, cannot work with primitive types (use wrappers instead??)
import java.util.List;
import java.util.Collections;
public class Insertion
{
  public static void sort(Comparable[] a)
  {
    int N = a.length;
    for (int i = 0; i < N; i++)
      for (int j = i; j > 0; j--)
        if (less(a[j], a[j-1]))
          exch(a, j, j-1);
        else break;
  }

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
    for (int i = 0; i < size; i++) {
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
    int size = 10;
    int[] array = createRandomArray(size);
    for (int i = 0; i < size; i++)
      System.out.println(array[i]);

    System.out.println("Sort the list");

    Insertion ins = new Insertion();
    ins.sort(array);

    for(int i = 0; i < size; i++)
      System.out.println(array[i]);
  }
}
