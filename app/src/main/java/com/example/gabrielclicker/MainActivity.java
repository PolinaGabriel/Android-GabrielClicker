package com.example.gabrielclicker;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView mainText;
    ImageButton plusBtn;
    ImageButton minusBtn;
    ImageButton zeroBtn;
    pl.droidsonroids.gif.GifImageView explosion;
    private int score = 0;
    private String s = score + " нажатий";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainText = findViewById(R.id.mainTxt);
        plusBtn = findViewById(R.id.plus_btn);
        minusBtn = findViewById(R.id.minus_btn);
        zeroBtn = findViewById(R.id.zero_btn);
        explosion = findViewById(R.id.expl);

        View.OnClickListener clicks = new View.OnClickListener() {
            @Override
            //Увеличение или уменьшение счёта (слово "нажатий" склоняется)
            public void onClick(View v) {
                if (v.equals(plusBtn)) {
                    score++;
                } else if (v.equals(minusBtn)) {
                    score--;
                }

                if (score % 10 == 0) {
                    explosion.setVisibility(View.VISIBLE);
                } else {
                    explosion.setVisibility(View.INVISIBLE);
                }

                String strScore = String.valueOf(score);
                if (strScore.length() >= 2 && strScore.charAt(strScore.length() - 2) == '1') {
                    s = score + " нажатий";
                } else {
                    switch (strScore.substring(strScore.length() - 1)) {
                        case "0":
                        case "5":
                        case "6":
                        case "7":
                        case "8":
                        case "9":
                            s = score + " нажатий";
                            break;
                        case "1":
                            s = score + " нажатие";
                            break;
                        case "2":
                        case "3":
                        case "4":
                            s = score + " нажатия";
                            break;
                    }
                }
                mainText.setText(s.toCharArray(), 0, s.length());
            }
        };
        plusBtn.setOnClickListener(clicks);
        minusBtn.setOnClickListener(clicks);

        View.OnClickListener zero = new View.OnClickListener() {
            @Override
            //Сброс счётчика
            public void onClick(View v) {
                score = 0;
                String s = score + " нажатий";
                mainText.setText(s.toCharArray(), 0, s.length());
            }
        };
        zeroBtn.setOnClickListener(zero);
    }
}