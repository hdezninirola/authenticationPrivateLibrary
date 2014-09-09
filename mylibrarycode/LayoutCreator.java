package ninirola;

import android.app.Activity;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class LayoutCreator {

	public static View createLoginLayout(final Activity context) {
		LinearLayout loginLayout = new LinearLayout(context);
		loginLayout.setOrientation(LinearLayout.VERTICAL);
		
		TextView headerText = new TextView(context, null, android.R.attr.textAppearanceLarge);
		headerText.setText("Please log-in to enter");
		
		EditText userInput = new EditText(context);
		userInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
		userInput.setId(R.id.userInput);
		userInput.setHint("eMail address");
		
		EditText passwordInput = new EditText(context);
		passwordInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
		passwordInput.setId(R.id.passwordInput);
		passwordInput.setHint("Password");
		
		Button loginButton = new Button(context);
		loginButton.setText("Accept");
		loginButton.setId(R.id.loginButton);

		loginButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				new Thread(new Runnable() {
				    public void run() {
				    	TextView user = (TextView) context.findViewById(R.id.userInput);
						TextView password = (TextView) context.findViewById(R.id.passwordInput);
				    	
				    	Authenticator.authenticate(user.getText().toString(), password.getText().toString());
				    }
				}).start();
				
			}
		});

		// Add elements
		loginLayout.addView(headerText);
		loginLayout.addView(userInput);
		loginLayout.addView(passwordInput);
		loginLayout.addView(loginButton);

		return loginLayout;
	}
}
