package com.example.pierwszeradio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Pytanie> pytania = new ArrayList<>();
    private TextView textView;
    private RadioButton [] radioButtons = new RadioButton[3];
    private Button buttonSprawdz;
    private RadioGroup radioGroup;
    private Button buttonDalej;
    int strona;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pytania.add(new Pytanie("Na jakim systemie operacyjnym Android?", "Windows", "Dos", "Linux", 2));
        pytania.add(new Pytanie("Nazwa wersji androida to często?","Ciasteczko", "Owoc", "Warzywo",0));
        pytania.add(new Pytanie("Językiem rekomendowanym do pisania aplikacji na androida przez Google?", "Java", "Kotlin","C++", 1));

        textView = findViewById(R.id.textView);
        radioButtons[0] = findViewById(R.id.radioButton1);
        radioButtons[1] = findViewById(R.id.radioButton2);
        radioButtons[2] = findViewById(R.id.radioButton3);
        buttonDalej = findViewById(R.id.buttonDalej);
        buttonSprawdz = findViewById(R.id.buttonSprawd);
        buttonSprawdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int idZaznaczone = radioGroup.getCheckedRadioButtonId();
                for (int i = 0; i < radioButtons.length; i++) {
                   if(radioButtons[i].getId()==idZaznaczone){
                        pytania.get(strona).sprawdzOdpowiedz(i);
                        if(pytania.get(strona).isCzyUdzielonoPoprawnejOdpowiedzi()){
                            Toast.makeText(MainActivity.this, "Udzielono dobrej odpowiedzi", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, "Udzielono złej odpowiedzi!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
        radioGroup = findViewById(R.id.radioGrupa);
        wyswietlPytanie(0);
        buttonDalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strona++;
                if(strona ==  pytania.size()){
                    buttonDalej.setVisibility(View.INVISIBLE);
                    strona--;
                }
                wyswietlPytanie(strona);
            }
        });
    }
    private void wyswietlPytanie(int i){
    textView.setText(pytania.get(i).getTrescPytania());
        for (int j = 0; j < radioButtons.length; j++) {
            radioButtons[j].setText(pytania.get(i).getOdpowiedzi()[j]);
        }
    }
}