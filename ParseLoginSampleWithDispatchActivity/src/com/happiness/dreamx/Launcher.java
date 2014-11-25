package com.happiness.dreamx;

import android.app.Activity;
import android.os.Bundle;

/**
 * @author vishal
 */
public class Launcher extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // this.startActivity(new Intent(this, MainActivity.class));
//         this.startActivity(new Intent(this, ParseLoginActivity.class));
      //  this.startActivity(new Intent(this, Login.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    };
}
