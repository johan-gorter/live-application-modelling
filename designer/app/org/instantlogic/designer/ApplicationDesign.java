package org.instantlogic.designer;

import java.io.File;

import org.instantlogic.designer.codegenerator.generator.ApplicationGenerator;

public class ApplicationDesign extends AbstractApplicationDesign {
	
	private ApplicationGenerator applicationGenerator = new ApplicationGenerator(this);
	
	public ApplicationDesign() {
		
	}

	public ApplicationGenerator getApplicationGenerator() {
		return applicationGenerator;
	}
	
	/**
	 * Registers every entity reachable from caseEntity to application.entities. Also calls init() on every entity.
	 */
	protected void init() {
		String packageName = getClass().getName();
		packageName = packageName.substring(0, packageName.lastIndexOf('.'));
		eagerlyLoadAllClasses(new File(getClass().getResource("").getFile()), packageName);
		
		getCaseEntity().registerApplication(this);
		for (EntityDesign entity:getEntities()) {
			entity.init();
		}
		for (FlowDesign flow: getFlows()) {
			flow.init();
		}
	}

	private void eagerlyLoadAllClasses(File packageDir, String packageName) {
		File[] entries = packageDir.listFiles();
        String entryName;
        for(File entry: entries){
            entryName = entry.getName();
            if (entry.isDirectory()) {
            	eagerlyLoadAllClasses(entry, packageName+"."+entryName);
            	continue;
            }
            try {
            	if (entryName.endsWith("EntityGenerator.class")) {
            		entryName = entryName.substring(0, entryName.lastIndexOf('.'));
					Class<?> cl = getClass().getClassLoader().loadClass(packageName+"."+entryName);
					cl.getField("ENTITY").get(null);
                } else if (entryName.endsWith("EventGenerator.class")) {
            		entryName = entryName.substring(0, entryName.lastIndexOf('.'));
					Class<?> cl = getClass().getClassLoader().loadClass(packageName+"."+entryName);
					EventDesign event = (EventDesign) cl.getField("EVENT").get(null);
                } else if (entryName.endsWith("FlowGenerator.class")) {
            		entryName = entryName.substring(0, entryName.lastIndexOf('.'));
					Class<?> cl = getClass().getClassLoader().loadClass(packageName+"."+entryName);
					cl.getField("FLOW").get(null);
                }
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			} catch (IllegalArgumentException e) {
				throw new RuntimeException(e);
			} catch (NoSuchFieldException e) {
				throw new RuntimeException(e);
			} catch (SecurityException e) {
				throw new RuntimeException(e);
			}
        }
	}
}
