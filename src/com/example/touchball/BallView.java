package com.example.touchball;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.touchball.R;

public class BallView extends SurfaceView implements SurfaceHolder.Callback {

	private Bitmap bitmap ;
	private MyThread thread;
	private int x=20,y=20;int width,height;
	private Canvas canvas;

	public BallView(Context context,int w,int h) 
	{
		super(context);
		width=w;
		height=h;
		thread=new MyThread(getHolder(),this);
		getHolder().addCallback(this);
		setFocusable(true);
	}

	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		
		this.canvas = canvas;
		super.onDraw(canvas);

		bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ball_green);

		canvas.drawColor(Color.BLUE);//To make background
		canvas.drawBitmap(bitmap,x-(bitmap.getWidth()/2),y-(bitmap.getHeight()/2),null);
		
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		int action = event.getAction();
		
		if (event.getAction() == MotionEvent.ACTION_DOWN)
		{
			
			x=(int)event.getX();
			y=(int)event.getY();

			if(x> width)   
				x=width;

			if(y > height)
				y=height;
		}
		
		else if (event.getAction() == MotionEvent.ACTION_MOVE)
		{
			
			x=(int)event.getX();
			y=(int)event.getY();

			if(x> width)   
				x=width;

			if(y > height)
				y=height;
		}
			
		else if (event.getAction() == MotionEvent.ACTION_UP)
		{
		}

		return true;
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {

		thread.startrun(true);
		thread.start();

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {


		thread.startrun(false);
		//thread.stop();

	}   
}