package ru.mirea.yagoda.myapplication.ui.Datchik;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.mirea.yagoda.myapplication.R;
import ru.mirea.yagoda.myapplication.databinding.FragmentHomeBinding;


public class DatchikFragment extends Fragment implements SensorEventListener{
    private Activity mActivity;
    private FragmentHomeBinding binding;

    private TextView azimuthTextView;
    private TextView pitchTextView;
    private TextView rollTextView;
    private TextView pressureTextView;
    private TextView gravityTextView;

    private SensorManager sensorManager;
    private Sensor accelerometerSensor;
    private Sensor pressureSensor;
    private Sensor gravitySensor;
    private Sensor sensor;


    public DatchikFragment() {
    }

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sensorManager = (SensorManager) this.getActivity().getSystemService(Context.SENSOR_SERVICE);
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        pressureSensor =  sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        gravitySensor =  sensorManager.getDefaultSensor(Sensor.TYPE_GAME_ROTATION_VECTOR);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_datchik, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        azimuthTextView = getView().findViewById(R.id.textViewAzimuth);
        pitchTextView = getView().findViewById(R.id.textViewPitch);
        rollTextView = getView().findViewById(R.id.textViewRoll);
        pressureTextView = getView().findViewById(R.id.textViewPressure);
        gravityTextView = getView().findViewById(R.id.gravityTextView);

    }

    @Override
    public void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
    @Override
    public void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometerSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, pressureSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, gravitySensor,
                SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float valueAzimuth = event.values[0];
            float valuePitch = event.values[1];
            float valueRoll = event.values[2];
            azimuthTextView.setText("Azimuth: " + valueAzimuth);
            pitchTextView.setText("Pitch: " + valuePitch);
            rollTextView.setText("Roll: " + valueRoll);
        }
        if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD){
            float valuePressure = event.values[0];
            pressureTextView.setText("Magnetic Field: "+valuePressure);
        }
        if (event.sensor.getType() == Sensor.TYPE_GAME_ROTATION_VECTOR){
            float gravity = event.values[0];
            gravityTextView.setText("Game Rotation vector: "+ gravity);
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}