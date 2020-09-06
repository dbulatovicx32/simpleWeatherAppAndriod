package android.singidunum.ac.prognozaprojekat.prefs;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefs {

    private final static String SHARED_PREFFERENCES_PREFIX = "MainActivitySP";
    private static SharedPrefs instance;

    private SharedPreferences prefs;

    public SharedPrefs(Context context) {
        prefs = context.getSharedPreferences(SHARED_PREFFERENCES_PREFIX, 0);
    }

    //singleton. samo jedan sharedPrefs moze da postoji
    public static SharedPrefs getInstance(Context context) {
        if(instance == null){
            instance = new SharedPrefs(context);
        }
        return instance;
    }

    public SharedPreferences getPrefs() {
        return prefs;
    }
}
