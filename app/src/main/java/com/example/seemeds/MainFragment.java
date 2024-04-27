package com.example.seemeds;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.View;
import android.widget.ImageButton;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;


    public class MainFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_main, container, false);

            ImageButton btnCamera = view.findViewById(R.id.button_camera);
            btnCamera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    replaceFragment(new CameraFragment());
                }
            });

            ImageButton btnSchedule = view.findViewById(R.id.button_schedule);
            btnSchedule.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    replaceFragment(new ScheduleFragment());
                }
            });

            ImageButton btnPreferences = view.findViewById(R.id.button_preferences);
            btnPreferences.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    replaceFragment(new SettingsFragment());
                }
            });

            return view;
        }

        private void replaceFragment(Fragment fragment) {
            FragmentManager fragmentManager = getParentFragmentManager(); // Use getParentFragmentManager() for fragments
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView2, fragment)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        }
    }
