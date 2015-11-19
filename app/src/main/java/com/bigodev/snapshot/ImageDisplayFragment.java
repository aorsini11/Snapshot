package com.bigodev.snapshot;


import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImageDisplayFragment extends Fragment {

    ImageView image;
    TextView locationText;
    Button backButton;

    public ImageDisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image_display, container, false);
    }

    @Override
    public void onViewCreated(View v,Bundle savedInstanceState){
        Bitmap b = BitmapFactory.decodeFile(CameraFragment.currentPath);
        image = (ImageView) v.findViewById(R.id.imageview2);
        locationText = (TextView) v.findViewById(R.id.location_text);
        backButton = (Button) v.findViewById(R.id.back_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.container, new CameraFragment())
                        .commit();
            }
        });

        image.setImageBitmap(b);
        if(CameraFragment.currentLocation!=null){
            locationText.setText("Location: " + CameraFragment.currentLocation.getLatitude());
        }
        else {
            locationText.setText("Location: null");
        }

    }


}
