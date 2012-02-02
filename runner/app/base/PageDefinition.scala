package base

class PageDefinition(val name: String, val content: List[ElementDefinition]) extends ElementDefinition {
	
	val elementType = "page";
	
	override def render(): PageModelElement = {
		var result = super.render();
		result.content = (this.content.map((d: ElementDefinition)  => d.render)).toArray
		return result;
	}
	
}