package homework;

public class RowNode {
	private int rowName;
	private RowNode down;
	private ColumnNode right;
	private RowNode prevdown;
	public RowNode(int rowName) 
	{
		this.rowName = rowName;
		this.down = null;
		this.right = null;
		this.prevdown=null;
	}
	public int getRowName() {
		return rowName;
	}
	public void setRowName(int rowName) {
		this.rowName = rowName;
	}
	public RowNode getDown() {
		return down;
	}
	public void setDown(RowNode down) {
		this.down = down;
	}
	public ColumnNode getRight() {
		return right;
	}
	public void setRight(ColumnNode right) {
		this.right = right;
	}
	public RowNode getPrevdown() {
		return prevdown;
	}
	public void setPrevdown(RowNode prevdown) {
		this.prevdown = prevdown;
	}
	
}
