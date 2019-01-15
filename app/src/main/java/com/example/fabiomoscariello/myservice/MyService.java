package com.example.fabiomoscariello.myservice;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.example.fabiomoscariello.myservice.Utils.Database;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;


public class MyService extends Service {
    private static final String TAG="MyService";
    private Context context;
    private String valore;
    private WorkerUtils workerUtils;
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
                //valore = dataSnapshot.getValue();/
                //Toast.makeText(context, "Risultato: " + valore, Toast.LENGTH_SHORT).show();
                Log.d(TAG, "risultato" + valore);
                WorkerUtils.makeStatusNotification("Modifica sul database", context);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Servizio Creato");
        context=MyService.this.getApplicationContext();
    }
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"Servizio Terminato");

    }
}
