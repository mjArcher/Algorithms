import java.util.Iterator;

//a basic stack using the iterable functionality (using Linked lists)
//details the principle of FIFO functionality (as opposed to a queue)
//

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

  private Node first = null;

  public void push(Item item)
  {
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
  }

  public Item pop()
  {
    Item item = first.item;
    first = first.next;
    return item;
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


