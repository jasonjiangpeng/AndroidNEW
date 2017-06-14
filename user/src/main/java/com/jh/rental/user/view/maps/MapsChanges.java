package com.jh.rental.user.view.maps;

/**
 * Created by 骏辉出行 on 2017/5/23.
 */

public class MapsChanges {
      /*change to google map*/
/*    private void changeToGoogleMapView() {
        zoom = mAmapView.getMap().getCameraPosition().zoom;
        latitude = mAmapView.getMap().getCameraPosition().target.latitude;
        longitude = mAmapView.getMap().getCameraPosition().target.longitude;
        mapbtn.setText("To Amap");
        mIsAmapDisplay = false;
        mGoogleMapView = new com.google.android.gms.maps.MapView(this, new GoogleMapOptions()
                .camera(new com.google.android.gms.maps.model
                        .CameraPosition(new com.google.android.gms.maps.model.LatLng(latitude, longitude), zoom, 0, 0)));
        mGoogleMapView.onCreate(null);
        mGoogleMapView.onResume();
        mContainerLayout.addView(mGoogleMapView, mParams);
        mGoogleMapView.getMapAsync(this);
        handler.sendEmptyMessageDelayed(0,500);
    }*/
/*.由Google地图切换到高德地图：*/
     /* private void changeToAmapView() {
          zoom = googlemap.getCameraPosition().zoom;
          latitude = googlemap.getCameraPosition().target.latitude;
          longitude = googlemap.getCameraPosition().target.longitude;
          mapbtn.setText("To Google");
          mAmapView = new TextureMapView(this, new AMapOptions()
                  .camera(new com.amap.api.maps.model.CameraPosition(new LatLng(latitude,longitude),zoom,0,0)));
          mAmapView.onCreate(null);
          mAmapView.onResume();
          mContainerLayout.addView(mAmapView, mParams);
          mGoogleMapView.animate()
                  .alpha(0f).setDuration(500).setListener(new AnimatorListenerAdapter() {
              @Override
              public void onAnimationEnd(Animator animation) {
                  mGoogleMapView.setVisibility(View.GONE);
                  mContainerLayout.removeView(mGoogleMapView);
                  if (mGoogleMapView != null) {
                      mGoogleMapView.onDestroy();
                  }
              }
          });
          mAmapView.getMap().setOnCameraChangeListener(this);
          mIsAmapDisplay = true;
      }*/
}
