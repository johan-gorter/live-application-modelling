package org.instantlogic.engine.manager;

import java.util.Map;

public class Update {
	
	private String name;
	private String location;
	private Map<String, Object> rootFragment;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Map<String, Object> getRootFragment() {
		return rootFragment;
	}
	public void setRootFragment(Map<String, Object> rootFragment) {
		this.rootFragment = rootFragment;
	}	
}