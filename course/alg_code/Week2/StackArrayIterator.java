import java.util.Iterator;

public class StackArray<Item> implements Iterable<Item>
{
  public Iterator<Item> iterator() 
  {
    return new ReverseArrayIterator();
  }

  private class ReverseArrayIterator implements Iterator<Item>
  {
    private int i = N;

    public boolean hasNext()
    {
      return i > 0;
    }

    public void remove()
    {
      // not supported
    }

    public Item next()
    {
      return s[--i];
    }
  }
}
