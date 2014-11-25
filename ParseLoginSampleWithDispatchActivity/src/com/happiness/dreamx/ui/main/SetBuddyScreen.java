
package com.happiness.dreamx.ui.main;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.happiness.dreamx.R;
import com.happiness.dreamx.dispatcher.parse.User;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

public class SetBuddyScreen extends Activity {
    TextView mBuddyName;
    Button mFindBuddy;
    Button mSetBuddy;
    Button mImBestFriend;
    String mActivityId;
    ParseUser mBuddy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityId = getIntent().getStringExtra("activity_id");
        setContentView(R.layout.set_buddy_screen);

        mBuddyName = (TextView) findViewById(R.id.buddy_name);
        mFindBuddy = (Button) findViewById(R.id.find_buddy);
        mSetBuddy = (Button) findViewById(R.id.set_buddy);
        mImBestFriend = (Button) findViewById(R.id.i_am_good);
        mImBestFriend.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                mFindBuddy.setVisibility(View.GONE);

            }
        });
        mSetBuddy.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                ParseQuery<com.happiness.dreamx.dispatcher.parse.Activity> query = ParseQuery
                        .getQuery(com.happiness.dreamx.dispatcher.parse.Activity.class);
                query.getInBackground(mActivityId,
                        new GetCallback<com.happiness.dreamx.dispatcher.parse.Activity>() {
                            public void done(com.happiness.dreamx.dispatcher.parse.Activity object,
                                    ParseException e) {
                                if (e == null) {
                                    com.happiness.dreamx.dispatcher.parse.Activity activity = (com.happiness.dreamx.dispatcher.parse.Activity) object;
                                    activity.setBuddy(mBuddy.getObjectId());
                                    activity.saveInBackground();
                                }
                            }
                        });
            }
        });

        mFindBuddy.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                findBuddy();
            }
        });

    }

    // TODO: This should move in #cloudcode
    private void findBuddy() {
        ParseQuery<User> query = ParseQuery.getQuery(User.class);
        query.whereContains("username", "vishal");
        query.findInBackground(new FindCallback<User>() {
            @Override
            public void done(List<User> users, ParseException error) {
                if (users != null) {
                    for (int i = 0; i < users.size(); i++) {
                        mBuddy = users.get(i);
                        mBuddyName.setText(mBuddy.getUsername());
                        mBuddyName.setVisibility(View.VISIBLE);
                        mSetBuddy.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
