package labs;

import java.util.ArrayList;

public class File {
	private String name;
	public Folder parent;
	public Cluster mainCluster;
	
	public Cluster getMainCluster() {
		return mainCluster;
	}

	public void setMainCluster(Cluster mainCluster) {
		this.mainCluster = mainCluster;
	}

	public File(Folder parent, Cluster mainCluster, String name) {
		this.parent = parent;
		this.mainCluster = mainCluster;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Cluster> getClusters() {
		ArrayList<Cluster> clusters = new ArrayList<Cluster>();
		Cluster cur = mainCluster;
		while(cur.getNextCluster() != null) {
			clusters.add(cur);
			cur = cur.getNextCluster();
		}
		
		return clusters;
	}
	
	public Folder getParent() {
		return parent;
	}
}
