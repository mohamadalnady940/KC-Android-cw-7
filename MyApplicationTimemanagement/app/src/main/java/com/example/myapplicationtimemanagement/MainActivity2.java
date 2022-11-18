package com.example.myapplicationtimemanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity2 extends AppCompatActivity {
Button btnInsert, btnView;
EditText tasks , time , discription;
DatabaseReference databaseUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       btnInsert = findViewById(R.id.btninsert);
       btnView = findViewById(R.id.btnview);
       tasks = findViewById(R.id.edttask);
       time = findViewById(R.id.edttime);
       discription = findViewById(R.id.edtdisc);
       databaseUsers = FirebaseDatabase.getInstance().getReference();

       btnInsert.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               InsertData();
           }
       });
       btnView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(MainActivity2.this , Userlist.class));
               finish();
           }
       });


    }

    private void InsertData() {

        String usertask = tasks.getText().toString();
        String usertime = time.getText().toString();
        String userdisc = discription.getText().toString();
        String id = databaseUsers.push().getKey();

        User user = new User(usertask ,usertime , userdisc);
        databaseUsers.child("users").child(id).setValue(user)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(MainActivity2.this, "Task Details Inserted" ,Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}