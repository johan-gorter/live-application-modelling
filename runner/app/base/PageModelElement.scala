package base

import scala.collection.immutable.List
import com.google.gson.annotations.SerializedName

class PageModelElement(
		@SerializedName("type")
		var elementType: String,
		var name: String
	) {

	var id: String = null;
	var display: String = null;
	var content : Array[PageModelElement] = Array();
	
}