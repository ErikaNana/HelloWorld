package lab1.helloworld;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

public class HelloWorldActivity extends Activity {
	android.widget.TextView output;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_helloworld);
		//retrieve Bundle object (hashmap) in which you placed the user entered name
		Bundle hashmap = this.getIntent().getExtras();
		//just a check.  should never happen
		//retrieve user entered name from Bundle object and store it in local String object
		String name = hashmap.getString("name");
		//make sure it's not null
		
		//getting the text from textview from the helloworld layout
		//had to give the TextView an id, since couldn't find it when did R.id
		output = (TextView) findViewById(R.id.text_output);
		output.setText("Hello " + name + "!");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_helloworld, menu);
		return true;
	}

}
