package jobs

import play.jobs._
import play.libs.F._
import java.util._
import scala.collection.immutable.List


@OnApplicationStart(async = true)
@Every("1s")
class EveryMinute extends Job {
	
	Console.println("Reloading");
	
//	val date = new Date();
	
	override def doJob() = {
//		Console.println("HUH235? "+date);
	}
}

object CasesManager {
	
	private var proms = List[Promise[Date]]();
	
	def promises = proms;
	def promises_= (promises: List[Promise[Date]] )  = {
		proms = promises;
		Console.println("Reload at: "+new Date());
	}
	
	def promiseNext() : Promise[Date] = {
		var promise = new Promise[Date]();
		promises ::= promise;
		return promise;
	}
	
	def reloaded() = {
		Console.println("Reloaded "+promises.length);
		update();
	}
	
	def update() {
		var now = new Date(2010,1,1);
		Console.println("Updating "+promises.length);
		for (promise <- promises) {
			promise.invoke(now)
		}
		promises = List[Promise[Date]]();
	}

	Console.println("Constructed "+promises.length);
	
}
