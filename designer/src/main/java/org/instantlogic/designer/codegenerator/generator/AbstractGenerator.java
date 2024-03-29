package org.instantlogic.designer.codegenerator.generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.instantlogic.designer.Design;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;

public abstract class AbstractGenerator {

	protected ObservationsOutdatedObserver observations;

	public abstract void update(GeneratedClassModels context);
	
	public abstract void delete(GeneratedClassModels context);
	
	protected <G extends AbstractGenerator> List<Design> updateGenerators(Map<String, G> generators, Iterable<? extends Design> from, GeneratedClassModels context) {
		List<Design> newConcepts = new ArrayList<Design>();
		for(Design instance: from) {
			AbstractGenerator generator = generators.get(instance.getName());
			if (generator!=null) {
				generator.update(context);
			} else {
				newConcepts.add(instance);
			}
		}
		Iterator<Map.Entry<String, G>> i = generators.entrySet().iterator();
		nextEntry: while (i.hasNext()) {
			Entry<String, G> entry = i.next();
			for (Design instance : from) {
				if (entry.getKey().equals(instance.getName())) {
					break nextEntry;
				}
			}
			entry.getValue().delete(context);
			i.remove();
		}
		return newConcepts;
	}
	
	protected void updateAll(Collection<? extends AbstractGenerator> generators, GeneratedClassModels context) {
		for (AbstractGenerator generator: generators) {
			generator.update(context);
		}
	}

	protected String javaSafeName(String name) {
		if ("package".equals(name) || "default".equals(name)) {
			return "_"+name;
		}
		return name;
	}
}
