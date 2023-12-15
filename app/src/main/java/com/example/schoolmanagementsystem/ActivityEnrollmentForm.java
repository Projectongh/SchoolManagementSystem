package com.example.schoolmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.schoolmanagementsystem.databinding.ActivityEnrollmentFormBinding;

public class ActivityEnrollmentForm extends AppCompatActivity {
ActivityEnrollmentFormBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enrollment_form);

    }
}