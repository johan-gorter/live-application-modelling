package ${rootPackageName};


public class ${name}ApplicationGenerator extends ApplicationDesign {

    public static final ${name}ApplicationGenerator APPLICATION = new ${name}ApplicationGenerator();
    
    public ${name}ApplicationGenerator() {
        setName("${name}");
        setRootPackageName("${rootPackageName}");
        setSourcePath("${sourcePath}");
        setCaseEntity(${caseEntity.name}EntityGenerator.ENTITY);
        init();
    }
}