package org.instantlogic.play;

import org.instantlogic.interaction.util.PageCoordinates;

public class Session {

	private String id;
	
	private String userName;
	
	private PageCoordinates pageCoordinates;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public PageCoordinates getPageCoordinates() {
		return pageCoordinates;
	}

	public void setPageCoordinates(PageCoordinates pageCoordinates) {
		this.pageCoordinates = pageCoordinates;
	}
}
