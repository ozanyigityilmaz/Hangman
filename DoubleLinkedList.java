package homework;

public class DoubleLinkedList {
	private NodeDouble head;
	private NodeDouble tail;
	public DoubleLinkedList()
	{
		head=null;
		tail=null;
	}
	public void add(Object dataToAdd) 
	{ 
		if(head==null&&tail==null)
		{
			NodeDouble newNode=new NodeDouble(dataToAdd);
			head=newNode;
			tail=newNode;
		}
		else
		{
			NodeDouble newNode=new NodeDouble(dataToAdd);
			newNode.setPrev(tail);
			tail.setNext(newNode);
			tail=newNode;
		}
	}
	public void Display() {

		if(head==null) 
		{
			System.out.println("linked list is empty");
		}
		else 
		{
			NodeDouble temp=head;
			while(temp!=null ) 
			{	
				System.out.print((String)temp.getData());
				temp=temp.getNext();
			}	
		}
		System.out.println();
	
	}
	public NodeDouble getHead() {
		return head;
	}
	public void setHead(NodeDouble head) {
		this.head = head;
	}
	public NodeDouble getTail() {
		return tail;
	}
	public void setTail(NodeDouble tail) {
		this.tail = tail;
	}
	public int size() 
    {
        int counter = 0;
        NodeDouble temp = head;
        while (temp != null) 
        {
            counter++;
            temp = temp.getNext();
        }
        return counter;
    }

}
