package com.example.seemeds;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.seemeds.databinding.LoginBinding;

public class Login extends AppCompatActivity {


    //binding for the main activity
    private LoginBinding binding;     //setting up binding for the main activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //this section is for binding (needs to be first in oncreate method to view the layout)
        binding = LoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setContentView(R.layout.login);


        binding.registerNowBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("LoginActivity", "registerNowBtn clicked");
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });


    }



//    //replace frame layout with fragment method
//    private void replaceFragment(Fragment fragment) {
//
//        FragmentManager fragmentManager = getSupportFragmentManager(); //get fragment manager
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); //begin transaction
//        fragmentTransaction.commit(); //commit the transaction
//
//    }


}