package com.example.josh.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText inputBill;
    private EditText inputDiner;
    private CheckBox billSplit;
    private SeekBar tipPercent;
    private TextView tipNum;
    private TextView Tip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputBill = findViewById(R.id.inputBill);
        inputDiner = findViewById(R.id.inputDiner);
        billSplit = findViewById(R.id.SplitCheck);
        Tip = findViewById(R.id.Tip);
        tipNum = findViewById(R.id.tipNum);
        tipPercent = findViewById(R.id.seekBar);
        tipPercent.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        tipNum.setText(i+"");

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

    }
    public void buttonPressed(View v){
        String input1 = inputBill.getText().toString();
        String input2 = inputDiner.getText().toString();
        double Bill = Double.parseDouble(input1);
        double people = Double.parseDouble(input2);
        double tipP = tipPercent.getProgress();
        double result;
        if(billSplit.isChecked()){
            result = (Bill*(tipP/100))/people;
        }else{
            result = (Bill*(tipP/100));

        }
       Tip.setText(result+"");

    }
}
