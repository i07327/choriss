package com.example.test.choliss.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.test.choliss.R;

/**
 * 月間カレンダー画面
 * @author minei
 *
 */
public class MonthCalenderActivity extends FragmentActivity {
	private int arrayId[] = {R.id.fragment_calender_cell, R.id.fragment_calender_cell2};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_month_calender);
	}
}
