package ru.mirea.yagoda.data_thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    TextView tvInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo = findViewById(R.id.textView);
        final Runnable run1 = new Runnable() {
            public void run() {
                tvInfo.setText("run1");
            }
        };
        final Runnable run2 = new Runnable() {
            public void run() {
                tvInfo.setText("run2");
            }
        };
        final Runnable run3 = new Runnable() {
            public void run() {
                tvInfo.setText("run3");
            }
        };
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    runOnUiThread(run1);
                    TimeUnit.SECONDS.sleep(1);
                    tvInfo.postDelayed(run3, 2000);
                    tvInfo.post(run2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}