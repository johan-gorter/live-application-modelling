package lbe.engine.codegenerator;

import app.designerbootstrap.data.entity.EntityEntity;
import app.designerbootstrap.data.instance.EntityInstance;

public class CodeGenerator {

	public static void generateEntity(EntityInstance entity) {
		System.out.println("Name: "+entity.name.get());
	}
}
