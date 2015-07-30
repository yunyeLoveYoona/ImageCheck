package com.yun.photo;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import com.yun.imagecheck.ImageCheck;
import com.yun.imageshear.ImageShearActivity;

public class CarmeraActivity extends Activity {
	private String imagePath;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = new Intent(
				android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
		imagePath = this.getExternalCacheDir().getAbsolutePath();
		imagePath = imagePath + "/temp.jpg";
		Uri uri = Uri.fromFile(new File(imagePath));
		intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
		startActivityForResult(intent, 100);

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		File file = new File(imagePath);
		boolean is = file.exists();
		if (resultCode == Activity.RESULT_OK) {
			BitmapFactory.Options options = new BitmapFactory.Options();
			options.inJustDecodeBounds = true;
			BitmapFactory.decodeFile(imagePath, options);
			options.inSampleSize = 2;
			options.inJustDecodeBounds = false;
			ImageCheck.checkedBitmap = BitmapFactory.decodeFile(imagePath,
					options);
			file.delete();
			Intent intent = new Intent(CarmeraActivity.this,
					ImageShearActivity.class);
			CarmeraActivity.this.startActivity(intent);
		} else {
			finish();
		}
	}

	@Override
	public void onConfigurationChanged(Configuration config) {
		super.onConfigurationChanged(config);
	}
}
