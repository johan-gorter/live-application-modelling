package org.instantlogic.mini.generator;

import java.io.File;
import java.util.HashMap;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.codegenerator.javacode.ApplicationJavacodeGenerator;
import org.instantlogic.designer.codegenerator.jvmbytecode.ApplicationBytecodeGenerator;
import org.instantlogic.designer.codegenerator.jvmbytecode.BytecodeClassloader;
import org.instantlogic.fabric.Instance;

public class MiniGenerator {

	public static void main(String[] args) throws Exception {
		ApplicationDesign applicationInstance = new MiniApplicationDesign();
		GeneratedClassModels classModelUpdates = applicationInstance.getApplicationGenerator().getClassModelUpdates();
		
		
		HashMap<String, byte[]> classesToLoad = new HashMap<String, byte[]>();
		ApplicationBytecodeGenerator.generate(classModelUpdates, classesToLoad);
		ClassLoader classLoader = new BytecodeClassloader(new File("../mini/bin").toURI().toURL(), MiniGenerator.class.getClassLoader(), classesToLoad);
		Instance thing = (Instance) classLoader.loadClass("com.instantlogic.mini.MiniThing").newInstance();
		if (!"MiniThing".equals(thing.getMetadata().getEntity().getName())) {
			throw new Exception("HMM");
		}
		
		ApplicationJavacodeGenerator.generate(classModelUpdates, new File(applicationInstance.getSourcePath()));
	}
}
