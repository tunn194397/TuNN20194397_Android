package com.example.bai2_form;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener, CalendarView.OnDateChangeListener {

    EditText studentId;
    EditText name;
    EditText identification;
    EditText phone;
    EditText email;
    TextView birthdayTextView;
    CalendarView birthdayCalenderView;
    CheckBox confirmCheckBox;
    Button submitButton;

    private static final String TAG = "MyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViewVariables();
        setOnClickListeners();
        setOnTouchListener();
        birthdayCalenderView.setOnDateChangeListener(this);
    }
    private void initializeViewVariables() {
        studentId = (EditText) findViewById(R.id.student_id_edit_text);
        name = (EditText) findViewById(R.id.name_edit_text);
        identification = (EditText) findViewById(R.id.id_edit_text);
        phone = (EditText) findViewById(R.id.phone_edit_text);
        email = (EditText) findViewById(R.id.email_edit_text);

        birthdayTextView = (TextView) findViewById(R.id.birthday_text_view);
        birthdayCalenderView = (CalendarView) findViewById(R.id.calender_view);
        confirmCheckBox = (CheckBox) findViewById(R.id.confirmCheckbox);
        submitButton = (Button) findViewById(R.id.submit_button);

    }

    private void setOnClickListeners() {
        submitButton.setOnClickListener(this);
        birthdayCalenderView.setOnClickListener(this);
    }

    private void setOnTouchListener() {
        submitButton.setOnTouchListener(this);
    }

    @Override
    public void onClick(View view) {
        Log.d(TAG, "onclick");
        switch (view.getId())
        {
            case R.id.submit_button:
                Log.d(TAG, "on Click -> submit_button");
                submit();
                break;
            case R.id.confirmCheckbox:
                break;
        }

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction())
        {
            case MotionEvent.ACTION_DOWN:
            {
                view.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP);
                view.invalidate();
                break;
            }
            case MotionEvent.ACTION_UP:
            {
                view.getBackground().clearColorFilter();
                view.invalidate();
                break;
            }
        }
        return false;
    }

    @Override
    public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
        String s= "";
        s += ((i2 < 10)?"0"+i2: i2) + "/" + ((i1 < 10)?"0"+i1: i1) + "/" + i;
        birthdayTextView.setText("Birthday:    " + s);

    }

    public void submit() {
        String s = confirmCheckBox.isChecked()+"";
        Log.d(TAG, "submit: "+s);
        if (!confirmCheckBox.isChecked()) {
            Toast.makeText(getApplicationContext(), "Need to confirm first", Toast.LENGTH_SHORT).show();
        }
        else {
            Log.d(TAG, "submit: "+ canSubmit());
            if (canSubmit().equals("oke")) {
                Toast.makeText(getApplicationContext(), "Submit successfully!", Toast.LENGTH_SHORT).show();
            }
            else Toast.makeText(getApplicationContext(), "Error " + canSubmit() + "fill them!", Toast.LENGTH_SHORT).show();
        }
    }

    public String canSubmit() {
        String ans = "";
        if (studentId.getText().toString().equals("")) {
            ans+= "student id, ";
        }
        if (name.getText().toString().equals("")) {
            ans+= "name, ";
        }
        if (identification.getText().toString().equals("")) {
            ans+= "identification, ";
        }
        if (phone.getText().toString().equals("")) {
            ans +=  "phone number, ";
        }
        if (email.getText().toString().equals("")) {
            ans+= "email address, ";
        }
        if (ans.equals("")) return "oke";
        else return ans;
    }

}