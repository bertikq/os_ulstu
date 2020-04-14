package labs;

import java.io.Console;
import java.util.ArrayList;

public class Disk<T extends AbstractPage> {
	
	private int Size;
	
	private ArrayList<T> pages;
	
	public Disk(int size) {
		pages = new ArrayList<T>();
		Size = size;
	}

	public ArrayList<T> getPages() {
		return pages;
	}

	public boolean addPage(T page) {
		
		
		
		if (GetCurSize() + page.getSize() > Size) {
			System.out.println("Не хватает памяти");
			return false;
		}
		
		pages.add(page);
		return true;
	}
	
	public int GetCurSize() {
		
		int curSize = 0;
		
		for (T curPage : pages) {
			curSize += curPage.getSize();
		}
		
		return curSize;
	}
	
	public int GetClearSize() {
		int curSize = 0;
		
		for (T curPage : pages) {
			curSize += curPage.getSize();
		}
		
		return Size - curSize;
	}
}
