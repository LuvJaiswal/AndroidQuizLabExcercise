package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ItActivity extends AppCompatActivity {

    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
//            "Which method can be defined only once in a program?",
//            "Which of these is not a bitwise operator?",
//            "Which keyword is used by method to refer to the object that invoked it?",
//            "Which of these keywords is used to define interfaces in Java?",
//            "Which of these access specifiers can be used for an interface?",
//            "Which of the following is correct way of importing an entire package â€˜pkgâ€™?",
//            "What is the return type of Constructors?",
//            "Which of the following package stores all the standard java classes?",
//            "Which of these method of class String is used to compare two String objects for their equality?",
//            "An expression involving byte, int, & literal numbers is promoted to which of these?"

            "Explain android activity life cycle?",
            "What is the difference between margin and padding in android layout?",
            "What is ANR in android?",
            "How many broadcast receivers are available in android?",
            "Persist data can be stored in Android through",
            "What is breakpoint in android?",
            "What is an HTTP client class in android?",
            "What is sandbox in android?",
            "Is it possible activity without UI in android?",
            "What is anchor view?"
    };
    String answers[] = {

//            "main method","<=","this","interface","public","import pkg.*","None of the mentioned","java","equals()","int"
            "OnCreate() −> onStart() −>onResume() −> onPause() −> onStop() −> onRestart() −> onDestroy()",
            "Both A and B are correct",
            "When the application is not responding ANR will occur.",
            "sendBroadcast(),sendOrderBroadcast(),and sendStickyBroadcast().",
            "All of above",
            "Breaks the execution.",
            "httprequest(get/post) and returns response from the server",
            "Each application runs securely in sandbox without interrupting another process ",
            "Yes,it's possible ",
            "provides the information on respective relative positions"
    };

    String opt[] = {
//            "finalize method","main method","static method","private method",
//            "&","&=","|=","<=",
//            "import","this","catch","abstract",
//            "Interface","interface","intf","Intf",
//            "public","protected","private","All of the mentioned",
//            "Import pkg.","import pkg.*","Import pkg.*","import pkg.",
//            "int","float","void","None of the mentioned",
//            "lang","java","util","java.packages",
//            "equals()","Equals()","isequal()","Isequal()",
//            "int","long","byte","float"
            "onCreate() −> onStart() −> onActivityStarted() −> onResume() −> onPause() −> onStop() −> onActivityDistroy() −> onDestroy()","OnCreate() −> onStart() −>onResume() −> onPause() −> onStop() −> onRestart() −> onDestroy()","OnCreate() −> onStart() −> onPause() −> onResume() −> onStop() −> onDestroy()","−>onResume()",
            "Margin is specifying the extra space left on all four sides in layout","Padding is used to offset the content of a view by specific px or dp ","Both A and B are correct","None of the above ",
            "When the application is not responding ANR will occur.","Dialog box is called as ANR.","When Android forcefully kills an application, it is called ANR"," None of the above ",
            "sendIntent()","onRecieve()","implicitBroadcast()","sendBroadcast(),sendOrderBroadcast(),and sendStickyBroadcast(). ",
            "Shared Preferences","Internal/External storage","SQlite","All of above",
            "Breaks the application","Breaks the development code","Breaks the execution.","None of the above.",
            "httprequest(get/post) and returns response from the server","Cookies management","Authentication management","None of the above",
            "Each application runs securely in sandbox without interrupting another process ","Android Box ","Android development tool kit","None of the above",
            "No, it's not possible","Yes,it's possible ","We can't say","None of the above",
            "Same as list view ","provides the information on respective relative positions"," Same as relative layout"," None of the above"
    };


    public static int marks=0,correct=0,wrong=0;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it);

        final TextView score = (TextView)findViewById(R.id.textView4);

        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),MainThirdActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainThirdActivity.class);
                startActivity(intent);

            }
        });
    }

}
