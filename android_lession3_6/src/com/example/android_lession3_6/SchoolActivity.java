package com.example.android_lession3_6;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SchoolActivity extends Activity {

	private Button querenBtn;
	private EditText schoolEt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_school);
		
		querenBtn = (Button)findViewById(R.id.button1);
		schoolEt = (EditText)findViewById(R.id.school_et_prov);
		querenBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent =getIntent();
				intent.putExtra("school", schoolEt.getText().toString());
				
				setResult(200, intent);
				SchoolActivity.this.finish();
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.school, menu);
		return true;
	}

}
