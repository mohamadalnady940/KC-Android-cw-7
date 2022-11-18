package com.example.myapplicationtimemanagement;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class TasksFragment extends Fragment {


    Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),MainActivity2.class);
                startActivity(intent);
            }
        });
        return view;
    }
}