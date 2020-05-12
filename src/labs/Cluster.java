package labs;

public class Cluster {
	private Cluster nextCluster;
	private String mContent;
	
	public Cluster(Cluster nextCluster, String content) {
		this.nextCluster = nextCluster;
		mContent = content;
	}

	public Cluster getNextCluster() {
		return nextCluster;
	}

	public void setNextCluster(Cluster nextCluster) {
		this.nextCluster = nextCluster;
	}

	public String getContent() {
		return mContent;
	}
	
	public void setContent(String content) {
		mContent = content;
	}
}
