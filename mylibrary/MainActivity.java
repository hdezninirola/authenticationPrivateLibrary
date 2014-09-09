package com.ninirola.mylibrary;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import ninirola.Authenticator;
import ninirola.LayoutCreator;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(LayoutCreator.createLoginLayout(this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onAcceptClick(View v) {
		final EditText et_user = (EditText) findViewById(R.id.editText_user);
		final EditText et_pass = (EditText) findViewById(R.id.editText_pass);
		
		new Thread(new Runnable() {
		    public void run() {
		    	boolean resultOK = Authenticator.authenticate(et_user.getText().toString(), et_pass.getText().toString());
		    	if(resultOK)
		    		Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();
		    	else Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
		    }
		}).start();
	}

}
