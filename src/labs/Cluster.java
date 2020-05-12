package labs;

public class Cluster {
	private Cluster mNextCluster;
	private String mContent;
	
	public Cluster(Cluster nextCluster, String content) {
		mNextCluster = nextCluster;
		mContent = content;
	}

	public Cluster getNextCluster() {
		return mNextCluster;
	}

	public void setNextCluster(Cluster nextCluster) {
		mNextCluster = nextCluster;
	}

	public String getContent() {
		return mContent;
	}
	
	public void setContent(String content) {
		mContent = content;
	}
}
