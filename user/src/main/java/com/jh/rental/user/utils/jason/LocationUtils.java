package com.jh.rental.user.utils.jason;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by 骏辉出行 on 2017/6/9.
 */

public class LocationUtils {
    public void getlocation(Context context) {
        String value = LocationManager.GPS_PROVIDER;
        LocationManager locationManager = (LocationManager) context.getSystemService(context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = locationManager.getLastKnownLocation(value);
        Geocoder geocoder=new Geocoder(context, Locale.getDefault());
        try {
            List<Address> addresses=geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            StringBuilder stringBuilder=new StringBuilder();
            if(addresses.size()>0){
                Address address=addresses.get(0);
                if (address.getCountryCode().equals("CN")){
                    Toast.makeText(context, "报错", Toast.LENGTH_LONG).show();
                }
                stringBuilder.append(address.getCountryName()).append("_");

                System.out.println(stringBuilder.toString());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            Toast.makeText(context, "报错", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
