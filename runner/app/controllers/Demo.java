package controllers;

import java.util.Date;
import java.util.concurrent.Executors;

import jobs.CasesManager;
import play.mvc.Controller;
import carinsurance.page.FirstPage;

public class Demo extends Controller {
	
	static {
		System.out.println("Reloading");
		Executors.newSingleThreadExecutor().execute(new Runnable() {

			@Override
			public void run() {
				CasesManager.reloaded();
			}});
	}
	
	public static void index() {
		render();
	}
	
	public static void init() {
    	renderJSON( FirstPage.render() );
    }

	public static void update() {
		
		
		await(CasesManager.promiseNext());
    	renderJSON( FirstPage.render() );
	}

}
