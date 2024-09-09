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

public class Authority_signup_page extends AppCompatActivity {

    EditText id_input,name_input,local_input,pass_input;
    Button signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_authority_signup_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);


            id_input=findViewById(R.id.authority_signup_idnumber);
            name_input=findViewById(R.id.authority_signup_name);
            local_input=findViewById(R.id.authority_signup_locality);
            pass_input=findViewById(R.id.authority_signup_password);

            String id=id_input.getText().toString();
            String name=name_input.getText().toString();
            String local=local_input.getText().toString();
            String pass=pass_input.getText().toString();

            signup=findViewById(R.id.Button10);
            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AUTHORITYdatabase mydb=new AUTHORITYdatabase(Authority_signup_page.this);
                    mydb.add_details(id,name,local,pass);
                    Intent intent=new Intent(Authority_signup_page.this,Authority_login_page.class);
                    startActivity(intent);
                }
            });








            return insets;
        });
    }
}