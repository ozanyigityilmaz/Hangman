package homework;

public class SingleLinkedList {
	private Node head;
	public SingleLinkedList() {
	
		this.head=null;
	}
	public void insert(Object dataToAdd) {
		Node newnode=new Node(dataToAdd);
		if(head==null)
			head=newnode;
		else 
		{
			Node temp=head;
			if(((Gamer) dataToAdd).getScore()>((Gamer)temp.getData()).getScore()) 
			{ // adding to the front
				head.setPrev(newnode);
				newnode.setLink(head);
				head = newnode;
			}
			else
			{
				int count=0;
				while(temp.getLink()!=null && ((Gamer) dataToAdd).getScore()<=((Gamer)temp.getData()).getScore()) 
				{
					temp = temp.getLink();
					count++;
				}
				if(temp.getLink()==null && ((Gamer) dataToAdd).getScore()>((Gamer)temp.getData()).getScore()) 
				{
					temp.getPrev().setLink(newnode);
					newnode.setPrev(temp.getPrev());
					temp.setPrev(newnode);
					newnode.setLink(temp);
					for (int i = 0; i <= count; i++)
					{
						temp = temp.getPrev();
					}
				}
				else if(temp.getLink() != null)
				{
					temp.getPrev().setLink(newnode);
					newnode.setPrev(temp.getPrev());
					temp.setPrev(newnode);
					newnode.setLink(temp);
					for (int i = 0; i <= count; i++) 
					{
						temp = temp.getPrev();
					}
				}
				else { // adding to the end
					newnode.setPrev(temp);
					temp.setLink(newnode);
					for (int i = 0; i <count; i++) 
					{
						temp = temp.getPrev();
					}
				}	
				head = temp;
				
			}
				
		}		
	}
	public int size() {
		int count=0;
		if(head==null)System.out.println("");
		else {
			Node temp=head;
			while(temp!=null) {
				count++;
				temp=temp.getLink();
			}
		}
		return count;
	}
	public void display() {
		int count=0;
		if(head==null)System.out.println("");
		else {
			Node temp=head;
			while(temp!=null&&count<10) 
			{
				System.out.println(" "+((Gamer) temp.getData()).getName()+": "+((Gamer) temp.getData()).getScore());
				temp = temp.getLink();
				count++;
			}
		}
	}
	public void delete() {
		if(head==null);
		else {
			head=head.getLink();
		}
	}
	public Node getHead() {
		return head;
	}
	public void setHead(Node head) {
		this.head = head;
	}
	
}

