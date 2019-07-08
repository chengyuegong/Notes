
# Start another activity
This demo app shows how to start another activity via either an explicit intent or an implicit intents.

## Explicit Intent
Reference Link: https://developer.android.com/training/basics/firstapp/starting-activity

### Steps
1. Add a EditText and a Button to the **activity_main.xml**
```xml
<Button  
  android:id="@+id/button_send_message"  
  android:layout_width="wrap_content"  
  android:layout_height="wrap_content"  
  android:layout_marginTop="8dp"  
  android:layout_marginEnd="16dp"  
  android:onClick="sendMessage"  
  android:text="Send Message"  
  app:layout_constraintEnd_toEndOf="parent"  
  app:layout_constraintTop_toTopOf="parent" />  
  
<EditText  
  android:id="@+id/editText"  
  android:layout_width="0dp"  
  android:layout_height="wrap_content"  
  android:layout_marginStart="16dp"  
  android:layout_marginTop="8dp"  
  android:layout_marginEnd="16dp"  
  android:inputType="text"  
  android:hint="Enter your message"  
  app:layout_constraintEnd_toStartOf="@+id/button_send_message"  
  app:layout_constraintStart_toStartOf="parent"  
  app:layout_constraintTop_toTopOf="parent" />
```

2. Add a sendMessage method to the **MainActivity** class which will be called by the button
```java
public class MainActivity extends AppCompatActivity {
	public static final String EXTRA_MESSAGE = "com.example.activitydemo.MESSAGE";
	@Override  
	protected void onCreate(Bundle savedInstanceState) {  
	    super.onCreate(savedInstanceState);  
		setContentView(R.layout.activity_main);  
	}
	public void sendMessage(View view) {  
		Intent intent = new Intent(this, MyActivity.class);  
		EditText editText = findViewById(R.id.editText);  
		String message = editText.getText().toString();  
		intent.putExtra(EXTRA_MESSAGE, message);  
		startActivity(intent);  
	}
}
```

3. Create a layout resource file **activity_display_message.xml** and add a TextView to display the message
```xml
<?xml version="1.0" encoding="utf-8"?>  
<android.support.constraint.ConstraintLayout  
  xmlns:android="http://schemas.android.com/apk/res/android"  
  xmlns:app="http://schemas.android.com/apk/res-auto"  
  xmlns:tools="http://schemas.android.com/tools"  
  android:layout_width="match_parent"  
  android:layout_height="match_parent">  
  
 <TextView  android:id="@+id/tv_display_message"  
  android:layout_width="wrap_content"  
  android:layout_height="wrap_content"  
  android:textSize="36sp"  
  app:layout_constraintBottom_toBottomOf="parent"  
  app:layout_constraintEnd_toEndOf="parent"  
  app:layout_constraintStart_toStartOf="parent"  
  app:layout_constraintTop_toTopOf="parent"  
  tools:text="Display Message" />  
</android.support.constraint.ConstraintLayout>
```

4. Create a **DisplayMessageActivity** to display the message sent from **MainActivity**
```java
public class DisplayMessageActivity extends AppCompatActivity {  
	@Override  
	protected void onCreate(@Nullable Bundle savedInstanceState) {  
	    super.onCreate(savedInstanceState);  
	    setContentView(R.layout.activity_display_message);  
  
		String message = getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE);  
		TextView textViewDisplay = findViewById(R.id.tv_display_message);  
		textViewDisplay.setText(message);  
	}  
}
```

5. Add the required  ```<activity>``` and up navigation in **AndroidManifest.xml**
```xml
<activity  
  android:name=".DisplayMessageActivity"  
  android:parentActivityName=".MainActivity" />
```
