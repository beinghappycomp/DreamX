package com.happiness.dreamx.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class PostLoginController extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, com.happiness.dreamx.dispatcher.parse.Activity.class));
    }

    protected void onDestroy() {
    };
}
