package com.example.schoolmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.schoolmanagementsystem.databinding.ActivityEventsBinding;

public class ActivityEvents extends AppCompatActivity {
ActivityEventsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityEventsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ActivityEvents.this, ActivityTwenty.class);
                startActivity(intent);
            }
        });
    }
}