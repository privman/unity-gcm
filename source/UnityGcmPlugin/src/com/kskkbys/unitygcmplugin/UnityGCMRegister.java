package com.kskkbys.unitygcmplugin;

import com.google.android.gcm.GCMRegistrar;
import com.unity3d.player.UnityPlayer;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.content.SharedPreferences;

/**
 * Plugin class of GCMRegister
 * @author Keisuke Kobayashi
 *
 */
public class UnityGCMRegister {

	public static String[] senderIdArray;
	
	private static final String TAG = UnityGCMRegister.class.getSimpleName();

	public static void register(final String senderIds) {
		if (TextUtils.isEmpty(senderIds)) {
			return;
		}
		Activity activity = UnityPlayer.currentActivity;
		GCMRegistrar.checkDevice(activity);
		GCMRegistrar.checkManifest(activity);
		UnityGCMRegister.senderIdArray = senderIds.split(",");
		GCMRegistrar.register(activity, UnityGCMRegister.senderIdArray);
	}
	
	public static void unregister() {
		Activity activity = UnityPlayer.currentActivity;
		GCMRegistrar.checkDevice(activity);
		GCMRegistrar.checkManifest(activity);
		GCMRegistrar.unregister(activity);
	}
	
	public static boolean isRegistered() {
		Activity activity = UnityPlayer.currentActivity;
		GCMRegistrar.checkDevice(activity);
		GCMRegistrar.checkManifest(activity);
		return GCMRegistrar.isRegistered(activity);
	}
	
	public static String getRegistrationId() {
		Activity activity = UnityPlayer.currentActivity;
		GCMRegistrar.checkDevice(activity);
		GCMRegistrar.checkManifest(activity);
		return GCMRegistrar.getRegistrationId(activity);
	}
	
	public static void setRegisteredOnServer(final boolean isRegistered) {
		Activity activity = UnityPlayer.currentActivity;
		GCMRegistrar.checkDevice(activity);
		GCMRegistrar.checkManifest(activity);
		GCMRegistrar.setRegisteredOnServer(activity, isRegistered);
	}
	
	public static boolean isRegisteredOnServer() {
		Activity activity = UnityPlayer.currentActivity;
		GCMRegistrar.checkDevice(activity);
		GCMRegistrar.checkManifest(activity);
		return GCMRegistrar.isRegisteredOnServer(activity);
	}
	
	public static void setRegisterOnServerLifespan(long lifespan) {
		Activity activity = UnityPlayer.currentActivity;
		GCMRegistrar.checkDevice(activity);
		GCMRegistrar.checkManifest(activity);
		GCMRegistrar.setRegisterOnServerLifespan(activity, lifespan);
	}
	
	public static long getRegisterOnServerLifespan() {
		Activity activity = UnityPlayer.currentActivity;
		GCMRegistrar.checkDevice(activity);
		GCMRegistrar.checkManifest(activity);
		return GCMRegistrar.getRegisterOnServerLifespan(activity);
	}
	
	public static void setNotificationsEnabled(boolean enabled) {
		Log.v(TAG, "setNotificationsEnabled: " + enabled);
		Util.notificationsEnabled = enabled;
	}
	
	public static void setNotificationsSound(boolean enabled) {
		Log.v(TAG, "setNotificationsSound: " + enabled);
		Activity activity = UnityPlayer.currentActivity;
		SharedPreferences settings = activity.getSharedPreferences("Notifications", 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putBoolean("soundEnabled", enabled);
		editor.apply();
	}

}
