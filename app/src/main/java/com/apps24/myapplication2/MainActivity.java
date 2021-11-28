
package com.apps24.myapplication2;

/*

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.adapter.GalleryAdapter;

public class MainActivity extends AppCompatActivity {

    ArrayList<File> myImageFile;
    GalleryAdapter galleryAdapter;
    List<String> myList;
    RecyclerView recview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recview = findViewById(R.id.recview_image);

//        CheckUserPermsions();

        myList = new ArrayList<>();


        if(ContextCompat.checkSelfPermission(getBaseContext(), "android.permission.READ_EXTERNAL_STORAGE") == PackageManager.PERMISSION_GRANTED)  {

            // Todo : If Permission Granted Then Show SMS


        } else {

            // Todo : Then Set Permission
            final int REQUEST_CODE_ASK_PERMISSIONS = 123;
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, REQUEST_CODE_ASK_PERMISSIONS);

        }

        display();

    }

    void CheckUserPermsions() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                    PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{
                                Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_ASK_PERMISSIONS);
                return;
            }
        }

        display();  // init the contact list

    }




    //get acces to location permsion
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    display();
                } else {
                    // Permission Denied
                    Toast.makeText(this, "your message", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private ArrayList<File> findImage(File file) {
        ArrayList<File> imageList = new ArrayList<File>();
        File[] imageFile =file.listFiles();
        Log.d("TAG", "findImage: "+imageFile.length);
        Log.d("TAG", "findImage: "+imageList.size());

        for (File singleImages : imageFile){

            if (singleImages.isDirectory() && !singleImages.isHidden()){
                imageList.addAll(findImage(singleImages));
            }else {

                if(singleImages.getName().endsWith(".jpg") || singleImages.getName().endsWith(".png")||
                   singleImages.getName().endsWith(".webp")  ){
            }   {
                    imageList.add(singleImages);
                    Log.d("TAG", "findImage: image.... "+singleImages);
                }
            }
        }
        Log.d("TAG", "findImage: "+imageList.size());
        return imageList;
    }

    private void display() {

        myImageFile = findImage(Environment.getExternalStorageDirectory());

        Log.d("TAG", "display: directory size.. "+myImageFile.size());

        for (int j = 0; j<myImageFile.size(); j++){
            myList.add(String.valueOf(myImageFile.get(j)));
            galleryAdapter = new GalleryAdapter(myList);
            recview.setAdapter(galleryAdapter);
            recview.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));

        }

    }

}*/
