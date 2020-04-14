package labs;

import java.time.ZonedDateTime;
import java.util.Date;

public class VirtualPage extends AbstractPage {
	
	private boolean IsChange;
	private MemoryPage MemoryPage;
	private long DateLastUsing;
	private boolean ReadOnly;

	public VirtualPage(MemoryPage memoryPage, boolean readOnly, String content, int size, long dateLastUsing) {
		super(content, size);
		MemoryPage = memoryPage;
		ReadOnly = readOnly;
		IsChange = false;
		DateLastUsing = dateLastUsing;
	}

	public void setContent(String content) {
		if (!ReadOnly) 
		{
			this.setContent(content);
			IsChange = true;
		}
	}
	public boolean isIsChange() {
		return IsChange;
	}

	public MemoryPage getMemoryPage() {
		return MemoryPage;
	}
	public long getDateLastUsing() {
		return DateLastUsing;
	}
	
}
