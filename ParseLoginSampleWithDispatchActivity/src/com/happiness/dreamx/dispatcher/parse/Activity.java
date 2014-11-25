
package com.happiness.dreamx.dispatcher.parse;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Activity")
public class Activity extends ParseObject {
    public Activity() {

    }

    public String getDescription() {
        return getString("description");
    }

    public void setBuddy(String buddyId) {
        put("buddyId", buddyId);
    }

    public void setPersonalChallenge(String name) {
        put("personalChallenge", name);
    }

    public String getName() {
        return getString("name");
    }

    public void setCategoryId(String mCategoryId) {
        put("categoryId", mCategoryId);
    }

    public void setUserId(String objectId) {
        put("userId", objectId);
    }


}
