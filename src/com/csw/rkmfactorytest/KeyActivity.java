package com.csw.rkmfactorytest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;

public class KeyActivity extends Activity {

	private static String TAG="KeyActivity";
	
	private TextView pressKeyText,pressStatusText,pressTimesText;
	
	private static int pressTimes=0;//按键次数
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.keyactivity);
		pressKeyText=(TextView)this.findViewById(R.id.pressKeyText);
		pressStatusText=(TextView)this.findViewById(R.id.pressStatusText);
		pressTimesText=(TextView)this.findViewById(R.id.pressTimesText);
		pressTimes=0;
		
	}
	
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub

		switch (keyCode) {
		case KeyEvent.KEYCODE_DPAD_LEFT:
			pressTimes++;
			downHandler.sendEmptyMessage(KeyEvent.KEYCODE_DPAD_LEFT);
			
			Log.d(TAG, "adb调试KEYCODE_DPAD_LEFT  ");
			break;

		case KeyEvent.KEYCODE_DPAD_RIGHT:
			pressTimes++;
			downHandler.sendEmptyMessage(KeyEvent.KEYCODE_DPAD_RIGHT);
			
			Log.d(TAG, "adb调试KEYCODE_DPAD_RIGHT  " );
			break;
		case KeyEvent.KEYCODE_DPAD_UP:
			pressTimes++;
			downHandler.sendEmptyMessage(KeyEvent.KEYCODE_DPAD_UP);
			
			Log.d(TAG, "adb调试KEYCODE_DPAD_UP  ");
			break;
		case KeyEvent.KEYCODE_DPAD_DOWN:
			pressTimes++;
			downHandler.sendEmptyMessage(KeyEvent.KEYCODE_DPAD_DOWN);
			
			Log.d(TAG, "adb调试KEYCODE_DPAD_DOWN  " );
			break;
		case KeyEvent.KEYCODE_MENU:
			pressTimes++;
			downHandler.sendEmptyMessage(KeyEvent.KEYCODE_MENU);
			
			Log.d(TAG, "adb调试  KEYCODE_MENU" );
			break;

		case KeyEvent.KEYCODE_BACK:
			pressTimes++;
			downHandler.sendEmptyMessage(KeyEvent.KEYCODE_BACK);
			
			Log.d(TAG, "adb调试  KEYCODE_BACK" );
			break;
         case KeyEvent.KEYCODE_DPAD_CENTER:
			
        	 pressTimes++;
        	 downHandler.sendEmptyMessage(KeyEvent.KEYCODE_DPAD_CENTER);
			Log.d(TAG, "adb调试  KEYCODE_BACK" );
			break;
			
			
         
		default:
			
			
			Log.d(TAG, "adb调试  default" );
			break;

		}

		return super.onKeyDown(keyCode, event);
	}
	
	
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub

		switch (keyCode) {
		case KeyEvent.KEYCODE_DPAD_LEFT:
			
			upHandler.sendEmptyMessage(KeyEvent.KEYCODE_DPAD_LEFT);
			
			Log.d(TAG, "adb调试KEYCODE_DPAD_LEFT  ");
			break;

		case KeyEvent.KEYCODE_DPAD_RIGHT:
			
			upHandler.sendEmptyMessage(KeyEvent.KEYCODE_DPAD_RIGHT);
			
			Log.d(TAG, "adb调试KEYCODE_DPAD_RIGHT  " );
			break;
		case KeyEvent.KEYCODE_DPAD_UP:
			
			upHandler.sendEmptyMessage(KeyEvent.KEYCODE_DPAD_UP);
			
			Log.d(TAG, "adb调试KEYCODE_DPAD_UP  ");
			break;
		case KeyEvent.KEYCODE_DPAD_DOWN:
			
			upHandler.sendEmptyMessage(KeyEvent.KEYCODE_DPAD_DOWN);
			
			Log.d(TAG, "adb调试KEYCODE_DPAD_DOWN  " );
			break;
		case KeyEvent.KEYCODE_MENU:
			
			upHandler.sendEmptyMessage(KeyEvent.KEYCODE_MENU);
			
			Log.d(TAG, "adb调试  KEYCODE_MENU" );
			break;

		case KeyEvent.KEYCODE_BACK:
			
			upHandler.sendEmptyMessage(KeyEvent.KEYCODE_BACK);
			
			Log.d(TAG, "adb调试  KEYCODE_BACK" );
			break;
         case KeyEvent.KEYCODE_DPAD_CENTER:
			
        	 
        	 upHandler.sendEmptyMessage(KeyEvent.KEYCODE_DPAD_CENTER);
			Log.d(TAG, "adb调试  KEYCODE_BACK" );
			break;
			
		default:
			
			
			Log.d(TAG, "adb调试  default" );
			break;

		}

		return super.onKeyUp(keyCode, event);
	}
	
	
	
	Handler downHandler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			
			switch(msg.what){
			case KeyEvent.KEYCODE_DPAD_LEFT:
				
				pressKeyText.setText("按键值："+KeyEvent.KEYCODE_DPAD_LEFT+" (左键)");
				
				pressStatusText.setText("按键状态：按下");
				
				pressTimesText.setText("按键次数："+pressTimes);
				Log.d(TAG, "adb调试KEYCODE_DPAD_LEFT  ");
				break;

			case KeyEvent.KEYCODE_DPAD_RIGHT:
				pressKeyText.setText("按键值："+KeyEvent.KEYCODE_DPAD_RIGHT+" (右键)");
				
				pressStatusText.setText("按键状态：按下");
				
				pressTimesText.setText("按键次数："+pressTimes);
				Log.d(TAG, "adb调试KEYCODE_DPAD_RIGHT  " );
				break;
			case KeyEvent.KEYCODE_DPAD_UP:
				
				pressKeyText.setText("按键值："+KeyEvent.KEYCODE_DPAD_UP+" (上键)");
				
				pressStatusText.setText("按键状态：按下");
				
				pressTimesText.setText("按键次数："+pressTimes);
				Log.d(TAG, "adb调试KEYCODE_DPAD_UP  ");
				break;
			case KeyEvent.KEYCODE_DPAD_DOWN:
				
				pressKeyText.setText("按键值："+KeyEvent.KEYCODE_DPAD_DOWN+" (下键)");
				
				pressStatusText.setText("按键状态：按下");
				
				pressTimesText.setText("按键次数："+pressTimes);
				Log.d(TAG, "adb调试KEYCODE_DPAD_DOWN  " );
				break;
			case KeyEvent.KEYCODE_MENU:
				
				pressKeyText.setText("按键值："+KeyEvent.KEYCODE_MENU+" (MENU键)");
				
				pressStatusText.setText("按键状态：按下");
				
				pressTimesText.setText("按键次数："+pressTimes);
				Log.d(TAG, "adb调试  KEYCODE_MENU" );
				break;

			case KeyEvent.KEYCODE_BACK:
				
				pressKeyText.setText("按键值："+KeyEvent.KEYCODE_BACK+" (BACK键)");
				
				pressStatusText.setText("按键状态：按下");
				
				pressTimesText.setText("按键次数："+pressTimes);
				Log.d(TAG, "adb调试  KEYCODE_BACK" );
				break;
	         case KeyEvent.KEYCODE_DPAD_CENTER:
				
	        	pressKeyText.setText("按键值："+KeyEvent.KEYCODE_DPAD_CENTER+" (OK键)");
	        	
	        	pressStatusText.setText("按键状态：按下");
	        	
	        	pressTimesText.setText("按键次数："+pressTimes);
				Log.d(TAG, "adb调试  KEYCODE_BACK" );
				break;
				
			default:
				
				
				Log.d(TAG, "adb调试  default" );
				break;

			}
				
			
			}
			
		};

		
		
		
		Handler upHandler=new Handler(){
			public void handleMessage(android.os.Message msg) {
				
				switch(msg.what){
				case KeyEvent.KEYCODE_DPAD_LEFT:
					
					pressStatusText.setText("按键状态：弹起");
					
				
					Log.d(TAG, "adb调试KEYCODE_DPAD_LEFT  ");
					break;

				case KeyEvent.KEYCODE_DPAD_RIGHT:
					pressStatusText.setText("按键状态：弹起");
					
					Log.d(TAG, "adb调试KEYCODE_DPAD_RIGHT  " );
					break;
				case KeyEvent.KEYCODE_DPAD_UP:
					
					pressStatusText.setText("按键状态：弹起");
					
					Log.d(TAG, "adb调试KEYCODE_DPAD_UP  ");
					break;
				case KeyEvent.KEYCODE_DPAD_DOWN:
					
					pressStatusText.setText("按键状态：弹起");
					
					Log.d(TAG, "adb调试KEYCODE_DPAD_DOWN  " );
					break;
				case KeyEvent.KEYCODE_MENU:
					
					pressStatusText.setText("按键状态：弹起");
					
					Log.d(TAG, "adb调试  KEYCODE_MENU" );
					break;

				case KeyEvent.KEYCODE_BACK:
					
					pressStatusText.setText("按键状态：弹起");
				
					Log.d(TAG, "adb调试  KEYCODE_BACK" );
					break;
		         case KeyEvent.KEYCODE_DPAD_CENTER:
					
		        	 pressStatusText.setText("按键状态：弹起");
		        	
					Log.d(TAG, "adb调试  KEYCODE_BACK" );
					break;
					
				default:
					
					
					Log.d(TAG, "adb调试  default" );
					break;

				   }
				}
				
			};
		
}
