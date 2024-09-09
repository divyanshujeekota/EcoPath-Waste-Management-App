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

public class USER_MAIN_PAGE extends AppCompatActivity {

    TextView name,local,aadhar;
    Button incentive,leader,report,home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_main_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            name=findViewById(R.id.textView);
            local=findViewById(R.id.local);
            aadhar=findViewById(R.id.aadhar);

            String text1=getIntent().getStringExtra("Name");
            String text2=getIntent().getStringExtra("local");
            String text3=getIntent().getStringExtra("aadhar");
            name.setText(text1);
            local.setText(text2);
            aadhar.setText(text3);

            home=findViewById(R.id.homebutton2);

            home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(USER_MAIN_PAGE.this,MainActivity.class);
                    startActivity(intent);
                }
            });


            incentive=findViewById(R.id.incentive);
            leader=findViewById(R.id.leader);
            report=findViewById(R.id.report);

            incentive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(USER_MAIN_PAGE.this,Incentive.class);
                    intent.putExtra("aadhar",text3);
                    startActivity(intent);
                }
            });

            leader.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Signupdatabase mydb=new Signupdatabase(USER_MAIN_PAGE.this);
                    String lead=mydb.getLeader(text3);
                    Intent intent=new Intent(getApplicationContext(),LEADERBOARD.class);
                    intent.putExtra("leader",lead);
                    startActivity(intent);
                }
            });










            return insets;
        });
    }
}