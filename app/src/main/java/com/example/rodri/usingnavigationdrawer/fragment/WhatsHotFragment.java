package com.example.rodri.usingnavigationdrawer.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rodri.usingnavigationdrawer.R;

/**
 * Created by rodri on 6/27/2016.
 */
public class WhatsHotFragment extends Fragment {

    public WhatsHotFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_whats_hot, container, false);

        return rootView;

    }
}
