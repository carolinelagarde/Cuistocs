package com.example.cuistocs;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {
    SharedPreferences sp;
    int scorefinal;
    TextView textView;

    @SuppressLint("WrongViewCast")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        SharedPreferences sp = getSharedPreferences("scoreActuel", Context.MODE_PRIVATE);
        scorefinal = sp.getInt("nombrePoint", -1);
        textView = findViewById(R.id.textViewScore);
        textView.setText("Bravo! Tu as gagné" + scorefinal + " points!");
    }
}