package base

trait ElementDefinition {
	
	val elementType: String
	val name: String
	
	def render(): PageModelElement = {
		return new PageModelElement(elementType = elementType, name = name);
	}
}