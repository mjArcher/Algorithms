class Test {
  static int x;
  int k;
  // constructor with 2 args
  public Test()
  {

  }
  
  public static void main(String[] args) {
    System.out.println("General test code for stacks and strings");
    Stack<Integer> stack = new Stack<Integer>(); // in comments below we explain some behind the scenes casting
    stack.push(17); //s.push(new Integer(17));
    // System.out.println(stack);
    int a = stack.pop();//int a = s.pop().intValue();
    System.out.println(a);
    stack.next();
    //bottom line is that client code can use generic stack for any type of data
  }
}
