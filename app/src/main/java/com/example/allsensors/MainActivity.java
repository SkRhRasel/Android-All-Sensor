package com.example.allsensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private static final String TAG = "MainActivity";
    private SensorManager sensorManager;
    Sensor sAccelerometer, sGyroscope, sMagnetometer, sLight, sPressure, sTemperature, sHumdity;

    TextView xValue, yValue, zValue, xGyroValue, yGyroValue, zGyroValue, xMagnoValue, yMagnoValue, zMagnoValue, light, pressure, temperature, humidity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xValue = findViewById(R.id.xValue);
        yValue = findViewById(R.id.yValue);
        zValue = findViewById(R.id.zValue);

        xGyroValue = findViewById(R.id.xGyroValue);
        yGyroValue = findViewById(R.id.yGyroValue);
        zGyroValue = findViewById(R.id.zGyroValue);

        xMagnoValue = findViewById(R.id.xMagnoValue);
        yMagnoValue = findViewById(R.id.yMagnoValue);
        zMagnoValue = findViewById(R.id.zMagnoValue);

        light = findViewById(R.id.light);
        pressure = findViewById(R.id.pressure);
        temperature = findViewById(R.id.temperature);
        humidity = findViewById(R.id.humidity);


        Log.d(TAG, "onCreate: Initializing Sensor Services");

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        sAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (sAccelerometer != null) {
            sensorManager.registerListener(MainActivity.this, sAccelerometer, sensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Accelerometer Listener");
        } else {
            xValue.setText("Accelermeter Not Supported");
            yValue.setText("Accelermeter Not Supported");
            zValue.setText("Accelermeter Not Supported");
        }

        sGyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if (sGyroscope != null) {
            sensorManager.registerListener(MainActivity.this, sGyroscope, sensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Gyroscope Listener");
        } else {
            xGyroValue.setText("Gyroscope Not Supported");
            yGyroValue.setText("Gyroscope Not Supported");
            zGyroValue.setText("Gyroscope Not Supported");
        }

        sMagnetometer = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        if (sMagnetometer != null) {
            sensorManager.registerListener(MainActivity.this, sMagnetometer, sensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Magnetometer Listener");
        } else {
            xMagnoValue.setText("Magnetometer Not Supported");
            yMagnoValue.setText("Magnetometer Not Supported");
            zMagnoValue.setText("Magnetometer Not Supported");
        }

        sLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if (sLight != null) {
            sensorManager.registerListener(MainActivity.this, sLight, sensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Light Listener");
        } else {
            light.setText("Light Not Supported");
        }

        sPressure = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        if (sPressure != null) {
            sensorManager.registerListener(MainActivity.this, sPressure, sensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Pressure Listener");
        } else {
            pressure.setText("Pressure Not Supported");
        }

        sTemperature = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if (sTemperature != null) {
            sensorManager.registerListener(MainActivity.this, sTemperature, sensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Temperature Listener");
        } else {
            temperature.setText("Temperature Not Supported");
        }

        sHumdity = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        if (sHumdity != null) {
            sensorManager.registerListener(MainActivity.this, sHumdity, sensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Humdity Listener");
        } else {
            humidity.setText("Humdity Not Supported");
        }


    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor = sensorEvent.sensor;
        if (sensor.getType()==Sensor.TYPE_ACCELEROMETER){
            Log.d(TAG, "OnSensorChanged: X: " + sensorEvent.values[0] + "Y: " + sensorEvent.values[1] + "Z: " + sensorEvent.values[2]);
            xValue.setText("xValue: " + sensorEvent.values[0]);
            yValue.setText("yValue: " + sensorEvent.values[1]);
            zValue.setText("zValue: " + sensorEvent.values[2]);
        }else if(sensor.getType()==Sensor.TYPE_GYROSCOPE){
            xGyroValue.setText("xGyroValue: " + sensorEvent.values[0]);
            yGyroValue.setText("yGyroValue: " + sensorEvent.values[1]);
            zGyroValue.setText("zGyroValue: " + sensorEvent.values[2]);
        }else if(sensor.getType()==Sensor.TYPE_MAGNETIC_FIELD){
            xMagnoValue.setText("xMagnoValue: " + sensorEvent.values[0]);
            yMagnoValue.setText("yMagnoValue: " + sensorEvent.values[1]);
            zMagnoValue.setText("zMagnoValue: " + sensorEvent.values[2]);
        }else if(sensor.getType()==Sensor.TYPE_LIGHT){
            light.setText("Light: "+sensorEvent.values[0]);
        }else if(sensor.getType()==Sensor.TYPE_PRESSURE){
            pressure.setText("Pressure: "+sensorEvent.values[0]);
        }else if(sensor.getType()==Sensor.TYPE_AMBIENT_TEMPERATURE){
            temperature.setText("Temperature: "+sensorEvent.values[0]);
        }else if(sensor.getType()==Sensor.TYPE_LIGHT){
            humidity.setText("Light: "+sensorEvent.values[0]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
