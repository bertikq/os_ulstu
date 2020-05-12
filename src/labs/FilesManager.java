package labs;

import java.io.Console;
import java.util.ArrayList;

public class FilesManager {
	private Cluster[] allClusters;
	private ArrayList<File> allFiles;
	private ArrayList<Folder> allFolders;
	private int SizeClusters;
	private int[] monitor; // 0 - серый, 1 - синий, 2- красный
	
	public FilesManager(int sizeClusters) {
		SizeClusters = sizeClusters; 
		allClusters = new Cluster[sizeClusters];
		monitor = new int[sizeClusters];
		
		for (int i = 0; i < SizeClusters; i++) {
				allClusters[i] = null;
				monitor[i] = 0;
		}
		allFiles = new ArrayList<File>();
		allFolders = new ArrayList<Folder>();
	}
	
	private File CreateFile(String name, Folder parent, ArrayList<Cluster> clusters) {
		if (getCountFreeClusters() < clusters.size()) {
			System.out.println("No memory");
			return null;
		}
		
		Cluster curCluster = null;
		File file = new File(parent, curCluster, name);
		
		for (int i = 0; i < SizeClusters; i++) {
			if (allClusters[i] == null) {
				allClusters[i] = new Cluster(null, "");
				curCluster = allClusters[i];
				curCluster.setContent(clusters.get(0).getContent());
				clusters.remove(0);
				monitor[i] = 1;
				break;
			}
		}
				
		for (int i = 0; i < SizeClusters; i++) {
			if (clusters.size() < 1) {
				break;
			}
			
			if (allClusters[i] == null) {
				allClusters[i] = new Cluster(null, "");
				curCluster.setNextCluster(allClusters[i]);
				curCluster = allClusters[i];
				curCluster.setContent(clusters.get(0).getContent());
				monitor[i] = 1;
				clusters.remove(0);
			}
		}
		allFiles.add(file);
		return file;
	}

	private Folder CreateFolder(String name, Folder parent) {
		
		Folder folder = new Folder(name, parent);
		allFolders.add(folder);
		parent.addFolder(folder);
		
		return folder;
	}

	private void CopyFolder(Folder curFolder, Folder newParent) {
		
		Folder newFolder = new Folder(curFolder.getName(), newParent);
		for (File file : allFiles) {
			if (file.getParent() == curFolder) {
				CopyFile(file, newFolder);
			}
		}
		
		for (Folder folder : curFolder.getChilds()) {
			CopyFolder(folder, newFolder);
		}
		curFolder.setParent(newParent);
	}
	
	
	public void CopyFile(File curFile, Folder parent) {
		File newFile = CreateFile(curFile.getName(), parent, curFile.getClusters());
	}
	
	public void RemoveFile(File curFile) {
		for (Cluster cl : curFile.getClusters()) {
			

			for (int i = 0; i < SizeClusters; i++) {
				if (cl == allClusters[i]) {
					monitor[i] = 0;
					cl = null;
				}
			}
		}
		
		allFiles.remove(curFile);
	}
	
	public void RemoveFolder(Folder curFolder) {
		
		for (File file : allFiles) {
			if (file.getParent() == curFolder) {
				RemoveFile(file);			}
		}
		
		for (Folder folder : curFolder.getChilds()) {
			RemoveFolder(folder);
		}
		
		allFolders.remove(curFolder);
	}
	
	public void SelectFile(File file) {
		for (Cluster cl : file.getClusters()) {
			for (int i = 0; i < SizeClusters; i++) {
				if (cl == allClusters[i]) {
					monitor[i] = 2;
				}
			}
		}
	}
	
	public void DrawTable() {
		for (int i = 0; i < SizeClusters; i++) {
			System.out.print(monitor[i] + " ");
		}
	}
	
	
	private int getCountFreeClusters() {
		int freeClusters = 0;
		for (int i = 0; i < SizeClusters; i++) {
			if (allClusters[i].getNextCluster() == null) {
				freeClusters++;
			}
		}
		return freeClusters;
	}
}
