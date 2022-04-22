package com.example.tsp7calculator;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Color;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    //Button to move to other screen
    private Button move;

    private EditText display;
    private TextView prevCalc;
    boolean equals = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        prevCalc = findViewById(R.id.textView);
        display = findViewById(R.id.output);
        display.setShowSoftInputOnFocus(false);


        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.display).equals(display.getText().toString())) {
                    display.setText("");

                }
            }
        });




        //Setting the move button to the button data
//        move=findViewById(R.id.Move);
//        //Creating the on click listener
//        move.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Changing the screen to the data screen
//                Intent intent = new Intent(MainActivity.this,data.class);
//                startActivity(intent);
//            }
//        });
    }

    private void updateText(String strToAdd, int strLen){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        if(equals) {
            equals = false;
            prevCalc.setText(oldStr);
        }
        if (getString(R.string.display).equals(display.getText().toString())) {
            display.setText(strToAdd);
            display.setSelection(cursorPos + strLen);
        } else{
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + strToAdd.length());
        }
    }

    public void zeroBTN(View view){
        updateText("0", 1);
    }
    public void oneBTN(View view){
         updateText("1", 1);
    }
    public void twoBTN(View view){
        updateText("2", 1);
    }
    public void threeBTN(View view){
        updateText("3", 1);
    }
    public void fourBTN(View view){
        updateText("4", 1);
    }
    public void fiveBTN(View view){
        updateText("5", 1);
    }
    public void sixBTN(View view){
        updateText("6", 1);
    }
    public void sevenBTN(View view){
        updateText("7", 1);
    }
    public void eightBTN(View view){
        updateText("8", 1);
    }
    public void nineBTN(View view){
        updateText("9", 1);
    }
    public void addBTN(View view){
        updateText("+", 1);
    }
    public void subBTN(View view){
        updateText("-", 1);
    }
    public void divideBTN(View view){
        updateText("/", 1);
    }
    public void mulBTN(View view){ updateText("*", 1); }
    public void negateBTN(View view){ updateText("-", 1); }
    public void clearBTN(View view){ display.setText(""); }
    public void parenBTN(View view){
        int cursorPos = display.getSelectionStart();
        int openPar = 0;
        int closePar = 0;
        int textLen = display.getText().length();

        for (int i = 0; i < cursorPos; i++){
            if (display.getText().toString().substring(i, i+1).equals("(")){
                openPar += 1;
            }
            if (display.getText().toString().substring(i, i+1).equals(")")){
                closePar += 1;
            }


        }

        if (openPar == closePar || display.getText().toString().substring(textLen-1, textLen).equals("(")){
            updateText("(", 1);
            display.setSelection(cursorPos + 1);
        }

        else if (closePar < openPar && !display.getText().toString().substring(textLen-1, textLen).equals("(")){
            updateText(")", 1);
            display.setSelection(cursorPos + 1);
        }
    }
    public void equalsBTN(View view){
        String userExp = display.getText().toString();
        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        int decPt = -1;
        int sciNot = -1;

        //Searching for scientific notation and decimal point
        for (int i = 0; i < result.length(); i++){
            if (Character.compare(result.charAt(i), '.') == 0){
                decPt = i;
            }

            if (Character.compare(result.charAt(i), 'E') == 0){
                sciNot = i; //Scientific notation implies there was already a decimal,
                break;      //which is why we only break here

            }

        }



        //Incurring decimal cap, accounting for scientific notation
        if (decPt != -1) {
            //if there is scientific notation
            if (sciNot != -1) {
                //If there enough decimal places that some need to be removed (ie: 3.2222222E10)
                if (sciNot - decPt > 5) {
                    result = result.substring(0, decPt + 5) + result.substring(sciNot, result.length());
                }
                //If there are not enough decimal places to be removed without messing
                //with the scientific notation (ie: 3.2222E10), the string will be left alone
            }
            //iIf there is not scientific notation, but still a decimal pt
            else{
                result = result.substring(0, decPt + 5);
            }
        }

        equals = true;
        prevCalc.setText(userExp);
        display.setText(result);
        display.setSelection(result.length());
    }
    public void delBTN(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);

        }
    }

    public void trigSinBTN(View view) {
        updateText("sin(",4);
    }

    public void trigCosBTN(View view) {
        updateText("cos(",4);
    }

    public void trigTanBTN(View view) {
        updateText("tan(",4);
    }

    public void trigInsinBTN(View view) {
        updateText("arcsin(",7);
    }

    public void trigIncosBTN(View view) {
        updateText("arccos(",7);
    }

    public void trigIntanBTN(View view) {
        updateText("arctan(",7);
    }

    public void trigLogBTN(View view) {
        updateText("log(",4);
    }

    public void trigLnBTN(View view) {
        updateText("ln(",3);
    }

    public void trigSqrtBTN(View view) {
        updateText("sqrt(",5);
    }

    public void trigEBTN(View view) {
        updateText("e",1);
    }

    public void trigPiBTN(View view) {
        updateText("pi",2);
    }

    public void trigAbsvalBTN(View view) {
        updateText("abs(",4);
    }
    public void expBTN(View view){
        updateText("^(",2);
    }
    public void decimalBTN(View view){
        updateText(".",1);
    }
}