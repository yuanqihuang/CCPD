package com.example.android_lession3_6;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button choiceBtn;
	private Button schoolBtn;
	
	public static final int HOME_REQUESTCODE=1;
	public static final int SCHOOL_REQUESTCODE=2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(com.example.android_lession3_6.R.layout.activity_main);
		
		choiceBtn=(Button)findViewById(com.example.android_lession3_6.R.id.main_btn_choicehome);
		schoolBtn = (Button)findViewById(com.example.android_lession3_6.R.id.main_btn_choiceSchool);
		choiceBtn.setOnClickListener(new android.view.View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,HomeActivity.class);
				//第一步：启动Acitivity时调用startActivityForResult
				startActivityForResult(intent, HOME_REQUESTCODE);
			}
		});
		schoolBtn.setOnClickListener(new android.view.View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,SchoolActivity.class);
				startActivityForResult(i, SCHOOL_REQUESTCODE);
			}
		});
	}

	/**
	 * 重写onActivityResult方法对返回回来的数据做处理 。。返回的数据会封装该方法的第三个参数data中。
	 * 第一个参数是判断请求码，第二个参数是判断响应码。
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		//super.onActivityResult(requestCode, resultCode, data);
		
		if(requestCode==HOME_REQUESTCODE&&resultCode==200){
			String home=data.getStringExtra("home");
			choiceBtn.setText(home);
		}
		if(requestCode==SCHOOL_REQUESTCODE&&resultCode==200){
			String school=data.getStringExtra("school");
			schoolBtn.setText(school);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(com.example.android_lession3_6.R.menu.main, menu);
		return true;
	}

}
