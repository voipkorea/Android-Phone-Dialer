/**
 * Android Phone Dialer
 * version 0.0.2
 * 
 * A first step, learning Android application.
 * Takes a phone number as text input and calls the in-build phone
 * dialer activity.
 */
package bee.rish.android.apd;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * This class is the main activity which handles the whole application.
 * @author Rishabh Rao
 */
public class AndroidPhoneDialerActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// The phone number text field.
		final EditText phoneNumber =
				(EditText) findViewById(R.id.phoneNumber);

		// The dial button.
		final Button dialButton = (Button) findViewById(R.id.dialButton);

		// Call the in-build phone dialer activity.
		dialButton.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent dialIntent = new Intent(Intent.ACTION_DIAL,
						Uri.parse("tel:" + phoneNumber.getText()));
				
				dialIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(dialIntent);
			}
		});
	}
}
