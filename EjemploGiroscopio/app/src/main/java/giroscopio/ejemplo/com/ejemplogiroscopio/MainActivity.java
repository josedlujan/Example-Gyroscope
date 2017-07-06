package giroscopio.ejemplo.com.ejemplogiroscopio;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.renderscript.Float2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    TextView gx,gy,gz;
    SensorManager sm;
    Sensor gyr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gx = (TextView) findViewById(R.id.gx);
        gy = (TextView) findViewById(R.id.gy);
        gz = (TextView) findViewById(R.id.gz);

        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        gyr = sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        sm.registerListener(this,gyr,SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType() == Sensor.TYPE_GYROSCOPE){
            gx.setText(Float.toString(sensorEvent.values[0]));
            gy.setText(Float.toString(sensorEvent.values[1]));
            gz.setText(Float.toString(sensorEvent.values[2]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
