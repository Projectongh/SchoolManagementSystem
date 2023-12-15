package com.example.schoolmanagementsystem;

import static android.app.PendingIntent.getActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.schoolmanagementsystem.databinding.ActivityRegistrationBinding;
import com.example.schoolmanagementsystem.models.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {
ActivityRegistrationBinding binding;
FirebaseAuth auth;
FirebaseDatabase firebaseDatabase;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();

        progressDialog = new ProgressDialog(RegistrationActivity.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("We're creating your account");

        boolean isAllFieldsChecked = false;

        binding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                auth.createUserWithEmailAndPassword(binding.mail.getText().toString().trim(),binding.password.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            progressDialog.dismiss();
                            Map<String,String> map=new HashMap<>();
                            map.put("name",binding.name.getText().toString());
                            map.put("email",binding.mail.getText().toString());
                            map.put("password",binding.password.getText().toString());
                            map.put("mobile",binding.mobile.getText().toString());
                            map.put("branch",binding.branch.getText().toString());
                            map.put("year",binding.year.getText().toString());

                            String id=task.getResult().getUser().getUid().toString();

                            firebaseDatabase.getReference().child("Users").child(id).setValue(map);
//                            isAllFieldsChecked = CheckAllFields();
                            Toast.makeText(RegistrationActivity.this, "User Created Successfully!", Toast.LENGTH_SHORT).show();
//
                        }
                        else {
                            Toast.makeText(RegistrationActivity.this, "User not created", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    }
                });
            }
        });

    }
}