package com.example.fabiomoscariello.myservice;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.example.fabiomoscariello.myservice.Utils.Database;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class MyService extends Service {
    private static final String TAG="MyService";
    private Context context;
    private String valore;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"Servizio Avviato");
        Database.getIstance().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                valore= dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
            public b
        }



        );
        Toast.makeText(this,"Risultato"+valore,Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context=MyService.this.getApplicationContext();
    }
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"Servizio Terminato");

    }
}
