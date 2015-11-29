package com.example.test.choliss.activity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.test.choliss.R;

/**
 * スプラッシュ画面
 * 
 * @author minei
 * 
 */
public class SplashActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		// 1秒後に画面を切り替える
		new SplashAsyncTask(this).execute(1);
	}

	/**
	 * スプラッシュ画面表示用の非同期タスク
	 * 
	 * @author minei
	 * 
	 */
	public class SplashAsyncTask extends AsyncTask<Integer, Integer, Long> {

		Context context;

		/**
		 * コンストラクタ
		 * 
		 * @param context
		 */
		public SplashAsyncTask(Context context) {
			this.context = context;
		}

		/**
		 * 最初に呼び出される処理
		 */
		@Override
		protected void onPreExecute() {

		}

		/**
		 * 非同期で実行される処理
		 */
		@Override
		protected Long doInBackground(Integer... params) {

			// パラメータ秒後に画面を切り替える
			try {
				for (int i = 0; i < params[0]; i++) {
					if (isCancelled()) {
						break;
					}
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
			}
			return 123L;
		}

		/**
		 * doInBackground 内で publishProgressが呼ばれると実行される処理
		 */
		@Override
		protected void onProgressUpdate(Integer... values) {
		}

		/**
		 * doInBackground が終了した時に実行される処理
		 */
		@Override
		protected void onPostExecute(Long result) {
			// インテントのインスタンス生成
			Intent intent = new Intent(context, SettingActivity.class);
			// 次画面のアクティビティ起動
			startActivity(intent);
		}

	}
}
