package labs;

import java.util.ArrayList;

public class FilesManager {
	private Cluster[][] mClusters;
	private ArrayList<File> mFiles;
	private ArrayList<Folder> mFolders;
	private int SizeClusters;
	private int[][] table;
	
	public FilesManager(int sizeClusters) {
		SizeClusters = sizeClusters; 
		mClusters = new Cluster[sizeClusters][sizeClusters];
		table = new int[sizeClusters][sizeClusters];
		for (int i = 0; i < SizeClusters; i++) {
			for (int j = 0; j < SizeClusters; j++) {
				mClusters[i][j] = new Cluster(null, "");
			}
		}
		mFiles = new ArrayList<File>();
		mFolders = new ArrayList<Folder>();
	}
	
	private File CreateFile(String name, Folder parent, ArrayList<Cluster> clusters) {
		if (getCountFreeClusters() < clusters.size())
			return null;
		
		Cluster curCluster = null;
		File file = new File(parent, curCluster, name);
				
		for (int i = 0; i < SizeClusters; i++) {
			for (int j = 0; j < SizeClusters; j++) {
				if (clusters.size() < 1) {
					break;
				}
				
				if (mClusters[i][j].getNextCluster() == null) {
					if (curCluster == null) {
						 curCluster = mClusters[i][j];
						 curCluster.setContent(clusters.get(0).getContent());
					}
					else {
						mClusters[i][j].setNextCluster(curCluster);
						curCluster = mClusters[i][j];
						curCluster.setContent(clusters.get(0).getContent());
					}
					clusters.remove(0);
				}
			}
		}
		mFiles.add(file);
		return file;
	}

	private Folder CreateFolder(String name, Folder parent) {
		
		Folder folder = new Folder(name, parent);
		mFolders.add(folder);
		parent.addFolder(folder);
		
		return folder;
	}

	private void CopyFolder(Folder curFolder, Folder newParent) {
		
		Folder newFolder = new Folder(curFolder.getmName(), newParent);
		for (File file : mFiles) {
			if (file.getParent() == curFolder) {
				CopyFile(file, newFolder);
			}
		}
		
		for (Folder folder : curFolder.getChilds()) {
			CopyFolder(folder, newFolder);
		}
		curFolder.setmParent(newParent);
	}
	
	
	public void CopyFile(File curFile, Folder parent) {
		File newFile = CreateFile(curFile.getName(), parent, curFile.getClusters());
	}
	
	
	private int getCountFreeClusters() {
		int freeClusters = 0;
		for (int i = 0; i < SizeClusters; i++) {
			for (int j = 0; j < SizeClusters; j++) {
				if (mClusters[i][j].getNextCluster() == null) {
					freeClusters++;
				}
			}
		}
		return freeClusters;
	}
}
