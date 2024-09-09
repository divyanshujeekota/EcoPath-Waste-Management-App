package com.example.ecopath_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class User_signup_page extends AppCompatActivity {

    EditText aadhar,name,local,pass;
    Button signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_signup_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            aadhar=findViewById(R.id.signup_aadhar);
            name=findViewById(R.id.signup_name);
            local=findViewById(R.id.signup_locality);
            pass=findViewById(R.id.signup_password);

            USERdatabase mydb=new USERdatabase(User_signup_page.this);
            String a=aadhar.getText().toString().trim();
            String n=name.getText().toString().trim();
            String l=local.getText().toString().trim();
            String p=pass.getText().toString().trim();



            signup=findViewById(R.id.Signup_button_user);
            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(User_signup_page.this,User_login_page.class);
                    mydb.add_details(a,n,l,p);
                    startActivity(intent);
                }
            });



            return insets;
        });
    }
}