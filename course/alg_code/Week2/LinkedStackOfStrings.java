//performance
//
//each instruction takes constant time in the worst case (no loops)
//
//space
//
//16 bytes (object overhead)
//8 bytes (inner class overhead)
//8 bytes (reference to String)
//8 bytes (reference to Node)
//40 bytes per stack node

public class LinkedStackOfStrings
{
  private Node first = null;

  private class Node
  {
    String item;
    Node next;
  }

  public boolean isEmpty()
  {
    return first == null;
  }

  public void push(String item)
  {
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
  }

  public String pop()
  {
    String item = first.item;
    first = first.next;
    return item;
  }

  public void printList()
  {
    String output = "";
    Node temp = first;
    while (temp != null){
      String item = temp.item;  
      output += item + ",";
      temp = temp.next;
    }
    output += " NULL.";
    System.out.println(output);
  }

  public static void main(String[] args)
  {
    System.out.println("Create simple linked list");
    LinkedStackOfStrings linkedStack = new LinkedStackOfStrings();
    linkedStack.push("item 1");
    linkedStack.push("item 2");
    linkedStack.push("item 3");
    linkedStack.push("item 4");
    linkedStack.printList();
    linkedStack.pop();
    linkedStack.push("item 5");
    linkedStack.printList();
  }
}

