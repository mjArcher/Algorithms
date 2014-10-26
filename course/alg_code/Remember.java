class Remember{
  static int x;
  int k;
  // constructor with 2 args
  public Remember()
  {

  }


  //recursive function to find the greatest common denominator
  public static int gcd(int p, int q) {
    if (q == 0) return p;
    else return gcd(q, p % q); //p not q
  }
  
  public static void main(String[] args) {

    int[] array = new int[10];

    for (int i = 0; i < 10; i++)
      array[i] = i;

    for (int i = 0; i < 10; i++)
      System.out.println(i);


    int i = 4;
    System.out.println("Selected digit " + array[i]);
    System.out.println("Selected digit increment " + array[i++]); //interesting article on this for C++ (pointers)
    System.out.println(i);

    System.out.println("Find the greatest common denominator");
    System.out.println(gcd(216,192));

    int a = 10;
    int b = 54;
    System.out.println(54 % 10); // this is just "mod"

    
  }

}

