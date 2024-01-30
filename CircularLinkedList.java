package homework;

public class CircularLinkedList 
{
	private CLLNode head=null;	
	public void Add(String dataToAdd)
	{
		CLLNode temp;
		if(head==null)
		{
			CLLNode newnode=new CLLNode(dataToAdd);
			head=newnode;
			head.setLink(head);
		}
		else
		{
			temp=head;
			while(temp.getLink()!=head)
			{
				temp=temp.getLink();
			}
			CLLNode newnode=new CLLNode(dataToAdd);
			newnode.setLink(temp.getLink());
			temp.setLink(newnode);
		}
	}
	public int size()
	{
		int count=0;
		if(head==null)
		{
			System.out.println("Linked is empty");
		}
		else
		{
			CLLNode temp=head;
			do
			{
				count++;
				temp=temp.getLink();
			}while(temp!=head);
			
		}
		return count;
	}
	public void display()
	{
		
		if(head==null)
		{
			System.out.println("Linked is empty");
		}
		else
		{
			CLLNode temp=head;
			do
			{
				System.out.print(temp.getData());
				temp=temp.getLink();
			}while(temp!=head);
			
		}
	}
	public CLLNode getHead() {
		return head;
	}
	public void setHead(CLLNode head) {
		this.head = head;
	}
	
}
