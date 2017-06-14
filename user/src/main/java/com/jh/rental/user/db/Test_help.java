package com.jh.rental.user.db;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by 骏辉出行 on 2017/5/18.
 */

public class Test_help  {
    private static DaoSession  daoSession;



    public static DaoSession setupDatabase(Context context,String name){
        DaoMaster.DevOpenHelper  devOpenHelper=new DaoMaster.DevOpenHelper(context.getApplicationContext(),name,null);
    //    DaoMaster.DevOpenHelper devOpenHelper1=new DaoMaster.DevOpenHelper()
        SQLiteDatabase sqLiteDatabase=devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster=new DaoMaster(sqLiteDatabase);
         daoSession = daoMaster.newSession();
        String databaseName = devOpenHelper.getDatabaseName();
        System.out.println(databaseName);
        return  daoSession;
        //  TestADao testADao = daoSession.getTestADao();
        }
    public static DaoSession getDaoSession(){
        if (daoSession!=null){
            return daoSession;
        }
        return null;
    }

}
