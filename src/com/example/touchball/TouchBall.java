package com.example.touchball;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;

public class TouchBall extends Activity {


	@TargetApi(13)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Point outSize = new Point();

		// int w=getWindowManager().getDefaultDisplay().getWidth()-25;
		//int h=getWindowManager().getDefaultDisplay().getHeight()-25;
		
		getWindowManager().getDefaultDisplay().getSize(outSize);
		
		int w = outSize.x;
		int h = outSize.y;		

		BallView ballView=new BallView(this,w,h);
		setContentView(ballView);
	}
	
	protected void onSuspend(Bundle savedInstanceState)
	{
	}


}
