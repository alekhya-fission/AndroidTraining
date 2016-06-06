package com.fisstion.sample.checkinguservalidationsusingsqlitedatabase;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by alekhya on 6/6/16.
 */
public class FragmentHomeMessage extends Fragment {
    public FragmentHomeMessage() {

    }

    public static FragmentHomeMessage newInstance() {
        FragmentHomeMessage fragment = new FragmentHomeMessage();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View loginView = inflater.inflate(R.layout.fragment_welcome_home, container, false);
        return loginView;

    }

}

