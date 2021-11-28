package com.apps24.myapplication2;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.adapter.GalleryAdapter;

public class GalleryActivity extends AppCompatActivity {

    private static final String TAG="MainGalleryActivity";
    private static final int PERMISSION_REQUEST_CODE = 200;
    private List<String> imagePaths;
    private RecyclerView imagesRV;
    private GalleryAdapter imageRVAdapter;
    private ArrayList<File> mfiles;
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");

        imagesRV=findViewById(R.id.recview_image);
//        textView=findViewById(R.id.default_text);
        imagePaths=new ArrayList<>();

        if(ContextCompat.checkSelfPermission(getBaseContext(), "android.permission.READ_EXTERNAL_STORAGE") == PackageManager.PERMISSION_GRANTED)  {

            // Todo : If Permission Granted Then Show SMS

        } else {
            // Todo : Then Set Permission
            final int REQUEST_CODE_ASK_PERMISSIONS = 123;
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, REQUEST_CODE_ASK_PERMISSIONS);
        }


//        display();
         getImages();

        //Uri uri=MediaStore.Images.Media.EXTERNAL_CONTENT_URI;


    }

   /* private void prepareRecyclerView() {

        // in this method we are preparing our recycler view.
        // on below line we are initializing our com.adapter class.
        imageRVAdapter = new GalleryAdapter(GalleryActivity.this, imagePaths);

        // on below line we are creating a new grid layout manager.
        GridLayoutManager manager = new GridLayoutManager(GalleryActivity.this, 4);

        // on below line we are setting layout
        // manager and com.adapter to our recycler view.
        imagesRV.setLayoutManager(manager);
        imagesRV.setAdapter(imageRVAdapter);
        getImagePath();
    }*/

   /* private void getImagePath() {
        // in this method we are adding all our image paths
        // in our arraylist which we have created.
        // on below line we are checking if the device is having an sd card or not.
        boolean isSDPresent = android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);

        if (isSDPresent) {

            // if the sd card is present we are creating a new list in
            // which we are getting our images data with their ids.
            final String[] columns = {MediaStore.Images.Media.DATA, MediaStore.Images.Media._ID};

            // on below line we are creating a new
            // string to order our images by string.
            final String orderBy = MediaStore.Images.Media._ID;

            // this method will stores all the images
            // from the gallery in Cursor
            Cursor cursor = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, columns, null, null, orderBy);

            // below line is to get total number of images
            int count = cursor.getCount();

            // on below line we are running a loop to add
            // the image file path in our array list.
            for (int i = 0; i < count; i++) {

                // on below line we are moving our cursor position
                cursor.moveToPosition(i);

                // on below line we are getting image file path
                int dataColumnIndex = cursor.getColumnIndex(MediaStore.Images.Media.DATA);

                // after that we are getting the image file path
                // and adding that path in our array list.
                imagePaths.add(cursor.getString(dataColumnIndex));
                Log.d(TAG, "getImagePath: "+imagePaths.add(cursor.getString(dataColumnIndex)));
            }
            imageRVAdapter.notifyDataSetChanged();
            // after adding the data to our
            // array list we are closing our cursor.
            cursor.close();
        }
    }*/

   /* private ArrayList<File> findImages(File file) {

        ArrayList<File> arrayList=new ArrayList<>();

        File[] imageFile=file.listFiles();

        if(imageFile!=null) {
            for (File singleImage : imageFile) {
                if (singleImage.isDirectory() && !singleImage.isHidden()) {
                    arrayList.addAll(findImages(singleImage));
                } else {
                    if (singleImage.getName().endsWith(".jpg") *//*||
                            singleImage.getName().endsWith(".png") ||
                            singleImage.getName().endsWith(".webp")*//*) {
                        arrayList.add(singleImage);
                    }
                }
            }
        }
        else{
//            textView.setVisibility(View.GONE);
//            textView.setText("No Image");
        }

        return arrayList;
    }

    public void display(){
        mfiles=findImages(Environment.getExternalStorageDirectory());

        for (int i=0;i<mfiles.size();i++){
            imagePaths.add(String.valueOf(mfiles.get(i)));

            imageRVAdapter=new GalleryAdapter(imagePaths);
            imagesRV.setAdapter(imageRVAdapter);
            imagesRV.setLayoutManager(new GridLayoutManager(this,3));

        }
    }
*/
    ///////

    @SuppressLint("Range")
    public void getImages(){
        ContentResolver contentResolver=getContentResolver();
        Uri uri= MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        if (uri!=null){
            Cursor cursor=contentResolver.query(uri,null,null,null,null);
            Log.d(TAG, "getImages: "+cursor.getCount());
            if(cursor!=null){
                if(cursor.getCount()>0){
                    while (cursor.moveToNext()){
                        @SuppressLint("Range") String images=cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                        String imageName=cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME));
                        Bitmap bitmapFactory= BitmapFactory.decodeFile(cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME)));
                        imagePaths.add(images);
                        imageRVAdapter=new GalleryAdapter(imagePaths);
                        imagesRV.setAdapter(imageRVAdapter);
                        imagesRV.setLayoutManager(new GridLayoutManager(this,3));
                        Log.d(TAG, "Images: "+imagePaths);
                    }
                }
            }
        }

    }
}
