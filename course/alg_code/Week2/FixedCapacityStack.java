//stack using fixed array + generics

public class FixedCapacityStack<Item>
{
  private Item[] s;
  private int N = 0;

  public FixedCapacityStack(int capacity)
  {
    s = (Item[]) new Object[capacity]; //this is a horrendous piece of code - a very ugly cast
  }

  public boolean isEmpty()
  {
    return N == 0;
  }

  public void push(Item item)
  {
    s[N++] = item;
  }

  public Item pop()
  {
    return s[--N];
  }
}
