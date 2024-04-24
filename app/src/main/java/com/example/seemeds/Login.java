package com.example.seemeds;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.seemeds.databinding.LoginBinding;

public class Login extends AppCompatActivity {


    //binding for the main activity
    private LoginBinding binding;     //setting up binding for the main activity
    private  Button mRegisterNowBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //this section is for binding (needs to be first in oncreate method to view the layout)
        binding = LoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setContentView(R.layout.login);


        mRegisterNowBtn = findViewById(R.id.registerNowBtn);
        mRegisterNowBtn.setOnClickListener(new View.OnClickListener() { //when we click this something should happen
            @Override
            public void onClick(View v) {
                //we need a fragment manager to display multi fragments(make transactions)
                FragmentManager fragmentManager = getSupportFragmentManager(); //get me any supported  manager

                fragmentManager.beginTransaction() //begin transaction
                        .replace(R.id.fragmentContainerView2, new RegisterFragment()) //replace frag-container with fragment clicked
                        .setReorderingAllowed(true)
                        .addToBackStack("name") // Name can be null
                        .commit();
            }
        });

//        binding.registerNowBtn.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Log.d("LoginActivity", "registerNowBtn clicked");
//                Intent intent = new Intent(Login.this, Register.class);
//                startActivity(intent);
//            }
//        });
//
//
//    }


//    //replace frame layout with fragment method
//    private void replaceFragment(Fragment fragment) {
//
//        FragmentManager fragmentManager = getSupportFragmentManager(); //get fragment manager
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); //begin transaction
//        fragmentTransaction.commit(); //commit the transaction
//
//    }


    }
}