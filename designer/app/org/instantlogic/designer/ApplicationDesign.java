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

		//TODO: flows
		for (EntityDesign entity:getEntities()) {
			entity.init();
		}
	}

	private void eagerlyLoadAllClasses(File packageDir, String packageName) {
		File[] classes = packageDir.listFiles();
        String entryName;
        for(File c: classes){
            entryName = c.getName();
            if (!entryName.endsWith("EntityGenerator.class")) continue;
            entryName = entryName.substring(0, entryName.lastIndexOf('.'));
            try {
				Class<?> cl = getClass().getClassLoader().loadClass(packageName+"."+entryName);
				cl.getField("ENTITY").get(null);
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
