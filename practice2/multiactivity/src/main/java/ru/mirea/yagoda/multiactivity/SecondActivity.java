package ru.mirea.yagoda.multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        textView = (TextView) findViewById(R.id.textView2);

        Intent intent = getIntent();

        String text = (String) getIntent().getSerializableExtra("key");

        textView.setText(text);
    }
}