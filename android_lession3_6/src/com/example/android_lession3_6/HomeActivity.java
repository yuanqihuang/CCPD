package com.example.android_lession3_6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends Activity {

	private Button okBtn;
	private EditText provEt;
	private EditText cityEt;
	private EditText streetEt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		okBtn=(Button)findViewById(R.id.home_btn_ok);
		provEt=(EditText)findViewById(R.id.home_et_prov);
		cityEt=(EditText)findViewById(R.id.home_et_city);
		streetEt=(EditText)findViewById(R.id.home_et_street);
		
		okBtn.setOnClickListener(new android.view.View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=getIntent();
				
				intent.putExtra("home", provEt.getText().toString()+"省"+cityEt.getText().toString()+"市"+streetEt.getText().toString());
				//在BActivity要将数据返回，需要调用 setResult,将数据封装在intent中。使用finish关闭Bacitivy会返回到AActivity
				setResult(200,intent);
				HomeActivity.this.finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

}
