
package com.happiness.dreamx.dispatcher.parse;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Category")
public class Category extends ParseObject {
    public Category() {

    }

    public String getDescription() {
        return getString("description");
    }

    public void setDescription(String description) {
        put("description", description);
    }

    public void setName(String name) {
        put("name", name);
    }

    public String getName() {
        return getString("name");
    }
}
