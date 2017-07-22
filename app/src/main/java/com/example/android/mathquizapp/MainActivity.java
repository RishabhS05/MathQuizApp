package com.example.android.mathquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtForQ5;
    private RadioGroup mRadioGroup1, mRadioGroup2, mRadioGroup3, mRadioGroup4;
    private CheckBox mCheckBox1, mCheckBox2, mCheckBox3, mCheckBox4;
    int scoreQ1, scoreQ2, scoreQ3, scoreQ4, scoreQ5, scoreQ6, totalscore;
    private boolean checked1, checked2, checked3, checked4, checked5, checked6;
    private String answer5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializer();
    }

    private void initializer() {
        edtForQ5 = (EditText) findViewById(R.id.et_question5);
        mRadioGroup1 = (RadioGroup) findViewById(R.id.radiogroup1);
        mRadioGroup2 = (RadioGroup) findViewById(R.id.radiogroup2);
        mRadioGroup3 = (RadioGroup) findViewById(R.id.radiogroup3);
        mRadioGroup4 = (RadioGroup) findViewById(R.id.radiogroup4);
        mCheckBox1 = (CheckBox) findViewById(R.id.checkbox_1);
        mCheckBox2 = (CheckBox) findViewById(R.id.checkbox_2);
        mCheckBox3 = (CheckBox) findViewById(R.id.checkbox_3);
        mCheckBox4 = (CheckBox) findViewById(R.id.checkbox_4);
    }

    private void uncheckRadioGroup(RadioGroup radioGroup) {
        radioGroup.clearCheck();
    }

    public void onClickReset(View view) {
        uncheckRadioGroup(mRadioGroup1);
        uncheckRadioGroup(mRadioGroup2);
        uncheckRadioGroup(mRadioGroup3);
        uncheckRadioGroup(mRadioGroup4);
        edtForQ5.setText("");
        uncheckCheckBoxes();
    }

    private void uncheckCheckBoxes() {
        mCheckBox1.setChecked(false);
        mCheckBox2.setChecked(false);
        mCheckBox3.setChecked(false);
        mCheckBox4.setChecked(false);
        checked6 = false;
    }

    public void onCheckedQuestion4(View view) {
        checked4 = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.button4_1:
                scoreQ4 = 0;
                break;
            case R.id.button4_2:
                scoreQ4 = 0;
                break;
            case R.id.button4_3:
                scoreQ4 = 0;
                break;
            case R.id.button4_4:
                scoreQ4 = 20;
                break;

        }
    }

    public void onCheckedQuestion3(View view) {
        checked3 = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.button3_1:
                scoreQ3 = 0;
                break;
            case R.id.button3_2:
                scoreQ3 = 0;
                break;
            case R.id.button3_3:
                scoreQ3 = 20;
                break;
            case R.id.button3_4:
                scoreQ3 = 0;
                break;
        }
    }

    public void onCheckedQuestion2(View view) {
        checked2 = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.button2_1:
                scoreQ2 = 0;
                break;
            case R.id.button2_2:
                scoreQ2 = 0;
                break;
            case R.id.button2_3:
                scoreQ2 = 20;
                break;
            case R.id.button2_4:
                scoreQ2 = 0;
                break;
        }
    }

    public void onCheckedQuestion1(View view) {
        checked1 = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.button1_1:
                scoreQ1 = 0;
                break;
            case R.id.button1_2:
                scoreQ1 = 20;
                break;
            case R.id.button1_3:
                scoreQ1 = 0;
                break;
            case R.id.button1_4:
                scoreQ1 = 0;
                break;
        }
    }

    public void onCheckedQuestion6(View view) {
        checked6 = mCheckBox1.isChecked() || mCheckBox2.isChecked() || mCheckBox3.isChecked() || mCheckBox4.isChecked();
        scoreQ6 = 0;
        if (mCheckBox1.isChecked()) {
            scoreQ6 += -10;
        }
        if (mCheckBox2.isChecked()) {
            scoreQ6 += 10;
        }
        if (mCheckBox3.isChecked()) {
            scoreQ6 += -10;
        }
        if (mCheckBox4.isChecked()) {
            scoreQ6 += 10;
        }
        if (scoreQ6 < 0) scoreQ6 = 0;
    }

    public void onClickSubmit(View view) {
        answer5 = edtForQ5.getText().toString();
        if (checked1 && checked2 && checked3 && checked4 && checked6 && !answer5.equals("")) {
            if (answer5.equals("322"))
                scoreQ5 = 20;
            else scoreQ5 = 0;

            totalscore = scoreQ1 + scoreQ2 + scoreQ3 + scoreQ4 + scoreQ5 + scoreQ6;
            String total = "Your score is " + totalscore + "/120";
            Toast.makeText(this, total, Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, getString(R.string.data_field_empty_error), Toast.LENGTH_SHORT).show();
    }
}
