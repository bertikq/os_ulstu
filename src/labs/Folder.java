package labs;

import java.util.ArrayList;

public class Folder {
	private String mName;
	private Folder mParent;
	private ArrayList<Folder> mChildFolders;
	
	public Folder(String name, Folder parent) {
		mName = name;
		mParent = parent;
		mChildFolders = new ArrayList<Folder>();
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public Folder getmParent() {
		return mParent;
	}

	public void setmParent(Folder mParent) {
		this.mParent = mParent;
	}
	
	public void addFolder(Folder folder) {
		mChildFolders.add(folder);
	}
	
	public ArrayList<Folder> getChilds(){
		return mChildFolders;
	}
	
}
