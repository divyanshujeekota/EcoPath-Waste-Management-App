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

public class COLLECT_WASTE extends AppCompatActivity {

    EditText aadhar_input,bio_input,nonbio_input;
    Button collect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_collect_waste);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            aadhar_input=findViewById(R.id.editTextText);
            bio_input=findViewById(R.id.editTextText2);
            nonbio_input=findViewById(R.id.editTextText3);

            collect=findViewById(R.id.button);

            collect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Signupdatabase mydb =new Signupdatabase(COLLECT_WASTE.this);
                    String aadhar=aadhar_input.getText().toString();
                    int bio=Integer.parseInt(bio_input.getText().toString());
                    int nonbio=Integer.parseInt(nonbio_input.getText().toString());
                    mydb.add_details(aadhar,bio,nonbio);
                    aadhar_input.setText("");
                    bio_input.setText("");
                    nonbio_input.setText("");
                    mydb.close();


                }
            });



            return insets;
        });
    }
}