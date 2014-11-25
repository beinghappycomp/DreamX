
package com.happiness.dreamx.ui.main;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.happiness.dreamx.R;
import com.happiness.dreamx.dispatcher.parse.Category;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

public class SetGoalScreen extends Activity {
    TextView mCategoryName;
    TextView mCategoryDescription;
    EditText mPersonalChallenge;
    Button mBringItOn;
    String mCategoryId;
    Spinner mSnooze;
    Spinner mChallengeDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCategoryId = getIntent().getStringExtra("category_id");
        setContentView(R.layout.set_goal_screen);

        mCategoryName = (TextView) findViewById(R.id.category);
        mPersonalChallenge = (EditText) findViewById(R.id.challenge_description_enter);
        mSnooze = (Spinner) findViewById(R.id.snooze);
        mChallengeDay = (Spinner) findViewById(R.id.challege_day);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.snooze_options, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.challenge_options, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        mSnooze.setAdapter(adapter);
        mChallengeDay.setAdapter(adapter1);
        mCategoryDescription = (TextView) findViewById(R.id.category_description);
        mBringItOn = (Button) findViewById(R.id.bringiton);
        ParseQuery<Category> query = ParseQuery.getQuery(Category.class);
        query.whereEqualTo("objectId", mCategoryId);
        query.findInBackground(new FindCallback<Category>() {
            @Override
            public void done(List<Category> Categories, ParseException error) {
                if (Categories != null) {
                    for (int i = 0; i < Categories.size(); i++) {
                        Category category = Categories.get(i);
                        mCategoryName.setText(category.getName());
                        mCategoryDescription.setText(category.getDescription());
                    }
                }
            }
        });
        mBringItOn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                com.happiness.dreamx.dispatcher.parse.Activity activity = new com.happiness.dreamx.dispatcher.parse.Activity();
                activity.setUserId(ParseUser.getCurrentUser().getObjectId());
                activity.setCategoryId(mCategoryId);
                activity.setPersonalChallenge(mPersonalChallenge.getText().toString());
                activity.saveInBackground();
                Intent intent = new Intent();
                intent.setClass(SetGoalScreen.this, SetBuddyScreen.class);
                startActivity(intent);
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
