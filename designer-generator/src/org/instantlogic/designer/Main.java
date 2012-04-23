package org.instantlogic.designer;


public class Main {

	public static void main(String[] args) {
		ApplicationDesign applicationInstance = new DesignerApplicationGenerator();
		applicationInstance.getApplicationGenerator().generateJavaCode();
	}

}
