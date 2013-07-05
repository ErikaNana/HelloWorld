package lab1.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnterNameActivty extends Activity implements View.OnClickListener{
	//holds reference to the text field in which user will enter ther name, same one added in
	//name_getter.xml layoutfile
	android.widget.EditText namefield; 
	//hold reference to submit button, same one in name_getter.xml layout file
	android.widget.Button submitButton;
	
	@Override
	//method will be called when Activity starts, where initialization of local and member data

	protected void onCreate(Bundle savedInstanceState) {
		//should be always done first
		super.onCreate(savedInstanceState);
		//already created an XML layout file named name_getter.xml
		//setContentView(R.layout.layout_entername);
		//XML layout files are interchangeable!
		setContentView(R.layout.name_getter);
		// getting the name
		//casting the return value of the type EditText, since method only returns objects
		//of type Object =
		namefield = (EditText) findViewById(R.id.editText1);
		//use "this" keyword just to trigger Eclipse autocomplete
		submitButton = (Button) this.findViewById(R.id.button1);
		//tells Android that this Button is going to rely on the class its in, which implements
		//OnClickListener, to listen for and handle its clicks
		submitButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//means referring to menu_entername resource under the menu type located in R.java
		getMenuInflater().inflate(R.menu.menu_entername, menu);
		return true;
	}
	
	//had to import View, and now using this to implement interface

    public void onClick(View v) {
    	String user_input = namefield.getText().toString();
    	//string use to access the user's name later
    	String name = "name";
    	if (user_input.isEmpty() != true) {
    		//clear EditText text field by setting it to empty String
    		//if Back is pressed, this allows user to enter new text into EditText instead of 
    		//leaving the old text there
    		namefield.setText("");
    	
    	//intents are used to interact with other application components in ways such as 
    	//starting new activities
    	android.content.Intent intent = new Intent(this,HelloWorldActivity.class);
    	//method functions like a hashmap.  can retrieve hashmap later by calling getExtras()
    	intent.putExtra(name, user_input);
    	//this command will initiate the switch to the HelloWorld greeting Activity
    	this.startActivity(intent);    		
    	}       
    }

}
