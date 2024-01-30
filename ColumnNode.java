package homework;

public class ColumnNode {
	private String data;
	private ColumnNode next;
	private ColumnNode prev;
	public ColumnNode(String dataToAdd) {
		this.data = dataToAdd;
		this.next = null;
		this.prev=null;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public ColumnNode getNext() {
		return next;
	}
	public void setNext(ColumnNode next) {
		this.next = next;
	}
	public ColumnNode getPrev() {
		return prev;
	}
	public void setPrev(ColumnNode prev) {
		this.prev = prev;
	}

	
}
