package com.example.seemeds;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CameraFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CameraFragment extends Fragment {

        private Button buttonPicture;
        private ImageView imageViewPicture;

        // RETURN CODE "22 " AFTER USER TAKES PHOTO IN CAMERA APP, SO OUT APPLICATION KNOWS WHAT PHOTO USER TOOK
        private static final int REQUEST_CODE = 22;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_camera, container, false);

            buttonPicture = view.findViewById(R.id.buttoncamera1);
            imageViewPicture = view.findViewById(R.id.imageview1);

            //onclick listener for the ButtonPicture to view camera
            buttonPicture.setOnClickListener(new View.OnClickListener() {

                @Override                //create new intent to swap between 2 activities(button to camera)
                public void onClick(View v) {

                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);  // media store is a class that provides access to the content, like images, audio, video
                    startActivityForResult(cameraIntent, REQUEST_CODE);
                }
            });

            return view;
        }

//        @Override         //this method is called when user takes a photo
//        public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//            if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
//                  //thumbnail of  the photo user took (compressed)
//                 Bitmap photo = ((Bitmap)data.getExtras().get("data"));
//                 imageViewPicture.setImageBitmap(photo);
//            } else {
//                //if user cancels the camera
//                Toast.makeText(getActivity(), " Cancelled the camera", Toast.LENGTH_SHORT).show();
//                super.onActivityResult(requestCode, resultCode, data);
//            }
//        }



    //EDITOR THINGS ********************************************************************************************************************
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public CameraFragment() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CameraFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CameraFragment newInstance(String param1, String param2) {
        CameraFragment fragment = new CameraFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    //part#2
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    //EDITOR THINGS ********************************************************************************************************************


}