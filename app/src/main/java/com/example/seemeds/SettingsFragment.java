package com.example.seemeds;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsFragment extends Fragment {

//    public static class AccountSettingsFragment extends PreferenceFragmentCompat {
//        @Override
//        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
//            setPreferencesFromResource(R.xml.account_preferences, rootKey);
//        }
//    }


//    @Override
//    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
//        setPreferencesFromResource(R.xml.preferences, rootKey);





//    //this is only to log username and password from account preferences ONCLICK
//
//        Preference accountSettingsPreference = findPreference("account_settings");
//        //if account is not null set click listener
//        if (accountSettingsPreference != null) {
//            //our variable,            //set click listener
//            accountSettingsPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
//                @Override
//                //when clicked log message
//                public boolean onPreferenceClick(Preference preference) {
//                    Log.d("Preferences", "Account settings was clicked");
//                    return true; // Return true if the click is handled.
//                }
//            });
//        }


//        // Get the "username" and "password" preferences and log them
//        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this.getContext());
//        String username = preferences.getString("username", "");
//        String password = preferences.getString("password", "");

//        // Get the "notifications" preference and set a change listener on it, When the user changes this preference, the new value is logged
//        SwitchPreferenceCompat notificationsPreference = findPreference("notifications");
//        if (notificationsPreference != null) {
//            notificationsPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
//                @Override
//                public boolean onPreferenceChange(Preference preference, Object newValue) {
//                    Log.d("Preferences", "Notifications enabled: " + newValue);
//                    return true; // Return true if the event is handled.
//                }
//            });
//        }

//        // Get the "feedback" preference and set a click listener on it,  When the user clicks this preference, a message is logged
//        Preference feedbackPreference = findPreference("feedback");
//        if (feedbackPreference != null) {
//            feedbackPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
//                @Override
//                public boolean onPreferenceClick(Preference preference) {
//                    Log.d("Preferences", "Feedback was clicked");
//                    return true; // Return true if the click is handled.
//                }
//            });
//        }

//        // Get all preferences and log them
//         preferences = PreferenceManager.getDefaultSharedPreferences(this.getContext());
//        Map<String, ?> allEntries = preferences.getAll();
//
//        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
//            Log.d("Preferences", entry.getKey() + " -> " + entry.getValue().toString());
//        }
//    }

    private void setContentView(int activityMain) {
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SettingsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    //create view for xml file preferences


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.login, container, false);
    }


}