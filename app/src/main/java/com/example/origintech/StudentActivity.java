package com.example.origintech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StudentActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;

    private Button buttonRegister, login;
    private FirebaseAuth mAuth;
    private static final String TAG = "StudentActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

//        initialize UI element
        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);

        login = (Button)findViewById(R.id.LoginButton);
//        add event listener to the textview
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//               navigate to the login screen
                startActivity(new Intent(StudentActivity.this, LoginActivity.class));
//                Intent intent = new Intent(StudentActivity.this, LoginActivity.class);


            }
        });

        buttonRegister = (Button) findViewById(R.id.button);
//        attach client event listener to the register button
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                get user input data
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
//                implementation of authentication logic using google firebase
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
//                                    Log.d(TAG, "createUserWithEmail:success");
//                                    Access user login info upon successful login
                                    Toast.makeText(StudentActivity.this, "Authentication successful.",
                                            Toast.LENGTH_SHORT).show();

                                        startActivity(new Intent(StudentActivity.this, StudentHomeActivity.class));






                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(StudentActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
//                                    updateUI(null);
                                }
                            }
                        });






            }
        });

    }
}