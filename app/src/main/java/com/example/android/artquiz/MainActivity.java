package com.example.android.artquiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int rightAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the submit button is clicked.
     */
    public void submitAnswers(View view) {

        rightAnswers = 0;

        /**
         * Checking the answer for question 1 (EditText)
         */
        rightAnswers += checkTextAnswer(R.id.leonardo_edit_text, "Mona Lisa");

        /**
         * Checking the answer for question 2 (Checkbox)
         */
        CheckBox Monet = (CheckBox) findViewById(R.id.monet_1);
        CheckBox Russell = (CheckBox) findViewById(R.id.russell_2);
        CheckBox Cezanne = (CheckBox) findViewById(R.id.cezanne_3);
        CheckBox Degas = (CheckBox) findViewById(R.id.degas_4);

        if ((Monet.isChecked() && Degas.isChecked() && !Russell.isChecked() && !Cezanne.isChecked())){
            rightAnswers++;
        }

        /**
         * Checking the answer for question 3 (Radio button)
         */
        rightAnswers += checkRadioAnswer(R.id.radiogroup_question3, R.id.q3_3_radio_button);

       /**
         * Checking the answer for question 4 (Radio button)
         */
        rightAnswers += checkRadioAnswer(R.id.radiogroup_question4, R.id.q4_2_radio_button);

        /**
         * Checking the answer for question 5 (Radio button)
         */
        rightAnswers += checkRadioAnswer(R.id.radiogroup_question5, R.id.q5_2_radio_button);

        /**
         * Checking the answer for question 6 (EditText)
        */
        rightAnswers += checkTextAnswer(R.id.louvre_edit_text, "Louvre");

        /**
         * Checking the answer for question 7 (Radio button)
         */
        rightAnswers += checkRadioAnswer(R.id.radiogroup_question7, R.id.q7_3_radio_button);

        /**
         * This method is called to show toast message when the submit button is clicked.
         */
        String text = "You got " + rightAnswers + " out of 7 correct answers. ";
        if (rightAnswers <= 2) {
            text += "Try again.";
        } else if (rightAnswers == 7) {
            text += "Great job!";
        }

        Toast toast = Toast.makeText(this, text, Toast.LENGTH_LONG);
        toast.show();

    }

    private int checkTextAnswer(int editTextId, String rightAnswer) {
        EditText editText = (EditText) findViewById(editTextId);
        if (editText.getText().toString().equalsIgnoreCase(rightAnswer)) {
            return 1;
        } else {
            return 0;
        }
    }

    private int checkRadioAnswer (int radioGroupId, int rightAnswerRadioButtonId){
        RadioGroup radioGroup = (RadioGroup) findViewById(radioGroupId);
        if (radioGroup.getCheckedRadioButtonId() == rightAnswerRadioButtonId) {
            return 1;
        } else {
            return 0;
        }
    }
}
