package com.jh.rental.user.view.actitity.internationnal;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.db.DBusers;
import com.jh.rental.user.db.User;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.utils.jason.SnakebarUtils;
import com.jh.rental.user.utils.tom.RegexpUtils;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;
import com.jh.rental.user.view.adapter.internationnal.PassengerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Passenger_Activity extends TitelBarAcitvity implements View.OnClickListener {
    private List<User>  users;
    private EditText  name;
    private EditText  phone;
    private DBusers dBuser;
    private TextView  adrBook;
  //  private AddressBook  addressBook;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  addressBook=new AddressBook();
        dBuser=new DBusers();
        users =new ArrayList<>();
        users.clear();
        new Thread(){
            @Override
            public void run() {
                if (dBuser.qureyLoveAll()!=null){
                    users.addAll(dBuser.qureyLoveAll());
                }
            }
        }.start();
        setContentView(R.layout.passenger_activity);
        setMyTitel(BaseContext.getResValue(R.string.passenger));
        setMyTite2(BaseContext.getResValue(R.string.confirm));
        settv2Onclick();
        name= (EditText) findViewById(R.id.et_contact);
        phone= (EditText) findViewById(R.id.et_phone);
        adrBook= (TextView) findViewById(R.id.adrBook);
        adrBook.setOnClickListener(this);
        initView();
    }
    @Override
    public void tv2Onclick() {
        if (RegexpUtils.isMobileExact(phone.getText().toString())){
            if (!TextUtils.isEmpty(name.getText().toString())&&!TextUtils.isEmpty(phone.getText().toString())){
                OrderDetails.getOrderDetails().setPassenger(name.getText().toString());
                OrderDetails.getOrderDetails().setCcrMobile(phone.getText().toString());
                onBackPressed();
                new Thread(){
                    @Override
                    public void run() {
                        Long  s= System.currentTimeMillis();
                        dBuser.insertData(new User(s,name.getText().toString(),phone.getText().toString()));
                    }
                }.start();
            }
        }else {
            SnakebarUtils.showToast(BaseContext.getResValue(R.string.PhoneNumError));
        }
    }

    @Override
    public void handleManage(int value) {
        pr.notifyDataSetChanged();
    }

    private    PassengerAdapter  pr;
    private void initView() {
        RecyclerView rlvRecord = (RecyclerView) findViewById(R.id.rlv_record);
        pr=new PassengerAdapter(this,users);
        pr.setDataCallBack(new PassengerAdapter.DataCallBack() {
            @Override
            public void dataCallback(User user) {
                name.setText(user.getName());
                phone.setText(user.getPhone());
            }
            @Override
            public void deledata(User user) {
                dBuser.deleteId(user.getId());
               updata();
            }
        });
        rlvRecord.setHasFixedSize(true);
        rlvRecord.setLayoutManager(new GridLayoutManager(this, 1));
        rlvRecord.setAdapter(pr);
    }
    public void updata(){
        users.clear();
        if (dBuser.qureyLoveAll()!=null){
            users.addAll(dBuser.qureyLoveAll());
        }
        handler.sendEmptyMessage(0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.adrBook:
                 toAddressbook(REQUSTCODE);
                break;
        }
    }
    private final  int REQUSTCODE=555;
    private void toAddressbook(int reqcode){
        requestPermission(new String[]{Manifest.permission.READ_PHONE_STATE,Manifest.permission.READ_CONTACTS},588);
        Uri uri = Uri.parse("content://contacts/people");
        Intent intent = new Intent(Intent.ACTION_PICK, uri);
        startActivityForResult(intent, reqcode);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Logger.newTestMessage(resultCode);
        if (requestCode==REQUSTCODE){
            if (data!=null&&data.getData()!=null){
                Uri  uri =data.getData();
                String[] contacts=getPhoneContacts(uri);
                name.setText(contacts[0]);
                phone.setText(contacts[1]);
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private String[] getPhoneContacts(Uri uri){
        String[] contact=new String[2];
//得到ContentResolver对象
        ContentResolver cr = getContentResolver();
//取得电话本中开始一项的光标
        Cursor cursor=cr.query(uri,null,null,null,null);
        if(cursor!=null) {
            cursor.moveToFirst();
//取得联系人姓名
            int nameFieldColumnIndex=cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
            contact[0]=cursor.getString(nameFieldColumnIndex);
//取得电话号码
            String ContactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            Cursor phone = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + ContactId, null, null);
            if(phone != null){
                phone.moveToFirst();
                contact[1] = phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            }
            phone.close();
            cursor.close();
        } else {
            return null;
        }
        return contact;
    }
}
