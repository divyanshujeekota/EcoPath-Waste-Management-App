package com.example.ecopath_project;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Incentive extends AppCompatActivity {

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_incentive);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            result=findViewById(R.id.textView3);
            String reg=getIntent().getStringExtra("aadhar");
            Signupdatabase mydb=new Signupdatabase(Incentive.this);
            int bio=mydb.getbio(reg);
            int nonbio=mydb.nongetbio(reg);
            int total=bio*2+nonbio*1;
            String text_result=String.valueOf(total);
            result.setText(text_result);





            return insets;
        });
    }
}