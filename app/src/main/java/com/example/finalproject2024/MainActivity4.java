package com.example.finalproject2024;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


            // Find the ImageView and TextView elements
            ImageView homeImageView = findViewById(R.id.home1);
            TextView homeTextView = findViewById(R.id.homeText);

            ImageView aboutImageView = findViewById(R.id.about);
            TextView aboutTextView = findViewById(R.id.aboutText);


            // Set onClickListener for the home elements
            homeImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Perform action when home ImageView is clicked
                    // For example, navigate to the home activity
                    Intent intent = new Intent(MainActivity4.this, MainActivity3.class);
                    startActivity(intent);
                }
            });

            homeTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Perform action when home TextView is clicked
                    // For example, navigate to the home activity
                    Intent intent = new Intent(MainActivity4.this, MainActivity3.class);
                    startActivity(intent);
                }
            });

            // Set onClickListener for the about elements
            aboutImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Perform action when about ImageView is clicked
                    // For example, navigate to the about activity
                    Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
                    startActivity(intent);
                }
            });

            aboutTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Perform action when about TextView is clicked
                    // For example, navigate to the about activity
                    Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
                    startActivity(intent);
                }
            });

            // Set onClickListener for the profile elements





        // Find the "Click Here" text views and WhatsApp image views in each layout
        TextView clickHereText1 = findViewById(R.id.clickHereText1);
        ImageView whatsappImage1 = findViewById(R.id.whatsappImage1);

        TextView clickHereText2 = findViewById(R.id.clickHereText2);
        ImageView whatsappImage2 = findViewById(R.id.whatsappImage2);

        TextView clickHereText3 = findViewById(R.id.clickHereText3);
        ImageView whatsappImage3 = findViewById(R.id.whatsappImage3);

        TextView clickHereText4 = findViewById(R.id.clickHereText4);
        ImageView whatsappImage4 = findViewById(R.id.whatsappImage4);




        // Set onClickListener for each "Click Here" text view with its respective WhatsApp number
        setClickListener(clickHereText1, "9113892524");
        setClickListener(clickHereText2, "9113892524");
        setClickListener(clickHereText3, "9113892524");
        setClickListener(clickHereText4, "9113892524");

        // Set onClickListener for each WhatsApp image view with its respective WhatsApp number
        setClickListener(whatsappImage1, "9113892524");
        setClickListener(whatsappImage2, "9113892524");
        setClickListener(whatsappImage3, "9113892524");
        setClickListener(whatsappImage4, "9113892524");
    }

    // Method to set onClickListener for a view with a specific WhatsApp number
    private void setClickListener(View view, final String number) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWhatsApp(number);
            }
        });


    }

    // Method to open WhatsApp with a default message and a specified number
    public void openWhatsApp(String number ) {
        String message = "Hello, I'm interested in selling my crop through your platform. Could you please guide me on how to proceed?.";

        // Intent to open WhatsApp with the default message and specified number
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=" + number + "&text=" + message));
        startActivity(intent);
    }

}
