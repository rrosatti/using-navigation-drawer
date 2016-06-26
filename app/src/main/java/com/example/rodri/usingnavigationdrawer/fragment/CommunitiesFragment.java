package com.example.rodri.usingnavigationdrawer.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rodri.usingnavigationdrawer.R;

/**
 * Created by rodri on 6/26/2016.
 */
public class CommunitiesFragment extends Fragment {

    public CommunitiesFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_communities, container, false);

        return rootView;

    }
}
