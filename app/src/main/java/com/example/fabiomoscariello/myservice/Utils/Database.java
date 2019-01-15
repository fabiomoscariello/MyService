package com.example.fabiomoscariello.myservice.Utils;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Database {
    private static final String TAG="Database";
    private static DatabaseReference ISTANCE = null;

    private Database() {
    }

    public static DatabaseReference getIstance() {
        Log.d(TAG,"Istanza Database avviata");
        if (ISTANCE == null) {
            ISTANCE = FirebaseDatabase.getInstance().getReference();
        }
        return ISTANCE;
    }

}
