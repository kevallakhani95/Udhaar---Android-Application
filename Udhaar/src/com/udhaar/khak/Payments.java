package com.udhaar.khak;
import com.udhaar.khak.R;

import android.view.LayoutInflater;
import android.view.LayoutInflater;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Payments extends Activity {

	Button p;
	private TextView textViewMainScreen;
	final Context context=this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_payments);
		
		p = (Button) findViewById(R.id.Plus);
		textViewMainScreen=(TextView)findViewById(R.id.textViewResult);
		p.setOnClickListener(new OnClickListener() {

			@SuppressLint("InflateParams")
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				LayoutInflater layoutInflator = LayoutInflater.from(context);
				View promptView =layoutInflator.inflate(R.layout.prompts, null);
				AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(context);
				alertDialogBuilder.setView(promptView);
				final EditText input =(EditText)promptView.findViewById(R.id.userInput);
				alertDialogBuilder.setCancelable(false).setPositiveButton("Add", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						textViewMainScreen.setText(input.getText());
						
					}
				})
				.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.cancel();
					}
				});
				AlertDialog alertD=alertDialogBuilder.create();
				alertD.show();
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.payments, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
