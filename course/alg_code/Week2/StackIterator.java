import java.util.Iterator;

public class StackIterator<Item> implements Iterable<Item>
{
  public Iterator<Item> iterator()
  {
    return new ListIterator();
  }

  private class Node
  {
    Item item;
    Node next;
  }

  private class ListIterator implements Iterator<Item>
  {
    Node current = first;

    public boolean hasNext()
    {
      return current != null;
    }

    public void remove()
    {
      // not supported
    }

    public Item next()
    {
      System.out.println("Next");
      Item item = current.item;
      current = current.next;
      return item;
    }
  }
}


