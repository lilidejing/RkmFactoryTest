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
	
	private static int pressTimes=0;//��������
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
			
			Log.d(TAG, "adb����KEYCODE_DPAD_LEFT  ");
			break;

		case KeyEvent.KEYCODE_DPAD_RIGHT:
			pressTimes++;
			downHandler.sendEmptyMessage(KeyEvent.KEYCODE_DPAD_RIGHT);
			
			Log.d(TAG, "adb����KEYCODE_DPAD_RIGHT  " );
			break;
		case KeyEvent.KEYCODE_DPAD_UP:
			pressTimes++;
			downHandler.sendEmptyMessage(KeyEvent.KEYCODE_DPAD_UP);
			
			Log.d(TAG, "adb����KEYCODE_DPAD_UP  ");
			break;
		case KeyEvent.KEYCODE_DPAD_DOWN:
			pressTimes++;
			downHandler.sendEmptyMessage(KeyEvent.KEYCODE_DPAD_DOWN);
			
			Log.d(TAG, "adb����KEYCODE_DPAD_DOWN  " );
			break;
		case KeyEvent.KEYCODE_MENU:
			pressTimes++;
			downHandler.sendEmptyMessage(KeyEvent.KEYCODE_MENU);
			
			Log.d(TAG, "adb����  KEYCODE_MENU" );
			break;

		case KeyEvent.KEYCODE_BACK:
			pressTimes++;
			downHandler.sendEmptyMessage(KeyEvent.KEYCODE_BACK);
			
			Log.d(TAG, "adb����  KEYCODE_BACK" );
			break;
         case KeyEvent.KEYCODE_DPAD_CENTER:
			
        	 pressTimes++;
        	 downHandler.sendEmptyMessage(KeyEvent.KEYCODE_DPAD_CENTER);
			Log.d(TAG, "adb����  KEYCODE_BACK" );
			break;
			
			
         
		default:
			
			
			Log.d(TAG, "adb����  default" );
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
			
			Log.d(TAG, "adb����KEYCODE_DPAD_LEFT  ");
			break;

		case KeyEvent.KEYCODE_DPAD_RIGHT:
			
			upHandler.sendEmptyMessage(KeyEvent.KEYCODE_DPAD_RIGHT);
			
			Log.d(TAG, "adb����KEYCODE_DPAD_RIGHT  " );
			break;
		case KeyEvent.KEYCODE_DPAD_UP:
			
			upHandler.sendEmptyMessage(KeyEvent.KEYCODE_DPAD_UP);
			
			Log.d(TAG, "adb����KEYCODE_DPAD_UP  ");
			break;
		case KeyEvent.KEYCODE_DPAD_DOWN:
			
			upHandler.sendEmptyMessage(KeyEvent.KEYCODE_DPAD_DOWN);
			
			Log.d(TAG, "adb����KEYCODE_DPAD_DOWN  " );
			break;
		case KeyEvent.KEYCODE_MENU:
			
			upHandler.sendEmptyMessage(KeyEvent.KEYCODE_MENU);
			
			Log.d(TAG, "adb����  KEYCODE_MENU" );
			break;

		case KeyEvent.KEYCODE_BACK:
			
			upHandler.sendEmptyMessage(KeyEvent.KEYCODE_BACK);
			
			Log.d(TAG, "adb����  KEYCODE_BACK" );
			break;
         case KeyEvent.KEYCODE_DPAD_CENTER:
			
        	 
        	 upHandler.sendEmptyMessage(KeyEvent.KEYCODE_DPAD_CENTER);
			Log.d(TAG, "adb����  KEYCODE_BACK" );
			break;
			
		default:
			
			
			Log.d(TAG, "adb����  default" );
			break;

		}

		return super.onKeyUp(keyCode, event);
	}
	
	
	
	Handler downHandler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			
			switch(msg.what){
			case KeyEvent.KEYCODE_DPAD_LEFT:
				
				pressKeyText.setText("����ֵ��"+KeyEvent.KEYCODE_DPAD_LEFT+" (���)");
				
				pressStatusText.setText("����״̬������");
				
				pressTimesText.setText("����������"+pressTimes);
				Log.d(TAG, "adb����KEYCODE_DPAD_LEFT  ");
				break;

			case KeyEvent.KEYCODE_DPAD_RIGHT:
				pressKeyText.setText("����ֵ��"+KeyEvent.KEYCODE_DPAD_RIGHT+" (�Ҽ�)");
				
				pressStatusText.setText("����״̬������");
				
				pressTimesText.setText("����������"+pressTimes);
				Log.d(TAG, "adb����KEYCODE_DPAD_RIGHT  " );
				break;
			case KeyEvent.KEYCODE_DPAD_UP:
				
				pressKeyText.setText("����ֵ��"+KeyEvent.KEYCODE_DPAD_UP+" (�ϼ�)");
				
				pressStatusText.setText("����״̬������");
				
				pressTimesText.setText("����������"+pressTimes);
				Log.d(TAG, "adb����KEYCODE_DPAD_UP  ");
				break;
			case KeyEvent.KEYCODE_DPAD_DOWN:
				
				pressKeyText.setText("����ֵ��"+KeyEvent.KEYCODE_DPAD_DOWN+" (�¼�)");
				
				pressStatusText.setText("����״̬������");
				
				pressTimesText.setText("����������"+pressTimes);
				Log.d(TAG, "adb����KEYCODE_DPAD_DOWN  " );
				break;
			case KeyEvent.KEYCODE_MENU:
				
				pressKeyText.setText("����ֵ��"+KeyEvent.KEYCODE_MENU+" (MENU��)");
				
				pressStatusText.setText("����״̬������");
				
				pressTimesText.setText("����������"+pressTimes);
				Log.d(TAG, "adb����  KEYCODE_MENU" );
				break;

			case KeyEvent.KEYCODE_BACK:
				
				pressKeyText.setText("����ֵ��"+KeyEvent.KEYCODE_BACK+" (BACK��)");
				
				pressStatusText.setText("����״̬������");
				
				pressTimesText.setText("����������"+pressTimes);
				Log.d(TAG, "adb����  KEYCODE_BACK" );
				break;
	         case KeyEvent.KEYCODE_DPAD_CENTER:
				
	        	pressKeyText.setText("����ֵ��"+KeyEvent.KEYCODE_DPAD_CENTER+" (OK��)");
	        	
	        	pressStatusText.setText("����״̬������");
	        	
	        	pressTimesText.setText("����������"+pressTimes);
				Log.d(TAG, "adb����  KEYCODE_BACK" );
				break;
				
			default:
				
				
				Log.d(TAG, "adb����  default" );
				break;

			}
				
			
			}
			
		};

		
		
		
		Handler upHandler=new Handler(){
			public void handleMessage(android.os.Message msg) {
				
				switch(msg.what){
				case KeyEvent.KEYCODE_DPAD_LEFT:
					
					pressStatusText.setText("����״̬������");
					
				
					Log.d(TAG, "adb����KEYCODE_DPAD_LEFT  ");
					break;

				case KeyEvent.KEYCODE_DPAD_RIGHT:
					pressStatusText.setText("����״̬������");
					
					Log.d(TAG, "adb����KEYCODE_DPAD_RIGHT  " );
					break;
				case KeyEvent.KEYCODE_DPAD_UP:
					
					pressStatusText.setText("����״̬������");
					
					Log.d(TAG, "adb����KEYCODE_DPAD_UP  ");
					break;
				case KeyEvent.KEYCODE_DPAD_DOWN:
					
					pressStatusText.setText("����״̬������");
					
					Log.d(TAG, "adb����KEYCODE_DPAD_DOWN  " );
					break;
				case KeyEvent.KEYCODE_MENU:
					
					pressStatusText.setText("����״̬������");
					
					Log.d(TAG, "adb����  KEYCODE_MENU" );
					break;

				case KeyEvent.KEYCODE_BACK:
					
					pressStatusText.setText("����״̬������");
				
					Log.d(TAG, "adb����  KEYCODE_BACK" );
					break;
		         case KeyEvent.KEYCODE_DPAD_CENTER:
					
		        	 pressStatusText.setText("����״̬������");
		        	
					Log.d(TAG, "adb����  KEYCODE_BACK" );
					break;
					
				default:
					
					
					Log.d(TAG, "adb����  default" );
					break;

				   }
				}
				
			};
		
}
