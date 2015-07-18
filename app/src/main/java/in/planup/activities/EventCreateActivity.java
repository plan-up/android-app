package in.planup.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.inject.Inject;

import in.planup.R;
import in.planup.adapters.AddFriendsListAdapter;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_event_create)
public class EventCreateActivity extends RoboActivity {

    static final int PICK_CONTACT = 1;

    @InjectView(R.id.create_event_add_friends)
    private Button createEventAddFriends;

    @InjectView(R.id.create_event_friends_list)
    private ListView friendsList;

    @InjectView(R.id.create_event)
    private Button createEvent;

    @Inject
    private Context context;

    private AddFriendsListAdapter friends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        friends = new AddFriendsListAdapter(context);
        friends.setNotifyOnChange(true);
        friendsList.setAdapter(friends);

        createEventAddFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent, PICK_CONTACT);
            }
        });

        createEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEvent();
            }
        });
    }

    @Override
    public void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);

        switch (reqCode) {
            case (PICK_CONTACT):
                if (resultCode == Activity.RESULT_OK) {
                    Uri contactData = data.getData();
                    Log.d("CREATE", contactData.toString());
//                  friends.add(new FriendInvite(name, mobile));
//                  friends.notifyDataSetChanged();
                }

                break;
        }
    }

    private void createEvent() {
        int id = 4;

        Intent intent = new Intent(context, EventDashboardActivity.class);
        intent.putExtra("eventId", id);
        startActivity(intent);
    }

}
