package com.example.finalproject2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.finalproject2024.databinding.ActivityMain2Binding;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity {
    ActivityMain2Binding am;
    FirebaseFirestore fdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        am = DataBindingUtil.setContentView(this, R.layout.activity_main2);
        fdb = FirebaseFirestore.getInstance();

        am.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = am.editTextText2.getText().toString();
                String userDOB = am.editTextDate.getText().toString();
                String userEmail = am.editTextTextEmailAddress.getText().toString();
                String userLocation = am.editTextText3.getText().toString();
                String userPhoneNumber = am.editTextPhone.getText().toString();
                String userNewPassword = am.editTextTextPassword2.getText().toString();
                String userConfirmPassword = am.editTextTextPassword3.getText().toString();

                // Check if any of the fields are empty
                if (userName.isEmpty() || userEmail.isEmpty() || userPhoneNumber.isEmpty()) {
                    showToast("Please fill in all fields");
                } else if (!userNewPassword.equals(userConfirmPassword)) {
                    showToast("Passwords do not match");
                } else {
                    // Create a map to store user data
                    Map<String, Object> user = new HashMap<>();
                    user.put("Name", userName);
                    user.put("Email", userEmail);
                    user.put("Location", userLocation);
                    user.put("PhoneNumber", userPhoneNumber);
                    user.put("NewPassword", userNewPassword);
                    user.put("ConfirmPassword", userConfirmPassword);

                    // Add data to the "users" collection (or your desired collection name)
                    fdb.collection("users")
                            .add(user)
                            .addOnSuccessListener(documentReference -> {
                                showToast("User signed up successfully");
                                // Navigate back to the main activity
                                navigateToMainActivity();
                            })
                            .addOnFailureListener(e -> {
                                showToast("Error signing up user: " + e.getMessage());
                            });
                }
            }
        });
    }

    private void showToast(String message) {
        // Helper method to show a toast message
        Toast.makeText(MainActivity2.this, message, Toast.LENGTH_SHORT).show();
    }

    private void navigateToMainActivity() {
        // Create an Intent to start the main activity
        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);

        // If you want to clear the back stack, add flags
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        // Start the main activity
        startActivity(intent);
    }
}