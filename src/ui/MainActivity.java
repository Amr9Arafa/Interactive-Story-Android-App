package ui;

import com.example.interactivestory.R;
import com.example.interactivestory.R.id;
import com.example.interactivestory.R.layout;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
* Author
* Ahmed Sami <asyn.nile@gmail.com>
**/

public class MainActivity extends ActionBarActivity {
	
	
	private EditText nameField;
	private Button startButton;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		nameField =(EditText)findViewById( R.id.nameEditText);
		startButton =(Button)findViewById(R.id.startButoon);
		
		startButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			String name =nameField.getText().toString();
			
			
		
			
			startStory(name);
			
				
				
			}
		});
		
		
	}
	
	
    private void startStory(String name)
	     {
    	
    	    Intent intent= new Intent(this,StoryActivity.class);
    	    intent.putExtra("name", name);
    	    startActivity(intent);
	    	 
	     }

}
