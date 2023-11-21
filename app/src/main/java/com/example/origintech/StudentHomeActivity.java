package com.example.origintech;

import static android.content.Intent.getIntent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.net.URISyntaxException;

public class StudentHomeActivity extends AppCompatActivity {

    ListView listView;
    String tutorials[]
            = { "Lecturers on strike", "Upcoming semester events",
            "Languages", "Industry correlation",
            "Female Empowerment program", "Abroad Program",
            "Amalitech Internship" };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);
//        displaying toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

//        code for rating star
        RatingBar ratingBar = (RatingBar) findViewById(R.id.simpleRatingBar);
        Button ratingButton = (Button) findViewById(R.id.ratingBtn);
        ratingBar.setRating((float) 2.5);
        ratingBar.setNumStars(4);
//        add click listener to the rating stars
        ratingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rating = String.valueOf(ratingBar.getRating());
                Toast.makeText(StudentHomeActivity.this, rating, Toast.LENGTH_SHORT).show();
            }
        });





//        displaying list of student motivation
        listView = findViewById(R.id.list);
        ArrayAdapter<String> arrayAdapter;
        arrayAdapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                tutorials);
        listView.setAdapter(arrayAdapter);



    }










}