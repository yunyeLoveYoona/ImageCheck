package com.yun.imagescan;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.GridView;
import android.widget.Toast;

import com.yun.check.R;
import com.yun.imageshear.ImageShearActivity;

public class ShowImageActivity extends Activity {
	private GridView mGridView;
	private List<String> list;
	private ChildAdapter adapter;
	public static final int GO_TO_SHARE_ACTIVITY = 100001;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_image_activity);
		mGridView = (GridView) findViewById(R.id.child_grid);
		list = getIntent().getStringArrayListExtra("data");
		adapter = new ChildAdapter(this, list, mGridView, handler);
		mGridView.setAdapter(adapter);

	}

	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case GO_TO_SHARE_ACTIVITY:
				Intent intent = new Intent(ShowImageActivity.this,
						ImageShearActivity.class);
				ShowImageActivity.this.startActivity(intent);
				break;
			}
			super.handleMessage(msg);
		}

	};

	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}

}
