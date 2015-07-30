package com.yun.imageshear;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.yun.check.R;
import com.yun.imagecheck.ImageCheck;

public class ImageShearActivity extends Activity {
	private ShearView shearimage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_shear);
		shearimage = (ShearView) findViewById(R.id.shearimage);
		shearimage.imageView.setImageBitmap(ImageCheck.checkedBitmap);
		findViewById(R.id.shear).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				shearimage.shear();
			}
		});
		findViewById(R.id.reset).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				shearimage.reset();
			}
		});
	}

	@Override
	protected void onDestroy() {
		shearimage.imageView.setImageBitmap(null);
		super.onDestroy();
	}

}
