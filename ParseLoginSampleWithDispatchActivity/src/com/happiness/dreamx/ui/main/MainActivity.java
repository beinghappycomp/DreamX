
package com.happiness.dreamx.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.happiness.dreamx.R;
import com.parse.ParseUser;

public class MainActivity extends Activity {
    TextView mWelcomeText;
    Button mGetStartedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWelcomeText = (TextView) findViewById(R.id.welcome);
        mGetStartedButton = (Button) findViewById(R.id.getstarted);
        mWelcomeText.setText(getString(R.string.welcome) + " "
                + ParseUser.getCurrentUser().getUsername());
        mGetStartedButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, CategoryList.class);
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
