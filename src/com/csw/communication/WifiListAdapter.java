package com.csw.communication;

import java.util.List;

import com.csw.rkmfactorytest.R;





import android.content.Context;
import android.net.wifi.WifiManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class WifiListAdapter extends BaseAdapter {

	private List<WifiInfo> wifiInfoList;
	private LayoutInflater mInflater;
	private Context context;
	private String ssidName;
	WifiAdmin wifiAdmin;
	String test;
	public WifiListAdapter(Context context, List<WifiInfo> wifiInfoList) {
		super();
		this.wifiInfoList = wifiInfoList;
		this.wifiAdmin = new WifiAdmin(context,test);
		this.mInflater = LayoutInflater.from(context);
		this.context = context;
		this.ssidName = wifiAdmin.getSSID();
	}

	public WifiListAdapter(Context context,WifiAdmin wifiAdmin, List<WifiInfo> wifiInfoList){
		super();
		this.wifiInfoList = wifiInfoList;
		this.wifiAdmin = wifiAdmin;
		this.mInflater = LayoutInflater.from(context);
		this.context = context;
		this.ssidName = wifiAdmin.getSSID();
	}
	public WifiListAdapter(Context context, List<WifiInfo> wifiInfoList,String test) {
		super();
		this.wifiInfoList = wifiInfoList;
		this.wifiAdmin = new WifiAdmin(context,test);
		this.mInflater = LayoutInflater.from(context);
		this.context = context;
		this.ssidName = wifiAdmin.getSSID();
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return wifiInfoList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return wifiInfoList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view = null;
		ViewHolder viewHolder = null;
		if (convertView == null || convertView.getTag() == null) {
			view = mInflater.inflate(R.layout.wifi_item, null);
			viewHolder = new ViewHolder(view);
			view.setTag(viewHolder);
		} else {
			view = convertView;
			viewHolder = (ViewHolder) convertView.getTag();
		}
		WifiInfo wifiInfo = (WifiInfo) getItem(position);

		int db=wifiInfoList.get(position).getLeved();
		
		int level = getLevel(db);
		
		
		
		
		int resourceId = 0;
		if (level == 0) {
			resourceId = R.drawable.tui_ic_wifi_lock_signal_1;
		} else if (level == 1) {
			resourceId = R.drawable.tui_ic_wifi_lock_signal_2;
		} else if (level == 2) {
			resourceId = R.drawable.tui_ic_wifi_lock_signal_3;
		} else if (level == 3) {
			resourceId = R.drawable.tui_ic_wifi_lock_signal_4;
		} else if(level==4){
			resourceId=R.drawable.tui_ic_wifi_lock_signal_4;
		}else {
			resourceId = R.drawable.wifi_disable;
		}
		
		viewHolder.wifiImageView.setImageResource(resourceId);
		
		
//			viewHolder.wifiImageView.setImageDrawable(wifiInfo.getHotspotIcon());
			viewHolder.ssidNameView.setText(wifiInfo.getSsid());
		    
			
			viewHolder.wifiDb.setText("信号强度："+db);
			viewHolder.wifisecurity.setText("加密方式："+wifiInfo.getWifisecurity());
			
			viewHolder.ssidChanel.setText("信道："+wifiInfo.getWifiChanel());
			
			 /* if (position == selectItem) {  
				    viewHolder.wifiIconView.setVisibility(View.VISIBLE);
	            }   else {  
	            	viewHolder.wifiIconView.setVisibility(View.INVISIBLE);
	            }     */

		return view;

	}

	private int getLevel(int Rssi) {
		if (Rssi == Integer.MAX_VALUE) {
			return -1;
		}
		System.out.println(" --------"+WifiManager.calculateSignalLevel(Rssi, 4));
		return WifiManager.calculateSignalLevel(Rssi, 4);
	}
	
	class ViewHolder {
		ImageView wifiImageView;
		TextView ssidNameView;
		ImageView wifiIconView;
		
		TextView ssidChanel;
		TextView wifisecurity;
		TextView wifiDb;

		public ViewHolder(View view) {
			this.wifiImageView = (ImageView) view.findViewById(R.id.wifiIcon);// 热点图标
			this.ssidNameView = (TextView) view.findViewById(R.id.wifiSsidText);// 热点名称
			this.wifiIconView=(ImageView)view.findViewById(R.id.wifiIconSelect);//热点选中
			
			
			this.wifiDb=(TextView)view.findViewById(R.id.wifiSsidDb);//信號強度
			this.wifisecurity=(TextView)view.findViewById(R.id.wifiSsidSuc);//加密類型
			this.ssidChanel=(TextView)view.findViewById(R.id.wifiSsidChnel);//信道
			
			
	}

	
	public  void setSelectItem(int selectItem) {  
        this.selectItem = selectItem;  
   }  
   private int  selectItem=-1;  
}
}
