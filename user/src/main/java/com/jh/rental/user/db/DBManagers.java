package com.jh.rental.user.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.jh.rental.user.db.flight.DaoMaster;
import com.jh.rental.user.db.flight.DaoSession;
import com.jh.rental.user.utils.jason.BaseContext;

/**
 * Created by 骏辉出行 on 2017/5/18.
 */

public class DBManagers {
    private static DaoSession daoSession;

    public static DaoSession setupDatabase(Context context,String name){
        DaoMaster.DevOpenHelper  devOpenHelper=new DaoMaster.DevOpenHelper(context.getApplicationContext(),name,null);
        SQLiteDatabase sqLiteDatabase=devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster=new DaoMaster(sqLiteDatabase);
        daoSession = daoMaster.newSession();
        return  daoSession;
    }

    public static DaoSession getDaoSession(){
        if (daoSession!=null){
            return daoSession;
        }
        return setupDatabase(BaseContext.context,"passenger_db");
    }

    public static DaoSession getFlightMessage(){
        if (daoSession!=null){
            return daoSession;
        }
        return setupDatabase(BaseContext.context,"flight_db");
    }
    public static DaoSession getHistoryCity(){
        if (daoSession!=null){
            return daoSession;
        }
        return setupDatabase(BaseContext.context,"historycity_db");
    }
}
