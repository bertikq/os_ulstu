package labs;

public abstract class AbstractPage {
	private String Content;
	private int Size;

	public AbstractPage(String content, int size) {
		super();
		Content = content;
		Size = size;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public int getSize() {
		return Size;
	}
}
