package com.example.finalproject2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ViewPager viewPager = findViewById(R.id.viewPager);
        int[] imageIds = {R.drawable.ela2, R.drawable.coconut, R.drawable.cfe1,R.drawable.ging1};
        ImagePagerAdapter adapter = new ImagePagerAdapter(this, imageIds, viewPager);
        viewPager.setAdapter(adapter);

        // Set onClickListeners for category images
        findViewById(R.id.category1_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                intent.putExtra("category", "Category 1");
                startActivity(intent);
            }
        });

        findViewById(R.id.category2_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                intent.putExtra("category", "Category 2");
                startActivity(intent);
            }
        });

        findViewById(R.id.category3_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                intent.putExtra("category", "Category 3");
                startActivity(intent);
            }
        });

        findViewById(R.id.category4_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                intent.putExtra("category", "Category 4");
                startActivity(intent);
            }
        });

        findViewById(R.id.category5_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                intent.putExtra("category", "Category 5");
                startActivity(intent);
            }
        });

        findViewById(R.id.category6_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                intent.putExtra("category", "Category 6");
                startActivity(intent);
            }
        });
    }
}
