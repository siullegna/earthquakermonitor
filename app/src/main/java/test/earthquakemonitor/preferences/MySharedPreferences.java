package test.earthquakemonitor.preferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by root on 2/7/15.
 */
public class MySharedPreferences {
    // ===========================================================
    // Constants
    // ===========================================================
    private final String SHARED_PREFERENCES = "test.earthquakemonitor";
    // ===========================================================
    // Fields
    // ===========================================================
    private SharedPreferences sPreferences;
    private SharedPreferences.Editor spEditor;

    // ===========================================================
    // Constructors
    // ===========================================================
    public MySharedPreferences(Context context) {
        sPreferences = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
        spEditor = sPreferences.edit();
    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================
    public void putString(String key, String defValue) {
        spEditor.putString(key, defValue);
        spEditor.commit();
    }

    public String getString(String key, String defValue) {
        return sPreferences.getString(key, defValue);
    }
    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
