# Camera  
This demo app shows how to use the device camera to take a photo and record a video.  
  
## Taking photos  
Reference Link: https://developer.android.com/training/camera/photobasics  
  
### Steps  
1. Request the camera feature in **AndroidManifest.xml**  
```xml  
<uses-feature 
	android:name="android.hardware.camera"
	android:required="true" />
```  
Calling `hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)`  to check for the availability of the camera at runtime.
  
2. Invoke an intent to capture a photo
```java  
static final int REQUEST_IMAGE_CAPTURE = 1;
private void dispatchTakePictureIntent()  {  
	Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);  
	if (takePictureIntent.resolveActivity(getPackageManager()) != null)  { 		
		startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);  
	}  
}
```  
  
3. Get the thumbnail
The Android Camera application encodes the photo in the return `Intent` delivered to `onActivityResult()` as a small `Bitmap` in the extras, under the key `data`.
```java
@Override  
protected void onActivityResult(int requestCode, int resultCode, Intent data) { 
	if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {  
		Bundle extras = data.getExtras();
		Bitmap imageBitmap = (Bitmap) extras.get("data"); 
		imageView.setImageBitmap(imageBitmap);  
	}  
}
```  
  
4. Save a full-size photo
* The proper directory for shared photos: `getExternalStoragePublicDirectory()`, with the `Environment.DIRECTORY_PICTURES` argument. (Requires `READ_EXTERNAL_STORAGE` and `WRITE_EXTERNAL_STORAGE` permissions)
* Directory for private use: `getExternalFilesDir()`. (Beginning with Android 4.4, no permission required)
* Configure `FileProvider`
* Content required at **res/xml/file_paths.xml** 
```xml
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
<provider  
	android:name="android.support.v4.content.FileProvider"
	android:authorities="com.example.android.fileprovider"
	android:exported="false"
	android:grantUriPermissions="true">  
	<meta-data
		android:name="android.support.FILE_PROVIDER_PATHS"
		android:resource="@xml/file_paths">
	</meta-data>  
</provider>
```

```xml
<?xml version="1.0" encoding="utf-8"?>  
<paths  xmlns:android="http://schemas.android.com/apk/res/android">  
	<external-path  
		name="my_images"
		path="Android/data/com.example.package.name/files/Pictures" />  
</paths>
```

```java  
String currentPhotoPath;  
private File createImageFile() throws IOException {  
	// Create an image file name  
	String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new  Date());  
	String imageFileName = "JPEG_" + timeStamp + "_";  
	File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);  
	File image = File.createTempFile(
		imageFileName, /* prefix */
		".jpg", /* suffix */
		storageDir /* directory */
	);  
	// Save a file: path for use with ACTION_VIEW intents 
	currentPhotoPath = image.getAbsolutePath();  
	return image;  
}

static final int REQUEST_TAKE_PHOTO = 1;
private  void dispatchTakePictureIntent() {  
	Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	// Ensure that there's a camera activity to handle the intent  
	if (takePictureIntent.resolveActivity(getPackageManager()) != null) {  
		// Create the File where the photo should go  
		File photoFile = null;
		try { 
			photoFile = createImageFile();
		} catch (IOException ex) {  
			// Error occurred while creating the File ...
		}  
		// Continue only if the File was successfully created
		if (photoFile != null) {
			Uri photoURI = FileProvider.getUriForFile(this, "com.example.android.fileprovider", photoFile);
			takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
			startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);  
		}  
	}  
}
```  
  
5. Add photo to the gallery
Media Provider: have no access to the private directory, only available if using `getExternalStoragePublicDirectory()`
```java 
private void galleryAddPic() {
	Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
	File f = new File(currentPhotoPath);
	Uri contentUri = Uri.fromFile(f);
	mediaScanIntent.setData(contentUri);
	this.sendBroadcast(mediaScanIntent);  
}
```

6. Decode a scaled image
```java
private void setPic() {
	// Get the dimensions of the View  
	int targetW = imageView.getWidth();
	int targetH = imageView.getHeight();
	// Get the dimensions of the bitmap
	BitmapFactory.Options bmOptions = new BitmapFactory.Options();
	bmOptions.inJustDecodeBounds = true;
	BitmapFactory.decodeFile(currentPhotoPath, bmOptions);
	int photoW = bmOptions.outWidth;
	int photoH = bmOptions.outHeight;
	// Determine how much to scale down the image
	int scaleFactor = Math.min(photoW/targetW, photoH/targetH);
	// Decode the image file into a Bitmap sized to fill the View
	bmOptions.inJustDecodeBounds = false;
	bmOptions.inSampleSize = scaleFactor;
	bmOptions.inPurgeable = true;
	Bitmap bitmap = BitmapFactory.decodeFile(currentPhotoPath, bmOptions);
	imageView.setImageBitmap(bitmap);  
}
```