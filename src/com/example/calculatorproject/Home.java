package com.example.calculatorproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Home extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		
		//create an anonymous subclass of Thread
		Thread th = new Thread(){
			
			//implement the run function from the Runnable interface
			public void run(){
				
				try{
					sleep(1500);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				finally{
					//start Activity
					Intent i = new Intent(Home.this, Calc.class);
					startActivity(i);
				}
				
			}
		};
		
		th.start();
		
		
	}

	@Override
	protected void onPause() {
		super.onPause();
		finish();
	}
	
	
	
}
