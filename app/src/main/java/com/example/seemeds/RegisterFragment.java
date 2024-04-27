package com.example.seemeds;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import androidx.fragment.app.FragmentManager;


public class RegisterFragment extends Fragment {

    EditText mFulLName, mNumberPhone, mEmail, mPassword;
    Button mResisterBtn;
    FirebaseAuth fAuth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        mFulLName = view.findViewById(R.id.fullName);
        mNumberPhone = view.findViewById(R.id.numberPhone);
        mEmail = view.findViewById(R.id.email);
        mPassword = view.findViewById(R.id.password);
        mResisterBtn = view.findViewById(R.id.login);

        fAuth = FirebaseAuth.getInstance();

        // progressBar =

//        if(fAuth.getCurrentUser() != null){
//            startActivity(new Intent(getApplicationContext(),MainActivity.class));
//            finish();
//        }

        mResisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Requiered");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is Requierd");
                    return;
                }

                if(password.length() < 6 ){
                    mPassword.setError("Password must be more than 6 Characters");
                    return;
                }

                // progressBar

                // Register user in firebase
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                          //  Toast.makeText(Register.this, "User Created.", Toast.LENGTH_SHORT).show();
                            Toast.makeText(getContext(),"User Created.", Toast.LENGTH_SHORT).show();;

                            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                            fragmentManager.beginTransaction()
                                    .replace(R.id.fragmentContainerView2, CameraFragment.class, null) //replace frag-container with fragment clicked
                                    .setReorderingAllowed(true)
                                    .addToBackStack("name") // Name can be null
                                    .commit();

                        } else{
                            Toast.makeText(getContext(), "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT ).show();
                        }
                    }
                });
            }
        });

        return view;
    }
}
