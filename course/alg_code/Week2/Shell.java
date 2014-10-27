import java.util.ArrayList; //can change size dynamically, cannot work with primitive types (use wrappers instead??)
import java.util.List;
import java.util.Collections;
public class Shell
{
  public static void sort(Comparable[] a)
  {
    int N = a.length;

    int h = 1;
    while (h < N/3)
      h = 3*h + 1; // 1, 4, 13, 40, 121, 364, ...

    // this part here is just insertion sort
    while (h >= 1)
    {
      for (int i = h; i < N; i++)
      {
        for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
          exch(a, j, j-h);
      }

      h = h/3;
    }
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
    
    int size = Integer.parseInt(args[0]);
    Integer[] array = createRandomArray(size);//integer implements comparable
    // for (int i = 0; i < size; i++)
    //   System.out.println(array[i]);

    System.out.println("Sort the list containing " + size + " items");
    

    Shell sorter = new Shell();

    //this code is the same for all sorting classes 
    long startTime = System.nanoTime();
    sorter.sort(array);
    long endTime = System.nanoTime();
    long duration = (endTime - startTime);
    System.out.println("Time to sort = " + duration/10.e9 + " seconds");

    // for(int i = 0; i < size; i++)
    //   System.out.println(array[i]);
  }
}
