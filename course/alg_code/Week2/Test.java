//test code for 
//
//stack (LL)
//FixedCapacityStack
//StackIterator (LL)
//StackArrayIterator
//
import java.util.Iterator;

class Test {
  static int x;
  int k;
  // constructor with 2 args
  public Test()
  {

  }
  
  public static void main(String[] args) {

    //summary 



    System.out.println("General test code for stacks and strings");

    System.out.println("Simple stack");
    Stack<Integer> stack = new Stack<Integer>(); // in comments below we explain some behind the scenes casting
    stack.push(17); //s.push(new Integer(17));
    stack.push(18);
    stack.push(19);
    stack.push(20);
    int a = stack.pop();//int a = s.pop().intValue();
    System.out.println(a);

    System.out.println("Fixed capacity stack based on the use of arrays");

    // for (Integer i : stack)
    //   StdOut.println(i);
    //bottom line is that client code can use generic stack for any type of data
    //
   
    //equivalent code
    StackIterator<Integer> integerStack = new StackIterator<Integer>(); //this is just the linkedlist part of the code
     
    integerStack.push(17); //s.push(new Integer(17));
    integerStack.push(18);
    integerStack.push(19);
    integerStack.push(20);

    Iterator<Integer> iter = integerStack.iterator(); //iterator
    while (iter.hasNext())
    {
      Integer i = iter.next();
      System.out.println(i);
    }

    //alternatively we can use:
    //fancy print using iterators
    for (Integer s : integerStack)
      System.out.println(s);
  }
}
