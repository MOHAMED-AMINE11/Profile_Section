package ma.ensa.profile_section.utils;

import android.content.Context;
import android.content.SharedPreferences;

// 2. Créez SessionManager.java
public class SessionManager {
    private static final String PREF_NAME = "FoodRescueSession";
    private static final String KEY_USER_ID = "userId";
    private static final String KEY_USER_EMAIL = "userEmail";

    private final SharedPreferences prefs;

    public SessionManager(Context context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void saveUserSession(int userId, String email) {
        prefs.edit()
                .putInt(KEY_USER_ID, userId)
                .putString(KEY_USER_EMAIL, email)
                .apply();
    }

    public String getUserEmail() {
        return prefs.getString(KEY_USER_EMAIL, null);
    }
}
