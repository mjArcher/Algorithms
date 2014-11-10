import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import java.util.Arrays; //not sure if this is required
import java.util.ArrayList;

//this is an example of how we go about sorting data on two different keys

//how do we use comparators for integers
//won't we need to create a new Integer class with a private static class which implements the Comparator interface?

public class Student
{
  public static final Comparator<Student> BY_NAME = new ByName();
  public static final Comparator<Student> BY_SECTION = new BySection();
  private final String name;
  private final int section;

  Student(String name, int section){
    this.name = name;
    this.section = section; 
  }

  private static class ByName implements Comparator<Student>
  {
    public int compare(Student v, Student w)
    {
      return v.name.compareTo(w.name); //look at this method -- uses the string compareTo method
    }
  }

  private static class BySection implements Comparator<Student>
  {
    public int compare(Student v, Student w)
    {
      return v.section - w.section; //returns the difference of the sections, - if less, + if greater and 0 if equal
    }
  }

  public static void main(String[] args)
  {
    System.out.println("The following code sorts the names alphabetically or by section");
    Student A = new Student("Matt", 1);
    Student B = new Student("Tom", 2);
    Student C = new Student("Jan", 1);
    Student D = new Student("Kev", 3);
    Student E = new Student("Hol", 1);

    // List<Student> list = new ArrayList<Student>();
    // list.add(A);
    // list.add(B);
    // list.add(C);
    // list.add(D);
    // list.add(E);

    Student[] a = new Student[5];
    a[0] = A;
    a[1] = B;
    a[2] = C;
    a[3] = D;
    a[4] = E;
    
    Arrays.sort(a, Student.BY_NAME);  
    
    System.out.println("\nSort by Name");
    for(int i = 0; i < 5; i++)
      System.out.println("Name " + a[i].name + ", Section " + a[i].section);

    Arrays.sort(a, Student.BY_SECTION); //what sorting method is being used here?

    System.out.println("\nSort by section");
    for(int i = 0; i < 5; i++)
      System.out.println("Name " + a[i].name + ", Section " + a[i].section);
  }

}
  
