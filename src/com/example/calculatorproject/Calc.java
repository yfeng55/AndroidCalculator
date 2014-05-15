package com.example.calculatorproject;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

//extend the Activity class and implement the OnClickListener interface
public class Calc extends Activity implements View.OnClickListener{
	
	private static double operand1;
	private static double operand2;
	private static int operation;
	public static double result;
	EditText display;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calc);
		
		//set Display
		display = (EditText) findViewById(R.id.editText1);
		
		//set onClick() listeners to buttons
		ViewGroup group = (ViewGroup)findViewById(R.id.viewgroup1);
		View v;
		for(int i = 0; i < group.getChildCount(); i++) {
		    v = (Button) group.getChildAt(i);
	    	
		    if(v instanceof Button){
	    		v.setOnClickListener(this);
	    	}
		}
		
		
	}

	@Override
	public void onClick(View arg0) {
		
		Editable str = display.getText();
		
		switch(arg0.getId()){
			case R.id.button10:
				str = str.append("0");
				Log.i("output", "str is set");
				break;
			case R.id.button7:
				str = str.append("1");
				break;
			case R.id.button8:
				str = str.append("2");
				break;
			case R.id.button9:
				str = str.append("3");
				break;
			case R.id.button4:
				str = str.append("4");
				break;
			case R.id.button5:
				str = str.append("5");
				break;
			case R.id.button6:
				str = str.append("6");
				break;
			case R.id.button1:
				str = str.append("7");
				break;
			case R.id.button3:
				str = str.append("8");
				break;
			case R.id.button2:
				str = str.append("9");
				break;
			//clear button
			case R.id.button11:
				//create a blank Editable
				str = new SpannableStringBuilder("");
				Log.i("output", "cleared display");
				break;
			//divides
			case R.id.button13:
				operand1 = Double.parseDouble(str.toString());
				operation = 1;
				str = new SpannableStringBuilder("");
				break;	
			//times
			case R.id.button14:
				operand1 = Double.parseDouble(str.toString());
				operation = 2;
				str = new SpannableStringBuilder("");
				break;
			//minus
			case R.id.button15:
				operand1 = Double.parseDouble(str.toString());
				operation = 4;
				str = new SpannableStringBuilder("");
				break;
			//plus
			case R.id.button16:
				operand1 = Double.parseDouble(str.toString());
				operation = 3;
				str = new SpannableStringBuilder("");
				break;
			//equals button
			case R.id.button12:
				
				operand2 = Double.parseDouble(str.toString());
				
				if(operation == 1){
					result = operand1 / operand2;
					str = new SpannableStringBuilder(Double.toString(result));
				}
				else if(operation == 2){
					result = operand1 * operand2;
					str = new SpannableStringBuilder(Double.toString(result));
				}
				else if(operation == 3){
					result = operand1 + operand2;
					str = new SpannableStringBuilder(Double.toString(result));				
				}
				else if(operation == 4){
					result = operand1 - operand2;
					str = new SpannableStringBuilder(Double.toString(result));
				}
				
				break;
		}
		
		display.setText(str);
		
	}

}
