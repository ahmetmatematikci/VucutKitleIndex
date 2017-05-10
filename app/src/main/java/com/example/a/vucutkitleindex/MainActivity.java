package com.example.a.vucutkitleindex;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et;
    TextView boy_tv, durum_tv, ideal_tv, kilo_tv;
    SeekBar seekBar;
    RadioGroup radioGroup;
    RadioButton rBay, rBayan;
    boolean erkekMi =true;
    double boy = 0.0;
    int kilo = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et  = (EditText)findViewById(R.id.boy_et);
        boy_tv = (TextView)findViewById(R.id.boy_tv);
        durum_tv = (TextView)findViewById(R.id.durum_tv);
        ideal_tv = (TextView)findViewById(R.id.ideal_tv);
        kilo_tv = (TextView)findViewById(R.id.kilo_tv);
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        radioGroup = (RadioGroup)findViewById(R.id.radioGrup);
        rBay =(RadioButton)findViewById(R.id.radioBay);
        rBayan =(RadioButton)findViewById(R.id.radioBayan);

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    boy = Double.parseDouble(s.toString())/100.0;
                }catch (NumberFormatException e) {
                    e.printStackTrace();
                    boy =0.0;
                }
                guncelle();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                kilo = 30 + progress;
                guncelle();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (checkedId == R.id.radioBay) {
                    erkekMi = true;
                } else if(checkedId == R.id.radioBayan) {
                    erkekMi = false;
                }
                guncelle();
            }
        });

        guncelle();

    }

    private void guncelle() {
        kilo_tv.setText(String.valueOf(kilo) + " kg");
        boy_tv.setText(String.valueOf(boy) + " m");
        int ideal_kiloBay = (int) (50 + 2.3*(boy*100*0.4 - 60 ));
        int ideal_kiloBayan = (int) (45.5 + 2.3*(boy*100*0.4 - 60 ));
        double vki = kilo/(boy*boy);

        if (erkekMi) {
            ideal_tv.setText(String.valueOf(ideal_kiloBay));
            if (vki<=20.7){
                durum_tv.setBackgroundResource(R.color.zayif);
                durum_tv.setText(R.string.zayif);
            }else if (20.7<vki && vki <= 26.4){
                //ideal kilo
                durum_tv.setText(R.string.ideal);
                durum_tv.setBackgroundResource(R.color.durum_ideal);

            }else if (26.4<vki && vki <= 27.8){
                //normal kilodan fazla
                durum_tv.setText(R.string.normalden_fazla);
                durum_tv.setBackgroundResource(R.color.durum_idealden_fazla);

            }else if (27.8<vki && vki <= 31.1){
                // fazla kilolu
                durum_tv.setText(R.string.fazla_kilolu);
                durum_tv.setBackgroundResource(R.color.durum_fazla_kilolu);

            }else if (31.1<vki && vki <= 34.9){
                // obez
                durum_tv.setText(R.string.obez);
                durum_tv.setBackgroundResource(R.color.durum_obez);
            }else{
                //doktor tedavisi
                durum_tv.setText(R.string.doktora);
                durum_tv.setBackgroundResource(R.color.durum_doktora);

            }



        }else {
            ideal_tv.setText(String.valueOf(ideal_kiloBayan));
            if (vki <= 19.1){
                // zayıf
                durum_tv.setText(R.string.zayif);
                durum_tv.setBackgroundResource(R.color.zayif);

            }else if (19.1<vki && vki <= 25.8){
                //ideal kilo
                durum_tv.setText(R.string.ideal);
                durum_tv.setBackgroundResource(R.color.durum_ideal);

            }else if (25.8<vki && vki <= 27.3){
                //normal kilodan fazla
                durum_tv.setText(R.string.normalden_fazla);
                durum_tv.setBackgroundResource(R.color.durum_idealden_fazla);
            }else if (27.3<vki && vki <= 32.3){
                // fazla kilolu
                durum_tv.setText(R.string.fazla_kilolu);
                durum_tv.setBackgroundResource(R.color.durum_fazla_kilolu);

            }else if (32.3<vki && vki <= 34.9){
                // obez
                durum_tv.setText(R.string.obez);
                durum_tv.setBackgroundResource(R.color.durum_obez);
            }else{
                //doktor tedavisi
                durum_tv.setText(R.string.doktora);
                durum_tv.setBackgroundResource(R.color.durum_doktora);

            }

        }
    }
}
