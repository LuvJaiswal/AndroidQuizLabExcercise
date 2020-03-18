package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainThirdActivity extends AppCompatActivity {
    TextView tv;
    TextView tv2;
    Button btnRestart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_third);
        tv=findViewById(R.id.textView1);
        tv2=findViewById(R.id.textView2);

        btnRestart = (Button) findViewById(R.id.btnRestart);



        StringBuffer sb = new StringBuffer();
        sb.append("Correct answers: " + ItActivity.correct );
        tv.setText(sb);
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong Answers: " + ItActivity.wrong );
        tv2.setText(sb2);
        ItActivity.correct=0;
        ItActivity.wrong=0;

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in);
            }
        });
    }
}
