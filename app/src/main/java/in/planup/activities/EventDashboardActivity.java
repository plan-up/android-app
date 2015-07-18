package in.planup.activities;

import android.os.Bundle;

import in.planup.R;
import roboguice.activity.RoboActionBarActivity;
import roboguice.inject.ContentView;

@ContentView(R.layout.activity_event_dashboard)
public class EventDashboardActivity extends RoboActionBarActivity {

    private int eventId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();

        eventId = getIntent().getExtras().getInt("eventId");
        setTitle(eventId);
    }
}
