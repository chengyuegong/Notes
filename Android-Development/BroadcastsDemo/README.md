# Receiving broadcasts
This demo app shows two way to receive broadcasts: through manifest-declared receivers and context-registered receivers.
Reference Link: https://developer.android.com/guide/components/broadcasts
  
## Manifest-declared receivers
If app targets API level 26 or higher, you cannot use the manifest to declare a receiver for implicit broadcasts (broadcasts that do not target your app specifically), except for a few [implicit broadcasts](https://developer.android.com/guide/components/broadcast-exceptions.html).
  
### Steps  
1. Specify the `<receiver>` element in **AndroidManifest.xml**
```xml  
<receiver  
	android:name=".MyBroadcastReceiver"
	android:exported="true">
	<intent-filter>
		<action  android:name="android.intent.action.BOOT_COMPLETED"/>
		<action  android:name="android.intent.action.INPUT_METHOD_CHANGED" />
	</intent-filter>  
</receiver>
```  
  
2. Add a class extending `BroadcastReceiver`
```java  
public class MyBroadcastReceiver extends BroadcastReceiver {
	private static final String TAG = "MyBroadcastReceiver";
	@Override
	public void onReceive(Context context, Intent intent) {
		StringBuilder sb = new StringBuilder();
		sb.append("Action: " + intent.getAction() + "\n");
		sb.append("URI: " + intent.toUri(Intent.URI_INTENT_SCHEME) + "\n");
		String log = sb.toString(); 
		Log.d(TAG, log); 
		Toast.makeText(context, log, Toast.LENGTH_LONG).show(); 
	}
}
```  

## Context-registered receivers

### Steps  
1. Create an instance of `BroadcastReceiver`
```java
BroadcastReceiver br = new MyBroadcastReceiver();
```  
  
2. Create an `IntentFilter` and register the receiver by calling `registerReceiver(BroadcastReceiver, IntentFilter)`
```java  
IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION); 
filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
this.registerReceiver(br, filter);
```  

3. To stop receiving broadcasts, call `unregisterReceiver(android.content.BroadcastReceiver)`
```java
this.unregisterReceiver(br);
```

4. Register in `onCreate(Bundle)` --> Unregister in `onDestroy()`
	Register in `onResume()` --> Unregister in `onPause()`

## goAsync()

Flag that it needs more time to finish after `onReceive()` is complete. This is especially useful if the work you want to complete in your `onReceive()` is long enough, making it better suited for a background thread.

```java
public class MyBroadcastReceiver extends BroadcastReceiver {
	private  static  final  String TAG =  "MyBroadcastReceiver";
	@Override public void onReceive(Context context, Intent intent) {
		final PendingResult pendingResult = goAsync();
		Task asyncTask = new Task(pendingResult, intent);
		asyncTask.execute();
	}
	private static class Task extends AsyncTask<String, Integer, String> {
		private final PendingResult pendingResult;
		private final Intent intent;
		private Task(PendingResult pendingResult, Intent intent) {
			this.pendingResult = pendingResult;
			this.intent = intent;
		}  
		@Override
		protected String doInBackground(String... strings) {
			StringBuilder sb = new StringBuilder();
			sb.append("Action: " + intent.getAction() + "\n");
			sb.append("URI: " + intent.toUri(Intent.URI_INTENT_SCHEME) + "\n");
			String log = sb.toString();
			Log.d(TAG, log);
			return log;
		}
		@Override  
		protected void onPostExecute(String s) {
			super.onPostExecute(s);
			// Must call finish() so the BroadcastReceiver can be recycled.
			pendingResult.finish();
		}
	}  
}
```

## Sending broadcasts
Three ways for apps to send broadcast:
1. sendOrderedBroadcast(Intent, String): sends broadcasts to one receiver at a time.
2. sendBroadcast(Intent): sends broadcasts to all receivers in an undefined order.
3. LocalBroadcastManager.sendBroadcast: sends broadcasts to receivers that are in the same app as the sender.
```java
Intent intent = new Intent();  
intent.setAction("com.example.broadcast.MY_NOTIFICATION");  
intent.putExtra("data","Notice me senpai!");  
sendBroadcast(intent);
```

## Permissions

### Sending with permissions
Send a broadcast
```java
sendBroadcast(new Intent("com.example.NOTIFY"), Manifest.permission.SEND_SMS);
```
To receive the broadcast, the receiving app must request the permission
```xml
<uses-permission android:name="android.permission.SEND_SMS"/>
```

### Receiving with permissions
Receiving app has a manifest-declared receiver
```xml
<receiver
	android:name=".MyBroadcastReceiver"
	android:permission="android.permission.SEND_SMS">
	<intent-filter>
		<action android:name="android.intent.action.AIRPLANE_MODE"/>
	</intent-filter>
</receiver>
```
or a context-registered receiver
```java
IntentFilter filter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
registerReceiver(receiver, filter, Manifest.permission.SEND_SMS, null);
```
To send broadcasts, the sending app must request the permission
```xml
<uses-permission android:name="android.permission.SEND_SMS"/>
```