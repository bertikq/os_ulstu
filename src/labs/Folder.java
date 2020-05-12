package labs;

import java.util.ArrayList;

public class Folder {
	private String name;
	private Folder parent;
	private ArrayList<Folder> childFolders;
	
	public Folder(String name, Folder parent) {
		this.name = name;
		this.parent = parent;
		childFolders = new ArrayList<Folder>();
	}

	public String getName() {
		return name;
	}

	public void setName(String mName) {
		this.name = mName;
	}

	public Folder getParent() {
		return parent;
	}

	public void setParent(Folder mParent) {
		this.parent = mParent;
	}
	
	public void addFolder(Folder folder) {
		childFolders.add(folder);
	}
	
	public ArrayList<Folder> getChilds(){
		return childFolders;
	}
	
}
