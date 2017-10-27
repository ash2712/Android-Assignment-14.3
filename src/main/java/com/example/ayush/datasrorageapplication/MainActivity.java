package com.example.ayush.datasrorageapplication;

import android.content.ContentValues;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt1 = (Button) findViewById(R.id.button);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "Hello I am a string";
                //data that is to be added into the file
                try{
                    FileOutputStream output = openFileOutput("myText.txt" ,MODE_PRIVATE);
                    output.write(data.getBytes());
                    //writes data to the file
                    output.close();
                    Toast.makeText(MainActivity.this, "File saved successfully", Toast.LENGTH_SHORT).show();
                    //notifies user that file has been saved
                }catch (Exception A){
                    A.printStackTrace();
                }
            }
        });

        Button bt_checkFile = (Button) findViewById(R.id.button2);
        bt_checkFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isItThere = isFilePresent("myText.txt");
                if (isItThere){
                    Toast.makeText(MainActivity.this, "File exists", Toast.LENGTH_SHORT).show();
                    //notifies user if file exists
                }
                else{
                    Toast.makeText(MainActivity.this, "File does not exist yet", Toast.LENGTH_SHORT).show();
                    //notifies user that file does not exist yet
                }
            }
        });

    }

    public boolean isFilePresent(String fileName) {
        String path = getApplicationContext().getFilesDir().getAbsolutePath() + "/" + fileName;
        //gets path for the file name
        File file = new File(path);
        return file.exists();
    }
}
