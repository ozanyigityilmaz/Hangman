package homework;

public class Node {
	Object data;
	Node link;
	Node prev;
	Node(Object data){
		this.data = data;
		this.link = null;
		this.prev=null;
	}
	public Object getData() {
		return data;
	}
	public void setData(char data) {
		this.data = data;
	}
	public Node getLink() {
		return link;
	}
	public void setLink(Node link) {
		this.link = link;
	}
	
	public void display() {
		System.out.println(data);
	}
	public Node getPrev() {
		return prev;
	}
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
