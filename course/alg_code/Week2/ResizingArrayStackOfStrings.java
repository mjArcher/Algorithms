public class ResizingArrayStackOfStrings
{
  private String[] s;
  private int N = 0;

  public ResizingArrayStackOfStrings()
  {
    s = new String[1];
  }

  public void push(String item)
  {
    if (N == s.length)
      resize(2 * s.length);
    s[N++] = item; //note the global increment here
  }

  private void resize(int capacity)
  {
    String[] copy = new String[capacity];
    for (int i = 0; i < N; i++)
      copy[i] = s[i];
    s = copy;
  }

  public static void main(String[] args)
  {
    System.out.println("Hello world");
  }
}
