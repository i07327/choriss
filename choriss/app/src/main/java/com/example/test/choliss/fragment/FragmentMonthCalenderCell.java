package com.example.test.choliss.fragment;

import java.util.Calendar;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.choliss.R;

public class FragmentMonthCalenderCell extends Fragment {

	private View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// ルートビュー取得
		rootView = inflater.inflate(R.layout.fragment_calender_cell, container,
				false);

		FrameLayout cell = (FrameLayout) rootView.findViewById(R.id.cell);
		cell.setOnTouchListener(touch);

		ImageView image = (ImageView) rootView
				.findViewById(R.id.imageView1);

		image.setVisibility(View.INVISIBLE);

		return rootView;
	}
	
	/**
	 * 日付の設定
	 * @param cal セルの日付
	 * @param cal2 表示月の日付
	 */
	public void setDate(Calendar cal, Calendar cal2) {
		TextView tv = (TextView) rootView.findViewById(R.id.one_su_text);
		//日付取得
		String date = String.valueOf(cal.get(Calendar.DATE));
		tv.setText(date);
		
		// 曜日が土曜日または日曜日なら色を変更する。
		switch (cal.get(Calendar.DAY_OF_WEEK)) {
		case Calendar.SATURDAY:
			tv.setTextColor(0xff0000ff);
			break;

		case Calendar.SUNDAY:
			tv.setTextColor(0xffff0000);
			break;

		default:
			tv.setTextColor(0xff000000);
			break;
		}
		
		// その月以外はグレー
		if (cal.get(Calendar.MONTH) != cal2.get(Calendar.MONTH)) {
			tv.setTextColor(0xff999999);
		}

	}

	/**
	 * タッチイベント
	 */
	OnTouchListener touch = new OnTouchListener() {

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			ImageView image = (ImageView) rootView
					.findViewById(R.id.imageView1);

			// 日付セル押下時の画像表示を切り替える
			switch (image.getVisibility()) {
				case View.VISIBLE:

					image.setVisibility(View.INVISIBLE);
					break;

				case View.INVISIBLE:

					image.setVisibility(View.VISIBLE);
					break;

				default:
					image.setVisibility(View.INVISIBLE);
					break;
			}
			return false;
		}
	};
}
