package com.example.gpa_almutairii1_calculator;

import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView displayLabel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayLabel=(TextView) findViewById(R.id.displayGPA);
    }
    public void CalculateGPA(View view){
        Button calculatebutton = (Button)findViewById(R.id.computebutton);
        if(calculatebutton.getText()=="Clearform"){
            finish();
            startActivity(getIntent());
        }
        else calculatebutton.setText("Clearform");

        final EditText sub1=(EditText)findViewById(R.id.editText2);
        final EditText sub2=(EditText)findViewById(R.id.editText3);
        final EditText sub3=(EditText)findViewById(R.id.editText4);
        final EditText sub4=(EditText)findViewById(R.id.editText5);
        final EditText sub5=(EditText)findViewById(R.id.editText6);
        int calgpa1=Integer.parseInt(sub1.getText().toString());
        int calgpa2=Integer.parseInt(sub2.getText().toString());
        int calgpa3=Integer.parseInt(sub3.getText().toString());
        int calgpa4=Integer.parseInt(sub4.getText().toString());
        int calgpa5=Integer.parseInt(sub5.getText().toString());
        int gpa=-1;
        gpa=(calgpa1+calgpa2+calgpa3+calgpa4+calgpa5)/5;
        displayLabel.setText("Your total gpa is "+ gpa);
        RelativeLayout main=(RelativeLayout)findViewById(R.id.container);
        if(gpa!=-1) {
            if (gpa < 60 && gpa >= 0) {
                main.setBackgroundColor(Color.RED);
            }
            if (gpa > 60 && gpa < 80) {
                main.setBackgroundColor(Color.YELLOW);
            }
            if (gpa > 80) {
                main.setBackgroundColor(Color.GREEN);

            }
        }else
            Toast.makeText(MainActivity.this,"Grades are not correct", Toast.LENGTH_SHORT).show();

    }
}