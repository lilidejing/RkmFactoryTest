package com.csw.rkmfactorytest;

import java.util.ArrayList;
import java.util.List;



import com.csw.communication.WifiAdmin;
import com.csw.communication.WifiInfo;
import com.csw.communication.WifiListAdapter;


import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class WifiListActivity extends Activity {

	
	private ListView mListView;
	
	
	private WifiManager wifiManager = null;
	// private String ssidName;
	// private WifiListAdapter wifiListAdapter;
	public static List<WifiInfo> wfinfoList = new ArrayList<WifiInfo>();
	private String test;
	private WifiAdmin mWifiAdmin;
	// 扫描结果列表
	private List<ScanResult> scanList;

	

	private static String stopFlag = "0";

	/** 扫描完毕接收器 */
	private WifiReceiver receiverWifi;
	private WifiListAdapter wifiListAdapter;
	
	
	private ProgressDialog dialog;
	
	
	private TextView currentWifiTextView;
	
	private Context mContext;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.wifilistactivity);
		
		
		
		mContext=this;
		currentWifiTextView=(TextView)this.findViewById(R.id.currentConnectWifi);
		mListView=(ListView)this.findViewById(R.id.currentWifiListView);
		
		wifiManager = (WifiManager) WifiListActivity.this
				.getSystemService(Context.WIFI_SERVICE);
		mWifiAdmin = new WifiAdmin(WifiListActivity.this, test);

		receiverWifi =new WifiReceiver();
	
		stopFlag = "0";


		OpenWifi();
		if (wfinfoList != null) {
			wfinfoList.clear();
		}
		mWifiAdmin.startScan();
		
		dialog = ProgressDialog.show(WifiListActivity.this, "", "正在扫描WIFI热点,请稍候");
		
		setDialogFontSize(dialog,30);
		dialog.setCancelable(true);
		
		
//		mHandler.sendEmptyMessage(0);
	}
	
	
	/*
	 * 检查当前WIFI是否连接，两层意思——是否连接，连接是不是WIFI
	 */
	public static boolean isWifiConnected(Context context) {

		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = cm.getActiveNetworkInfo();
		if (info != null && info.isConnected()
		&& ConnectivityManager.TYPE_WIFI == info.getType()) {
			return true;
		}
		return false;
	}

	
	Handler mHandler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch(msg.what){
			
			case 0:
				
				boolean weatherConnect=isWifiConnected(mContext);
				if(weatherConnect==false){
					currentWifiTextView.setText("当前网络未连接");
				}else{
					android.net.wifi.WifiInfo info = wifiManager.getConnectionInfo();     
		            int strength = info.getRssi();  
		            int speed = info.getLinkSpeed();    
		            String units = android.net.wifi.WifiInfo.LINK_SPEED_UNITS;    
		            String ssid = info.getSSID();  
		            String ip=intToIp(info.getIpAddress());
		            
		            String mac=info.getMacAddress();
		            
		            currentWifiTextView.setText("已连接网络："+ssid+"     信号强度："+strength+"     速度："+speed+ String.valueOf(units)+"    IP地址："+ip+"     mac地址："+mac+"    热点数量："+wfinfoList.size()) ;
				}
				
				
				break;
				
			default:
					
			   break;
			}
			
			
		};
	};
	
	/*
	 * 获取IP
	 */
	  private String intToIp(int i) {
          return (i & 0xFF) + "." + ((i >> 8) & 0xFF) + "." + ((i >> 16) & 0xFF)
                          + "." + ((i >> 24) & 0xFF);
  }
	 
	
	/**
	 * 打开WIFI
	 */
	public void OpenWifi()
	{

		if (!wifiManager.isWifiEnabled())
		{
			wifiManager.setWifiEnabled(true);
		}

	}


class WifiReceiver extends BroadcastReceiver
{
	public void onReceive(Context context, Intent intent)
	{
		if (intent.getAction().equals(
				WifiManager.SCAN_RESULTS_AVAILABLE_ACTION))
		{
			
			scanList = mWifiAdmin.getWifiList();
			if (scanList != null) {
				for (int i = 0; i < scanList.size(); i++) {
					WifiInfo info = new WifiInfo();
					ScanResult s = scanList.get(i);
					info.setLeved(s.level);
					info.setSsid(s.SSID);
					info.setLeved(s.level);
					info.setWifisecurity(s.capabilities);
					
					int chanel=getChanel(s.frequency);
					info.setWifiChanel(chanel+"");
					System.out.println(s.SSID);
					
					wfinfoList.add(info);
				}
			} 
			
			if (wfinfoList.size() == 0) {
		
				Toast.makeText(WifiListActivity.this, "没有扫描到WiFi", 2000).show();
				dialog.dismiss();
			} else {
				// step1Changed(STATE_COMPLETED);
				if (stopFlag.equals("0")) {
					dialog.dismiss();
					wifiListAdapter = new WifiListAdapter(
							WifiListActivity.this, wfinfoList);
					mListView.setAdapter(wifiListAdapter);
					mHandler.sendEmptyMessageDelayed(0, 1000);
					
				} else {
					System.out.println("线程停");
				}

			}

		}

	}
}


/**
 * 获取信道的方法
 */
private int getChanel(int currentFrequency){
	int currentChannel=0;
	switch (currentFrequency) {
	case 2412:
		currentChannel = 1;
		break;
	case 2417:
		currentChannel = 2;
		break;
	case 2422:
		currentChannel = 3;
		break;
	case 2427:
		currentChannel = 4;
		break;
	case 2432:
		currentChannel = 5;
		break;
	case 2437:
		currentChannel = 6;
		break;
	case 2442:
		currentChannel = 7;
		break;
	case 2447:
		currentChannel = 8;
		break;
	case 2452:
		currentChannel = 9;
		break;
	case 2457:
		currentChannel = 10;
		break;
	case 2462:
		currentChannel = 11;
		break;
	case 2467:
		currentChannel = 12;
		break;
	case 2472:
		currentChannel = 13;
		break;
	default:
		currentChannel = 0;
		break;
	}

	return currentChannel;

}


@Override
protected void onResume() {
	// TODO Auto-generated method stub
	super.onResume();
	registerReceiver(receiverWifi, new IntentFilter(
			WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));// 注册广播
}

	
@Override
public void onDestroy() {
	// TODO Auto-generated method stub
	super.onDestroy();
	stopFlag = "1";
	unregisterReceiver(receiverWifi);// 注销广播
}
	
private void setDialogFontSize(Dialog dialog,int size)
{
    Window window = dialog.getWindow();
    View view = window.getDecorView();
    setViewFontSize(view,size);
}
private void setViewFontSize(View view,int size)
{
    if(view instanceof ViewGroup)
    {
        ViewGroup parent = (ViewGroup)view;
        int count = parent.getChildCount();
        for (int i = 0; i < count; i++)
        {
            setViewFontSize(parent.getChildAt(i),size);
        }
    }
    else if(view instanceof TextView){
        TextView textview = (TextView)view;
        textview.setTextSize(size);
    }
}

}
