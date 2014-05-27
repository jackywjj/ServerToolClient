package com.ecstorm.stclient;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	ListView listview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listview = (ListView) findViewById(R.id.listview);
		ArrayAdapter<String> listviewAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getData());
		listview.setAdapter(listviewAdapter);
		listview.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3) {
				switch (position) {
					case 0:
						viewServerInfor(0);
						break;
					case 1:
						viewServerInfor(1);
						break;
					case 2:
						viewServerInfor(2);
						break;
					case 3:
						viewServerInfor(3);
						break;
					case 4:
						viewServerInfor(4);
						break;
					case 5:
						viewServerInfor(5);
						break;
					case 6:
						viewServerInfor(6);
						break;
					case 7:
						viewServerInfor(7);
						break;
				}
			}			
		});
		
	}
	private void viewServerInfor(int inforType) {
		Intent intent = new Intent();
		intent.setClass(MainActivity.this, ServerInforActivity.class);
		intent.putExtra("inforType", inforType);
		startActivity(intent);
	}
	private ArrayList<String> getData() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Check CPU");
        list.add("Check Memory");
        list.add("Check Disk");
        list.add("Check Nginx");
        list.add("Check MySQL");
        list.add("Check PHP fpm");
        list.add("Check Uwsgi");
        list.add("Check Gunicorn");
        return list;
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
