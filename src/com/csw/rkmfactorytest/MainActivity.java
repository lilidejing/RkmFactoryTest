package com.csw.rkmfactorytest;




import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemProperties;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

	
	private TextView kosText,hwText,snText;
	/**
	 * ��ֵ��ʾ
	 */
	private TextView tlkgVersionText,macText;
	
	
	private static String TAG="MainActivity";
	
	private Button wifiBtn,pressKeyBtn;
	
	private Context mContext;
	
	/**
	 * ����K��APP�İ���
	 */
	private static final String tlkgappPackageName="com.audiocn.kalaok.tv";
	/**
	 * ������UI�İ���
	 */
	private static final String uiappPackageName="com.csw.tianlai_ui";
	
	private MediaPlayer mediaPlayer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mContext=this;
		
		play_music();
		initView();

	}

	
	
	private void play_music() {
		// TODO Auto-generated method stub
		mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.null_10ms);
		mediaPlayer.start();
		Log.e("mediaplayer", "��ʼ����");
	}

	
	
	
	/**
	 * ��ʼ���ؼ�
	 */
	private void initView(){
		kosText=(TextView)this.findViewById(R.id.kosVersion);
	    hwText=(TextView)this.findViewById(R.id.hwVersion);
	    snText=(TextView)this.findViewById(R.id.snText);
	    
	    tlkgVersionText=(TextView)this.findViewById(R.id.tlkgVersionText);
	    macText=(TextView)this.findViewById(R.id.pressKeyCheck);
	  
	    wifiBtn=(Button)this.findViewById(R.id.testWifiBtn);
	    wifiBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent=new Intent();
				mIntent.setClass(MainActivity.this, WifiListActivity.class);
				startActivity(mIntent);
			}
		});
	    pressKeyBtn=(Button)this.findViewById(R.id.testPressKeyBtn);
	    
	    pressKeyBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent=new Intent();
				mIntent.setClass(MainActivity.this, KeyActivity.class);
				startActivity(mIntent);
			}
		});
       
		mHandler.sendEmptyMessage(0);
	    
	}
	
	Handler mHandler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch(msg.what){
			case 0:
				
				 String systemVersion=getKosSystemVersion() ;
					int _qudaoIndex=systemVersion.lastIndexOf("_");
					String kosVersion=systemVersion.substring(0, _qudaoIndex);

					String sn=getProductSN();
					String hwVersion=getProductHardware();
//					
//					
					String currentTlkgappVersion=com.csw.communication.GetVersionUtil.getVersion(mContext, tlkgappPackageName);//����K��ĵ�ǰ�汾��
//					
//					
					kosText.setText("�̼��汾�ţ�"+kosVersion);
					hwText.setText("Ӳ���汾�ţ�"+hwVersion);
					tlkgVersionText.setText("����K��汾�ţ�"+currentTlkgappVersion);
					snText.setText("�豸ID��:"+sn);
					
					boolean weatherConnect=isWifiConnected(mContext);
					if(weatherConnect==false){
						macText.setText("��ǰ����δ����");
					}else{
						WifiManager wifiManager = (WifiManager) MainActivity.this.getSystemService(Context.WIFI_SERVICE);   
						android.net.wifi.WifiInfo info = wifiManager.getConnectionInfo();     
			          
			            
			            
			            String mac=info.getMacAddress();
			            
			            macText.setText("MAC��ַ��"+mac);
					}
					
					
					
				
				break;
				
			case 1:
				new Thread(OpenMicRunnable).start();
				break;
				
			

			case 2:
				new Thread(CloseMicRunnable).start();
				break;	
				
				default:
					break;
			
			
			
			}
			
			
		};
	};
	
	/*
	 * ��鵱ǰWIFI�Ƿ����ӣ�������˼�����Ƿ����ӣ������ǲ���WIFI
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
	
	
	 public static String getKosSystemVersion() {
	    	String version = SystemProperties.get("ro.fw.version");
	    	if(version == null || version.length() == 0) {
	    		version = "1.0.0";
	    	}
	    	
	    	return version;
	    }
	    
	    public static String getProductSN() {
//	    	String sn = SystemProperties.get("ro.serialno");
	    	String sn = SystemProperties.get("ro.boot.serialno");
	    	if(sn == null || sn.length() == 0) {
	    		sn = "unknown";
	    	}
	    	
	    	return sn;
	    }
	    
	    /**
	     * Ӳ���汾��
	     * @return
	     */
	    public static String getProductHardware(){
	    	String hw = SystemProperties.get("ro.hw.version");
	    	if(hw == null || hw.length() == 0) {
	    		hw = "unknown";
	    	}
	    	
	    	return hw;
	    }

	    Runnable OpenMicRunnable=new Runnable(){
			@Override
			public void run() {
				Mic.mic_open();			
			}
		};
		
		Runnable CloseMicRunnable=new Runnable(){
			@Override
			public void run() {
				Mic.mic_close();			
			}
		};
		
	    @Override
		protected void onStop() {
	    	// TODO Auto-generated method stub
	        super.onStop();
			mHandler.sendEmptyMessage(2);//�ر���˷�
		};
		
		
		
		@Override
		protected void onStart() {
			// TODO Auto-generated method stub
			super.onStart();
			mHandler.sendEmptyMessage(1);//����˷�
		}
}
