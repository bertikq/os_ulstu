package labs;


public class Program {
	public static void main(String[] args) {
		MemoryPage memoryPage1 = new MemoryPage("content1", 5);
		MemoryPage memoryPage2 = new MemoryPage("content2", 5);
		MemoryPage memoryPage3 = new MemoryPage("content3", 10);
		MemoryPage memoryPage4 = new MemoryPage("content4", 10);
		

		Disk<MemoryPage> HDD = new Disk<MemoryPage>(100);
		HDD.addPage(memoryPage1);
		HDD.addPage(memoryPage2);
		HDD.addPage(memoryPage3);
		HDD.addPage(memoryPage4);
		
		Disk<VirtualPage> RAM = new Disk<VirtualPage>(15);
		
		MemoryManager manager = new MemoryManager(HDD, RAM);
		
		manager.AddPageInVirtualMemory(0, "test", true);
		manager.AddPageInVirtualMemory(3, "content2", true);
		
		manager.WorkPage(0, "dasd");
		manager.AddPageInVirtualMemory(2, "test", false);
		manager.WorkPage(2, "dafssafasf");
		manager.AddPageInVirtualMemory(2, "test", false);
	}
}
