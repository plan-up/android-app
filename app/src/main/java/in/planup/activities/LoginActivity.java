package in.planup.activities;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.inject.Inject;

import in.planup.R;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_login)
public class LoginActivity extends RoboActivity {

    @InjectView(R.id.loginMobile)
    private EditText loginMobile;

    @InjectView(R.id.loginSubmit)
    private Button loginSubmit;

    @Inject
    private LocationManager locationManager;

    @Inject
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("LOGIN", loginMobile.getText().toString());
//              Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//              Log.i("LOGIN", "Latitude: " + location.getLatitude());
//              Log.i("LOGIN", "Longitude: " + location.getLongitude());
                Intent intent = new Intent(context, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
