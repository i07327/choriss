package com.example.test.choliss.fragment;

import java.util.Calendar;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.test.choliss.R;

public class FragmentMonthCalender extends Fragment {
	
	private int arrayId[] = {R.id.fragment_calender_cell, R.id.fragment_calender_cell2, R.id.fragment_calender_cell3, R.id.fragment_calender_cell4, R.id.fragment_calender_cell5, R.id.fragment_calender_cell6, R.id.fragment_calender_cell7,
							R.id.fragment_calender_cell8, R.id.fragment_calender_cell9, R.id.fragment_calender_cell10, R.id.fragment_calender_cell11, R.id.fragment_calender_cell12, R.id.fragment_calender_cell13, R.id.fragment_calender_cell14,
							R.id.fragment_calender_cell15, R.id.fragment_calender_cell16, R.id.fragment_calender_cell17, R.id.fragment_calender_cell18, R.id.fragment_calender_cell19, R.id.fragment_calender_cell20, R.id.fragment_calender_cell21,
							R.id.fragment_calender_cell22, R.id.fragment_calender_cell23, R.id.fragment_calender_cell24, R.id.fragment_calender_cell25, R.id.fragment_calender_cell26, R.id.fragment_calender_cell27, R.id.fragment_calender_cell28,
							R.id.fragment_calender_cell29, R.id.fragment_calender_cell30, R.id.fragment_calender_cell31, R.id.fragment_calender_cell32, R.id.fragment_calender_cell33, R.id.fragment_calender_cell34, R.id.fragment_calender_cell35,
							R.id.fragment_calender_cell36, R.id.fragment_calender_cell37, R.id.fragment_calender_cell38, R.id.fragment_calender_cell39, R.id.fragment_calender_cell40, R.id.fragment_calender_cell41, R.id.fragment_calender_cell42};
	
	private View rootView;
	private Calendar _cal = Calendar.getInstance();

	@Override
	public View onCreateView(
		LayoutInflater inflater, 
		ViewGroup container, 
		Bundle savedInstanceState) {
		
		// ルートビュー取得
		rootView = inflater.inflate(
				R.layout.fragment_month_calender, container, false);

		// ボタンイベント設定
		rootView.findViewById(R.id.next_month_id).setOnClickListener(onClickNextMonth);

		// 現在月の1日を取得
		_cal.set(Calendar.DATE, 1);

		// 初期処理
		init(_cal.get(Calendar.YEAR), _cal.get(Calendar.MONTH));

		return rootView;
	}

	private void init(int year, int month) {
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal2.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal2.set(Calendar.MONTH, month);
		cal.set(Calendar.DATE, 1);
		cal2.set(Calendar.DATE, 1);

		// ヘッダ情報設定
		TextView tvMonth = (TextView) rootView.findViewById(R.id.header_month_text);
		tvMonth.setText(String.valueOf(cal.get(Calendar.YEAR)) + "年" + String.valueOf(cal.get(Calendar.MONTH) + 1) + "月");

		// 曜日から開始日付を調整
		if (Calendar.SUNDAY < cal.get(Calendar.DAY_OF_WEEK)) {
			cal.add(Calendar.DATE, 1 - cal.get(Calendar.DAY_OF_WEEK));
		}

		// カレンダーのセルごとに日付を設定
		for (int id : arrayId) {
			FragmentManager fm = getFragmentManager();
			// セルごとのフラグメントに日付を設定
			FragmentMonthCalenderCell obj = (FragmentMonthCalenderCell) fm.findFragmentById(id);
			obj.setDate(cal, cal2);

			// 次の日付
			cal.add(Calendar.DATE, 1);
		}
	}

	OnClickListener onClickNextMonth = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// 次の月取得
			_cal.add(Calendar.MONTH, 1);

			// 初期処理
			init(_cal.get(Calendar.YEAR), _cal.get(Calendar.MONTH));
		}
	};
}
