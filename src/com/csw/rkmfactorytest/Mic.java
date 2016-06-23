package com.csw.rkmfactorytest;

public class Mic {
	private final static String TAG = "MIC";

	static {
		
		try {
			System.loadLibrary("mic");
		} catch (UnsatisfiedLinkError ule) {
			System.err.println("WARNING: Could not load library!");
		}
	} 

	public static native void mic_open();
   	public static native void mic_close();

}
