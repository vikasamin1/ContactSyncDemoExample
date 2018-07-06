package com.vrajaninfotech.vampy.contactsyncdemoexample;

import android.app.Service;
import android.content.Intent;
import android.content.SyncAdapterType;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class SyncService extends Service {

    private static final String TAG = "SyncService";
    private static final Object sSyncAdapterLock=new Object();
    private static SyncAdapter syncAdapter=null;

    @Override
    public void onCreate() {
        Log.i(TAG, "Sync Service created");
        synchronized (sSyncAdapterLock){
            if(syncAdapter==null)
            {
                syncAdapter=new SyncAdapter(getApplicationContext(),true);
            }
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "Sync service binded");
        return syncAdapter.getSyncAdapterBinder();
    }
}
