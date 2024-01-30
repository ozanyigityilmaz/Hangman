package homework;

public class CLLNode 
{
	private Object data;
	private CLLNode link;
	public CLLNode(Object dataToAdd)
	{
		data=dataToAdd;
		link=null;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public CLLNode getLink() {
		return link;
	}
	public void setLink(CLLNode link) {
		this.link = link;
	}
	
}
