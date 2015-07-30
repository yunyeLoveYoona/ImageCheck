package com.yun.imagecheck;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.yun.check.R;
import com.yun.imagescan.CheckFromImageActivity;
import com.yun.photo.CarmeraActivity;

public class ImageCheck {
	private AlertDialog alertDialog;
	private TextView check_from_image, check_from_camera;
	public static Bitmap checkedBitmap;
	private Context context;
	public static boolean checkOne = true;

	public ImageCheck(Activity activity) {
		this.context = activity;
		alertDialog = new AlertDialog.Builder(activity).create();
	}

	public void show() {
		alertDialog.show();
		alertDialog.getWindow().setContentView(R.layout.check_dialog);
		alertDialog.setCanceledOnTouchOutside(true);
		check_from_camera = (TextView) alertDialog.getWindow().findViewById(
				R.id.check_from_camera);
		check_from_image = (TextView) alertDialog.getWindow().findViewById(
				R.id.check_from_image);
		check_from_image.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context,
						CheckFromImageActivity.class);
				context.startActivity(intent);
			}
		});
		check_from_camera.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, CarmeraActivity.class);
				context.startActivity(intent);
			}
		});
	}

}
