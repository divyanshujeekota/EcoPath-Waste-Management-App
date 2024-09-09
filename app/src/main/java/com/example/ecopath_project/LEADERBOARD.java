package com.example.ecopath_project;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

public class LEADERBOARD extends AppCompatActivity {

    TextView leader,name_display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_leaderboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            name_display=findViewById(R.id.textView9);
            leader=findViewById(R.id.textView8);
            String lead=getIntent().getStringExtra("leader");
            leader.setText(lead);
            USERdatabase mydb=new USERdatabase(LEADERBOARD.this);
            String name= mydb.getusername(lead);
            name_display.setText(name);

            return insets;
        });
    }
}