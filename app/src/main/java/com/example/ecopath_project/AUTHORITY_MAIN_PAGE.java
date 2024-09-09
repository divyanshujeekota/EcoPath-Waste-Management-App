package com.example.ecopath_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AUTHORITY_MAIN_PAGE extends AppCompatActivity {

    TextView name,local,id;
    Button waste,report,home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_authority_main_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            name=findViewById(R.id.textView);
            local=findViewById(R.id.local);
            id=findViewById(R.id.aadhar);
            String text1=getIntent().getStringExtra("name");
            String text2=getIntent().getStringExtra("local");
            String text3=getIntent().getStringExtra("id");
            name.setText(text1);
            local.setText(text2);
            id.setText(text3);

            waste=findViewById(R.id.incentive);
            report=findViewById(R.id.reports);

            home=findViewById(R.id.homebutton);

            home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(AUTHORITY_MAIN_PAGE.this,MainActivity.class);
                    startActivity(intent);
                }
            });

            waste.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(AUTHORITY_MAIN_PAGE.this,COLLECT_WASTE.class);
                    startActivity(intent);
                }
            });






            return insets;
        });
    }
}