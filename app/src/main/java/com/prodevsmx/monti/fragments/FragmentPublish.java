package com.prodevsmx.monti.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prodevsmx.monti.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPublish extends Fragment {


    public FragmentPublish() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_publish, container, false);
    }

}
