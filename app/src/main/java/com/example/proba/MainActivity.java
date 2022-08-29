package com.example.proba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SwitchCompat svic;
    TextView tw;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        svic = findViewById(R.id.switch3);
        tw = findViewById(R.id.tw);
        et = findViewById(R.id.edit);

        SharedPreferences sharedPreferences = getSharedPreferences("studio.project", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        svic.setChecked(sharedPreferences.getBoolean("switch", true));

        svic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                {
                    tw.setText("upaljeno");
                    editor.putBoolean("switch", true);
                    editor.apply();

                }else
                {
                    tw.setText("ugaseno");
                    editor.putBoolean("switch", false);
                    editor.apply();
                }
                editor.commit();
            }
        });
    }
}