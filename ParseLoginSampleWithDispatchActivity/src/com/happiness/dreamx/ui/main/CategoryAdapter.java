
package com.happiness.dreamx.ui.main;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.happiness.dreamx.R;
import com.happiness.dreamx.dispatcher.parse.Category;

public class CategoryAdapter extends ArrayAdapter<Category> {
    private Context mContext;
    private List<Category> mCategories;

    public CategoryAdapter(Context context, List<Category> objects) {
        super(context, R.layout.category_row_item, objects);
        this.mContext = context;
        this.mCategories = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mLayoutInflater = LayoutInflater.from(mContext);
            convertView = mLayoutInflater.inflate(R.layout.category_row_item,
                    null);
        }

        Category Category = mCategories.get(position);

        TextView categoryName = (TextView) convertView
                .findViewById(R.id.category_name);
        categoryName.setText(Category.getName());
        categoryName.setTextColor(Color.WHITE);
        return convertView;
    }

}
