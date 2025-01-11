package com.example.finalproject2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.finalproject2024.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding am;
   FirebaseFirestore fdb;
String Email,Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        am = DataBindingUtil.setContentView(this, R.layout.activity_main);


        am.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Email = am.editTextTextEmailAddress2.getText().toString();
            Password = am.editTextTextPassword.getText().toString();
               fdb=FirebaseFirestore.getInstance();
               signIn(Email,Password);

            }

        });

        am.textview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void signIn(String email, String password) {
        fdb.collection("users")
                .whereEqualTo("Email", email)
                .whereEqualTo("NewPassword", password)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            QuerySnapshot querySnapshot = task.getResult();
                            if (querySnapshot != null && !querySnapshot.isEmpty()) {
                                // If the query returns any documents, the username and password match
                                // Open the next activity
                                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                                Toast.makeText(MainActivity.this, "Login Sucessfull", Toast.LENGTH_SHORT).show();
                                startActivity(intent);
                                finish(); // Close the sign-in activity
                            } else {
                                // If no documents are returned, the username and password do not match
                                Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            // If an error occurs while querying Firestore
                            Toast.makeText(MainActivity.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}
