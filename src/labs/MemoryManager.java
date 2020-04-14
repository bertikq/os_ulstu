package labs;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;

public class MemoryManager {
	
	private Disk<MemoryPage> HDD;
	private Disk<VirtualPage> RAM;
	
	public MemoryManager(Disk<MemoryPage> hDD, Disk<VirtualPage> rAM) {
		super();
		HDD = hDD;
		RAM = rAM;
	}
	
	public void AddPageInVirtualMemory(int indexHDDPage, String change, boolean readOnly) {
		
		MemoryPage hddPage = HDD.getPages().get(indexHDDPage);
		String newContent = hddPage.getContent();
		if (change != "") {
			newContent = change;
		}
		
		VirtualPage virtualPage = new VirtualPage(hddPage, readOnly, newContent, hddPage.getSize(), Instant.now().toEpochMilli());
		
		if (!RAM.addPage(virtualPage)) {
			ClearVirtualSize(hddPage.getSize());
			AddPageInVirtualMemory(indexHDDPage, change, readOnly);
		}
		else {
			System.out.println("Add Page into RAM:" + virtualPage.getContent());
		}
	}
	
	public void ClearVirtualSize(int needSize) {
		while (RAM.GetClearSize() < needSize) {
			VirtualPage lastChangePage = RAM.getPages().get(0);
			for(VirtualPage vPage : RAM.getPages()) {
				if (vPage.getDateLastUsing() < lastChangePage.getDateLastUsing()) {
					lastChangePage = vPage;
				}
			}
			
			if (lastChangePage.isIsChange()) {
				lastChangePage.getMemoryPage().setContent(lastChangePage.getContent());
			}
			
			RAM.getPages().remove(lastChangePage);
			
			System.out.println("Remove Page from RAM:" + lastChangePage.getContent());
		}
	}
	
	public void WorkPage(int indexPage, String content) {
		if (RAM.getPages().size() - 1 < indexPage) {
			return;
		}
		
		RAM.getPages().get(indexPage).setDAteLastUsing(Instant.now().toEpochMilli());
		RAM.getPages().get(indexPage).setContent(content);
	}
}
