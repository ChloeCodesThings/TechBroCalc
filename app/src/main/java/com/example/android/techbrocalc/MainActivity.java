package com.example.android.techbrocalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;

import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int techBroTotal = 0;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = findViewById(R.id.submitButton);

        submit.setOnClickListener(submitButtonOnClickListener);
    }

    private int getQuestion1Input() {
        EditText vestAmount = (EditText) findViewById(R.id.vest_amount);
        String question1Answer = vestAmount.getText().toString();
        int vestTotal = Integer.parseInt(question1Answer);
        return vestTotal;
    }

    private void checkQuestion1() {
        int question1Answer = getQuestion1Input();
        if (question1Answer > 0) {
            techBroTotal += question1Answer;
        }

    }

    private int getQuestion2Input() {
        EditText brandAmount = (EditText) findViewById(R.id.branded_vest_amount);
        String question2Answer = brandAmount.getText().toString();
        int brandTotal = Integer.parseInt(question2Answer);
        return brandTotal;
    }

    private void checkQuestion2() {
        int question2Answer = getQuestion2Input();
        if (question2Answer > 0) {
            techBroTotal += question2Answer;
        }

    }



    private void checkQuestions() {
        checkQuestion1();
        checkQuestion2();
//        checkQuestion3();
//        checkQuestion4();
    }

    private void resetCounterCorrectAnswers() {
        techBroTotal = 0;
    }

    final View.OnClickListener submitButtonOnClickListener = new View.OnClickListener() {
        public void onClick(final View v) {
            checkQuestions();
            Toast.makeText(MainActivity.this, "Your TechBro Total is: " + techBroTotal + "!",
                    Toast.LENGTH_LONG).show();
            resetCounterCorrectAnswers();
        }
    };
}