package com.example.tsp7calculator;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

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

        display.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");

                }
            }
        });
    }

    private void updateText(String strToAdd){
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
            display.setSelection(cursorPos + 1);
        } else{
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + strToAdd.length());
        }
    }

    public void zeroBTN(View view){
        updateText("0");
    }
    public void oneBTN(View view){
         updateText("1");
    }
    public void twoBTN(View view){
        updateText("2");
    }
    public void threeBTN(View view){
        updateText("3");
    }
    public void fourBTN(View view){
        updateText("4");
    }
    public void fiveBTN(View view){
        updateText("5");
    }
    public void sixBTN(View view){
        updateText("6");
    }
    public void sevenBTN(View view){
        updateText("7");
    }
    public void eightBTN(View view){
        updateText("8");
    }
    public void nineBTN(View view){
        updateText("9");
    }
    public void addBTN(View view){
        updateText("+");
    }
    public void subBTN(View view){
        updateText("-");
    }
    public void divideBTN(View view){
        updateText("/");
    }
    public void mulBTN(View view){ updateText("*"); }
    public void negateBTN(View view){ updateText("-"); }
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
            updateText("(");
            display.setSelection(cursorPos + 1);
        }

        else if (closePar < openPar && !display.getText().toString().substring(textLen-1, textLen).equals("(")){
            updateText(")");
            display.setSelection(cursorPos + 1);
        }
    }
    public void equalsBTN(View view){
        String userExp = display.getText().toString();
        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

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
        updateText("sin(");
    }

    public void trigCosBTN(View view) {
        updateText("cos(");
    }

    public void trigTanBTN(View view) {
        updateText("tan(");
    }

    public void trigInsinBTN(View view) {
        updateText("arcsin(");
    }

    public void trigIncosBTN(View view) {
        updateText("arccos(");
    }

    public void trigIntanBTN(View view) {
        updateText("arctan(");
    }

    public void trigLogBTN(View view) {
        updateText("log(");
    }

    public void trigLnBTN(View view) {
        updateText("ln(");
    }

    public void trigSqrtBTN(View view) {
        updateText("sqrt(");
    }

    public void trigEBTN(View view) {
        updateText("pi");
    }

    public void trigPiBTN(View view) {
        updateText("e");
    }

    public void trigAbsvalBTN(View view) {
        updateText("abs(");
    }
    public void expBTN(View view){
        updateText("^(");
    }
    public void decimalBTN(View view){
        updateText(".");
    }
}