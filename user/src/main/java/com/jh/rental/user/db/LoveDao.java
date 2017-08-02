package com.jh.rental.user.db;

import java.util.List;

/**
 * Created by 骏辉出行 on 2017/5/19.
 */

public class LoveDao {
    public static void insertLove(Test_shop test_shop){
        DBManagers.getDaoSession().getTest_shopDao().insertOrReplace(test_shop);
    }
    //添加数据，如果有重复就覆盖
     public static void insertData(Test_shop test_shop){
         DBManagers.getDaoSession().getTest_shopDao().insert(test_shop);
     }
     //删除数据
     public static void deleteLove(long id){
         DBManagers.getDaoSession().getTest_shopDao().deleteByKey(id);
     }
    //更新数据
    public static void deleteLove(Test_shop test_shop){
        DBManagers.getDaoSession().getTest_shopDao().update(test_shop);
    }
    //查询全部数据
    public static List<Test_shop> qureyLoveAll(){
       return DBManagers.getDaoSession().getTest_shopDao().loadAll();
    }
    //查询条件为Type=Type_Love的数据
    public static List<Test_shop> qureyLove(){
      return  DBManagers.getDaoSession().getTest_shopDao().queryBuilder().where(Test_shopDao.Properties.Id.eq(Test_shopDao.TABLENAME)).list();
    }


}
