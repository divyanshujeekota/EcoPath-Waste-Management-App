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

public class Authority_login_page extends AppCompatActivity {

    EditText id_input,pass_input;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_authority_login_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            id_input=findViewById(R.id.authority_login_aadhar);
            pass_input=findViewById(R.id.authority_login_password);
            login=findViewById(R.id.Button9);



            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String id=id_input.getText().toString();
                    String pass=pass_input.getText().toString();
                    AUTHORITYdatabase mydb=new AUTHORITYdatabase(Authority_login_page.this);
                    Boolean ans=mydb.check_regno_password(id,pass);
                    if (ans==true)
                    {
                        String name=mydb.getusername(id);
                        String local=mydb.getbranch(id);
                        Intent intent=new Intent(getApplicationContext(),AUTHORITY_MAIN_PAGE.class);
                        intent.putExtra("name",name);
                        intent.putExtra("local",local);
                        intent.putExtra("id",id);
                        startActivity(intent);

                    }
                    else
                    {
                        Toast.makeText(Authority_login_page.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            });



            return insets;
        });
    }
}