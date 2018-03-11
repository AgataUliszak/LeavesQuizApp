package com.example.android.leavesquizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //declaration of global variables

    private EditText userName;
    private RadioGroup radioGroup2;
    private RadioGroup radioGroup3;
    private RadioGroup radioGroup4;
    private RadioGroup radioGroup5;
    private CheckBox rightAnswer1_1;
    private CheckBox wrongAnswer1_2;
    private CheckBox rightAnswer1_3;
    private CheckBox wrongAnswer1_4;
    private CheckBox rightAnswer1_5;
    private RadioButton rightAnswer2;
    private RadioButton rightAnswer3;
    private RadioButton rightAnswer4;
    private RadioButton rightAnswer5;
    private EditText treeName;
    Button result;
    Button reset;

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//initialization of global variables
        userName = (findViewById(R.id.user_name));
        treeName = (findViewById(R.id.tree_name));
        rightAnswer1_1 = (findViewById(R.id.q1_a1));
        wrongAnswer1_2 = (findViewById(R.id.q1_a2));
        rightAnswer1_3 = (findViewById(R.id.q1_a3));
        wrongAnswer1_4 = (findViewById(R.id.q1_a4));
        rightAnswer1_5 = (findViewById(R.id.q1_a5));
        rightAnswer2 = (findViewById(R.id.q2_a2));
        rightAnswer3 = (findViewById(R.id.q3_a4));
        rightAnswer4 = (findViewById(R.id.q4_a3));
        rightAnswer5 = (findViewById(R.id.q5_a1));
        radioGroup2 = (findViewById(R.id.set2));
        radioGroup3 = (findViewById(R.id.set3));
        radioGroup4 = (findViewById(R.id.set4));
        radioGroup5 = (findViewById(R.id.set5));
        result = (findViewById(R.id.result_button));
        reset = (findViewById(R.id.reset_button));
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("score", score);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            score = savedInstanceState.getInt("score");
        }
    }
    //This method checks the answers and calculate the given for user scores.
    public int calculateScore() {
        //for check box questions we check if the all correct answer is checked. If it's true increase
        //score to one
        if (rightAnswer1_1.isChecked() && !wrongAnswer1_2.isChecked() && rightAnswer1_3.isChecked() &&
                !wrongAnswer1_4.isChecked() && rightAnswer1_5.isChecked()) {
            score++;
        }
        //for radio button questions we check if the only one correct answer is checked. If it's true increase
        //score to one
        if (rightAnswer2.isChecked()) {
            score++;
        }
        if (rightAnswer3.isChecked()) {
            score++;
        }
        if (rightAnswer4.isChecked()) {
            score++;
        }
        if (rightAnswer5.isChecked()) {
            score++;
        }
        //for textEdit check if the entered answer is equal to the correct answer. If it's true increase
        //score to one
        String tree = treeName.getText().toString();
        if (tree.equals("Pine") || tree.equals("pine") || tree.equals("Pinus sylvestris")) {
            score++;
        }
        return score;
    }

    //This method shows the result of the quiz.
    public void checkResult(View v) {
        int finalScore = calculateScore();
        String name = userName.getText().toString();
        Toast.makeText(this, name + "! Your score is " + finalScore + "/6 points", Toast.LENGTH_LONG).show();
        score = 0;
    }

    //This method reset given input
    public void reset(View w) {
        score = 0;
        userName.setText("");
        rightAnswer1_1.setChecked(false);
        wrongAnswer1_2.setChecked(false);
        rightAnswer1_3.setChecked(false);
        wrongAnswer1_4.setChecked(false);
        rightAnswer1_5.setChecked(false);
        radioGroup2.clearCheck();
        radioGroup3.clearCheck();
        radioGroup4.clearCheck();
        radioGroup5.clearCheck();
        treeName.setText("");
    }
}
