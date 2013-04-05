package com.example.touchball;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MyThread extends Thread {

	private SurfaceHolder msurfaceHolder;
	private BallView mballView;
	private boolean mrun =false;

	public MyThread(SurfaceHolder holder, BallView ballView) {

		msurfaceHolder = holder;
		mballView=ballView;
	}

	public void startrun(boolean run) {

		mrun=run;
	}

	@Override
	public void run() {

		super.run();
		Canvas canvas;
		while (mrun) {
			canvas=null;
			try {
				canvas = msurfaceHolder.lockCanvas(null);
				synchronized (msurfaceHolder) {
					mballView.onDraw(canvas);
				}
			} finally {
				if (canvas != null) {
					msurfaceHolder.unlockCanvasAndPost(canvas);
				}
			}
		}
	}

}