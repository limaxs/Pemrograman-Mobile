package com.example.debbyrahardjo.prototype;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RestaurantProfile.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RestaurantProfile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RestaurantProfile extends Fragment {
    public RestaurantProfile(){

    }

    @Override
    public View  onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant_profile,container,false);
        return view;

    }

}
