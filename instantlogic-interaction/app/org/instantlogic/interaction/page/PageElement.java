package org.instantlogic.interaction.page;

public class PageElement {
//	@com.google.gson.annotations.SerializedName("type")
	public String elementType;
	public String name;
	public String id;
	public boolean readonly;
	public String display;
	public Object value;
	public PageElement[] content;
	public String[] presentationStyles;
	
	public String datatype;
	public Boolean required;
	public Boolean multivalue;
	public String question;
	public String explain;
	public Domain[] domain;
	public Message[] messages;
	public boolean refresh;
	
	public static class Domain {
		public String value;
		public String display;
		public boolean valid;

		public Domain(String value, String display) {
			this.value = value;
			this.display = display;
			this.valid = true;
		}
	}
	
	public static class Message {
		public String type; // error/warning
		public String display;
	}
}
