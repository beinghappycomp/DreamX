
package com.happiness.dreamx.ui.main;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.happiness.dreamx.R;
import com.happiness.dreamx.dispatcher.parse.Category;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

public class CategoryList extends Activity implements OnItemClickListener{

    private ListView mListView;
    private CategoryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_layout);

        mAdapter = new CategoryAdapter(this, new ArrayList<Category>());
        mListView = (ListView) findViewById(R.id.category_list);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);
        updateData();
    }

    public void updateData() {
        ParseQuery<Category> query = ParseQuery.getQuery(Category.class);
        query.findInBackground(new FindCallback<Category>() {
            @Override
            public void done(List<Category> Categories, ParseException error) {
                if (Categories != null) {
                    mAdapter.clear();
                    for (int i = 0; i < Categories.size(); i++) {
                        mAdapter.add(Categories.get(i));
                    }
                }
            }
        });
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
        Intent intent = new Intent();
        intent.putExtra("category_id", ((Category)mAdapter.getItem(position)).getObjectId());
        intent.setClass(CategoryList.this, SetGoalScreen.class);
        startActivity(intent);
    }

}
