package com.example.origintech;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        textView = (TextView)findViewById(R.id.textview);
        button = (Button) findViewById(R.id.button);

    }

//    navigate to the stuff section
    public void callSecondActivity(View view) {
        startActivity(new Intent(MainActivity.this, SecondActivity.class));
//       Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//       registerForActivityResult();
    }

//    navigate to  the student section
    public void callStudentActivity(View view) {
        startActivity(new Intent(MainActivity.this, StudentActivity.class));
//        Intent intent = new Intent(MainActivity.this,StudentActivity.class);
    }







}