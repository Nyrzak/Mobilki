package ru.mirea.yagoda.lifecycleactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();Log.i(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();Log.i(TAG,"onDestroy()");
    }

    @Override
    protected void onPause() {
        super.onPause();Log.i(TAG,"onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();Log.i(TAG,"onResume()");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);Log.i(TAG,"onStart()");
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();Log.i(TAG,"onAttachedToWindow()");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);Log.i(TAG,"onSaveInstanceState()");
    }
}