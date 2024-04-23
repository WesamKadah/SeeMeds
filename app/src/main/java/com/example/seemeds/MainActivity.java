package com.example.seemeds;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.seemeds.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // RETURN CODE "22 " AFTER USER TAKES PHOTO IN CAMERA APP, SO OUT APPLICATION KNOWS WHAT PHOTO USER TOOK
    private static final int REQUEST_CODE = 22;

    Button buttonPicture, mRegisterNowbtn;

    ImageView imageViewPicture;

    //binding for the main activity
    private
    ActivityMainBinding binding;     //setting up binding for the main activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // mRegisterNowbtn = (Button) findViewById(R.id.registerNowBtn);

        //this section is for binding (needs to be first in oncreate method to view the layout)
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new CameraFragment()); //replace frame with the camera when app starts (default page)

        binding.registerNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });

        //whenever user selects item we will get it in 'item' variable
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            //create a fragment object
            Fragment selectedFragment = null; // THIS MIGHT REPLACE ON APP START CAMERA ?

            //check which item is selected //if camera is selected then replace with camera fragment
            if (item.getItemId() == R.id.camera) { //i did it with if instead of switch cuz of id static nature
                selectedFragment = new CameraFragment();
            } else if (item.getItemId() == R.id.schedule) {
                selectedFragment = new ScheduleFragment();
            } else if (item.getItemId() == R.id.settings) {
                selectedFragment = new SettingsFragment();
            }

            //if selected fragment is not null then replace the fragment
            if (selectedFragment != null) {
                replaceFragment(selectedFragment);
            }

            return true;
        });


    }



    //
    //replace frame layout with fragment method
    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager(); //get fragment manager
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); //begin transaction
        fragmentTransaction.replace(R.id.frame_layout, fragment); //replace the fragment
        fragmentTransaction.commit(); //commit the transaction

    }


}
