package com.example.ecopath_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class User_login_page extends AppCompatActivity {

    EditText aadhar_input,pass_input;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_login_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            aadhar_input=findViewById(R.id.editTextText1);
            pass_input=findViewById(R.id.editTextTextPassword);
            login=findViewById(R.id.Button7);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String aadhar=aadhar_input.getText().toString();
                    String pass=pass_input.getText().toString();
                    USERdatabase mydb=new USERdatabase(User_login_page.this);
                    Boolean ans=mydb.check_regno_password(aadhar,pass);
                    if (ans==true)
                    {
                        Intent intent=new Intent(getApplicationContext(),USER_MAIN_PAGE.class);
                        String name=mydb.getusername(aadhar);
                        String local=mydb.getbranch(aadhar);
                        intent.putExtra("Name",name);
                        intent.putExtra("local",local);
                        intent.putExtra("aadhar",aadhar);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(User_login_page.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            });




            return insets;
        });
    }
}