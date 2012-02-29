package controllers

import jobs._
import play._
import play.mvc._

object Application extends Controller {

	def index = Template

}

object DemoOld extends Controller {

	def index = Template
	
	def init = {
    	var now = new java.util.Date().toString
    	Json("""{"init":"%s"}""".format(now));
    }

	def update = {
    	var now = new java.util.Date().toString
    	WaitFor(CasesManager.promiseNext());
    	Json("""{"update":"%s"}""".format(now));
    }
	
}
