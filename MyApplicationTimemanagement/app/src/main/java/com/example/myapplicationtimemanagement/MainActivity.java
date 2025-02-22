package com.example.myapplicationtimemanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.myapplicationtimemanagement.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


        ActivityMainBinding binding;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            binding = ActivityMainBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            replaceFragment(new HomeFragment());

            binding.bottomNavigationView.setOnItemSelectedListener(item ->{

                switch (item.getItemId()){

                    case R.id.home:
                        replaceFragment(new HomeFragment());
                        break;
                    case R.id.tasks:
                        replaceFragment(new TasksFragment());
                        break;
                    case R.id.notes:
                        replaceFragment(new NotesFragment());
                        break;



                }


                return true;
            });
        }

        private void replaceFragment(Fragment fragment ){

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.commit();

    }
}