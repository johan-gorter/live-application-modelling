package lbe.page;

import com.google.gson.annotations.SerializedName;

public class PageElement {
	@SerializedName("type")
	public String elementType;
	public String name;
	public String id;
	public String display;
	public Object value;
	public PageElement[] content;
}
