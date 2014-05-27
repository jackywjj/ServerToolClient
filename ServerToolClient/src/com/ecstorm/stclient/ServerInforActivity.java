package com.ecstorm.stclient;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.ecstorm.model.ServerInfor;
import com.ecstorm.model.ServerInforGenerator;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class ServerInforActivity extends Activity {
	ServerInfor si = null;
	TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_server_infor);
		
		int inforType = 0;
		if (getIntent().getExtras() != null) {
			inforType = getIntent().getExtras().getInt("inforType");
		}
	
		si = ServerInforGenerator.getServerInfor(inforType);
		tv = (TextView) findViewById(R.id.serverinfor_result);
		
		new Thread() {
			@Override
			public void run() {
				String url = si.getFullUrl();
				DefaultHttpClient httpclient = new DefaultHttpClient();
				HttpGet httpGet = new HttpGet(url);
				try {
					HttpResponse response1 = httpclient.execute(httpGet);
					mHandler.obtainMessage(0,
							EntityUtils.toString(response1.getEntity()))
							.sendToTarget();
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
	
	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case 0:
					tv.setText( si.parseResponse((String)msg.obj) );
					break;
			}
		}
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.server_infor, menu);
		return true;
	}
}