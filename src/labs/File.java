package labs;

import java.util.ArrayList;

public class File {
	private String mName;
	public Folder mParent;
	public Cluster mMainCluster;
	
	public File(Folder parent, Cluster mainCluster, String name) {
		mParent = parent;
		mMainCluster = mainCluster;
		mName = name;
	}
	
	public String getName() {
		return mName;
	}
	
	public ArrayList<Cluster> getClusters() {
		ArrayList<Cluster> clusters = new ArrayList<Cluster>();
		Cluster cur = mMainCluster;
		while(cur.getNextCluster() != null) {
			clusters.add(cur);
			cur = cur.getNextCluster();
		}
		
		return clusters;
	}
	
	public Folder getParent() {
		return mParent;
	}
}
