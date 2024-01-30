package homework;

public class MultiLinkedList 
{
	private RowNode head;
	public MultiLinkedList() {
		this.head = null;
	}

	public RowNode getHead() {
		return head;
	}

	public void setHead(RowNode head) {
		this.head = head;
	}

	public void addRow(int dataToAdd) 
	{
		RowNode newnode = new RowNode(dataToAdd);
		if(head==null)
		{
			head=newnode;
		}
		else
		{
			if(dataToAdd<head.getRowName())
			{
				newnode.setDown(head);
				head.setPrevdown(newnode);
				head=newnode;
			}
			else
			{
				RowNode temp=head;
				while(temp.getDown()!=null&&dataToAdd>temp.getDown().getRowName())
				{
					temp=temp.getDown();
				}
				newnode.setPrevdown(temp);
				newnode.setDown(temp.getDown());
				if(temp.getDown()!=null)
				{
					temp.getDown().setPrevdown(newnode);
				}
				temp.setDown(newnode);
			}
		}
	}

	public void addColumn(String letter, String word) {
		if (head == null)
			System.out.println("Add a row before adding elements");
		else 
		{
			RowNode temp = head;
			int control=Integer.parseInt(letter);
			while(temp != null) 
			{
				if(control==temp.getRowName())
				{
					ColumnNode temp2 = temp.getRight();
					if(temp2 == null) 
					{
						ColumnNode newnode = new ColumnNode(word);
						temp.setRight(newnode);
					}
					else 
					{
						ColumnNode newnode = new ColumnNode(word);
						if(word.compareTo(temp2.getData())<0)
						{
							newnode.setNext(temp.getRight());
							temp.getRight().setPrev(newnode);
							temp.setRight(newnode);
						}
						else
						{
							ColumnNode temp3=temp.getRight();
							while(temp3.getNext()!=null&&word.compareTo(temp3.getNext().getData())>0)
							{
								temp3=temp3.getNext();
							}
							newnode.setPrev(temp3);
							newnode.setNext(temp3.getNext());
							if(temp3.getNext()!=null)
							{
								temp3.getNext().setPrev(newnode);
							}
							temp3.setNext(newnode);
						}
						
					}
				}
				temp = temp.getDown();				
			}

		}
	}

	public int size() {
		int count = 0;
		if (head == null) {
			System.out.println("Linked List is empty");

		} else {
			RowNode temp = head;
			while (temp != null) {
				count++;
				temp = temp.getDown();
			}
		}
		return count;
	}

	public void Display() 
	{
		//int count=0;
		if (head == null)
			System.out.println("Linked list is empty");
		else {
			RowNode temp = head;
			while (temp != null) {
				System.out.print(temp.getRowName() + "=> ");
				ColumnNode temp2 = temp.getRight();
				while (temp2 != null) {
					System.out.print((String) temp2.getData() + " ");
					//count++;
					temp2 = temp2.getNext();
				}
				//System.out.print(count);  /////for the control
				temp = temp.getDown();
				System.out.println();

			}
		}
	}
	public boolean Search(int data)
	{
		RowNode temp=head;
		while(temp!=null)
		{
			if(data==temp.getRowName())
			{
				return true;
			}
			temp=temp.getDown();
		}	
		return false;
	}
}
