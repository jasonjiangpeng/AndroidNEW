package com.jh.rental.user.other.apputilss.gif;

/**
 * Created by LostJason on 2017/4/19.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class MyGifView extends View {
    private long movieStart;
    private Movie movie;
    private Drawable drawable;
    private String is_scale = null;
    private boolean hasDrawn = false;
    private final static int what_update = 1;
    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if(msg.what == what_update) {
                invalidate();
            }
        }
    };
    public MyGifView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        movie = null;
        drawable = null;
        is_scale = attributeSet.getAttributeValue(null,"is_scale");
        String filename = attributeSet.getAttributeValue(null,"filename");
        String str_res_id = attributeSet.getAttributeValue(null,"res_id");
        if(str_res_id != null) {
            str_res_id = str_res_id.trim();
            if(str_res_id.length() == 0)
                str_res_id = null;
        }
        int res_id = -1;
        if(str_res_id != null)
            res_id = attributeSet.getAttributeResourceValue(null, "res_id", 0);
        updateResource(res_id, filename);
    }
    private static byte[] read(InputStream is) {
        byte[] buff = new byte[1024];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int readLen;
        try {
            while((readLen = is.read(buff)) > 0) {
                baos.write(buff, 0, readLen);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baos.toByteArray();
    }
    private static byte[] readFile(String filename) {
        File file = new File(filename);
        if(!file.isFile())
            return null;
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            if(is == null)
                return null;
            return read(is);
        } catch(Exception e) {
            return null;
        } finally {
            close(is);
        }
    }
    private static void close(InputStream is) {
        try {
            if(is != null)
                is.close();
        } catch(Exception e) {
        }
    }
    public void updateResource(int res_id, String filename) {
        if(filename != null) {
            filename = filename.trim();
            if(filename.length() == 0)
                filename = null;
        }
        Movie movie = null;
        Drawable drawable = null;
        if(filename != null) {
            File file = new File(filename);
            if(file.isFile()) {
                try {
                    byte[] data = readFile(filename);
                    movie = Movie.decodeByteArray(data, 0, data.length);
                } catch(Exception e) {
                }
                if(movie == null) {
//scenphoto1 = Drawable.createFromPath(filename);
                    drawable = fitSizeImg(filename);
                }
            }
        }
        if(movie == null && drawable == null && res_id != -1) {
            InputStream is = null;
            is = getResources().openRawResource(res_id);
            if(is != null) {
                try {
                    movie = Movie.decodeStream(is);
                } catch(Exception e) {
                }
                try {
                    if(movie == null){
//scenphoto1 = Drawable.createFromStream(is, null);
                        drawable = fitSizeImg(is);
                    }
                } catch(Exception e) {
                }
                try {
                    if(is != null)
                        is.close();
                } catch(Exception e) {
                }
            }
        }
        if(drawable != null || movie != null) {
            synchronized(this) {
                this.drawable = drawable;
                this.movie = movie;
            }
            if(hasDrawn) {
                Message msg = new Message();
                msg.what = what_update;
                handler.sendMessage(msg);
            }
        }
    }
    public static Drawable fitSizeImg(InputStream is) {
        Bitmap resizeBmp = null;
        Drawable drawable = null;
        try {
            int resSize = is.available();
            BitmapFactory.Options opts = new   BitmapFactory.Options();
            opts.inTempStorage = new byte[16 * 1024];
            opts.inPreferredConfig = Bitmap.Config.ARGB_8888;
            opts.inJustDecodeBounds = true;
            if (resSize < 20480) {       // 0-20k
                opts.inSampleSize = 1;
            } else if (resSize < 51200) { // 20-50k
                opts.inSampleSize = 1;
            } else if (resSize < 102400) { // 50-100k
                opts.inSampleSize = 1;
            } else if (resSize < 307200) { // 100-300k
                opts.inSampleSize = 1;
            } else if (resSize < 409600) { // 300-400k
                opts.inSampleSize = 1;
            } else if (resSize < 819200) { // 400-800k
                opts.inSampleSize = 2;
            } else if (resSize < 1048576) { // 800-1024k
                opts.inSampleSize = 4;
            } else if (resSize < 1310720) { // 1024-1280k
                opts.inSampleSize = 6;
            }else {
                opts.inSampleSize = 8;
            }
            opts.inDither=false;
            opts.inPurgeable = true;
            opts.inInputShareable = true;
            BitmapFactory.Options.class.getField("inNativeAlloc").setBoolean(opts,true);
            if(is != null){
                resizeBmp = BitmapFactory.decodeStream(is, null, opts);
                opts.inJustDecodeBounds = false;
                is.close();
                drawable =  new BitmapDrawable(resizeBmp);
                resizeBmp = null;
            }
            return drawable;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return drawable;
    }
    public static Drawable fitSizeImg(String path) {
        if(path == null || path.length()<1 ) return null;
        File file = new File(path);
        FileInputStream fs = null;
        Bitmap resizeBmp = null;
        Drawable drawable = null;
        BitmapFactory.Options opts = new   BitmapFactory.Options();
        opts.inTempStorage = new byte[16 * 1024];
        opts.inPreferredConfig = Bitmap.Config.ARGB_8888;
        opts.inJustDecodeBounds = true;
        if (file.length() < 20480) {       // 0-20k
            opts.inSampleSize = 1;
        } else if (file.length() < 51200) { // 20-50k
            opts.inSampleSize = 1;
        } else if (file.length() < 102400) { // 50-100k
            opts.inSampleSize = 1;
        } else if (file.length() < 307200) { // 100-300k
            opts.inSampleSize = 1;
        } else if (file.length() < 409600) { // 300-400k
            opts.inSampleSize = 1;
        } else if (file.length() < 819200) { // 400-800k
            opts.inSampleSize = 2;
        } else if (file.length() < 1048576) { // 800-1024k
            opts.inSampleSize = 4;
        } else if (file.length() < 1310720){ // 1024-1280k
            opts.inSampleSize = 6;
        }else {
            opts.inSampleSize = 8;
        }
        opts.inDither=false;
        opts.inPurgeable = true;
        opts.inInputShareable = true;
        try {
            BitmapFactory.Options.class.getField("inNativeAlloc").setBoolean(opts,true);
            fs = new FileInputStream(file);
            if(fs != null){
                resizeBmp = BitmapFactory.decodeFileDescriptor(fs.getFD(), null, opts);
//
                resizeBmp = BitmapFactory.decodeStream(fs, null, opts);
                opts.inJustDecodeBounds = false;
                fs.close();
                drawable =  new BitmapDrawable(resizeBmp);
                resizeBmp = null;
                return drawable;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return drawable;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        hasDrawn = true;
        synchronized(this) {
            if (movie != null) {
                long curTime = android.os.SystemClock.uptimeMillis();
                if (movieStart == 0) {
                    movieStart = curTime;
                }
                int duraction = 0;
                duraction = movie.duration();
                if(duraction == 0) {
                    if("true".equalsIgnoreCase(is_scale)) {
                        Log.e("TAG", "movie.width()="+movie.width()+"movie.height()="+movie.height());
                        Bitmap bitmap = Bitmap.createBitmap(movie.width(),movie.height(), Bitmap.Config.ARGB_8888);
                        Canvas tCanvas = new Canvas(bitmap);
                        movie.draw(tCanvas, 0, 0);
                        Drawable drawable = new BitmapDrawable(null, bitmap);
                        drawable.setBounds(0, 0, this.getWidth(),this.getHeight());
                        drawable.draw(canvas);
                    } else {
                        movie.draw(canvas, 0, 0);
                    }
                } else {
                    int relTime = (int) ((curTime - movieStart) % duraction);
                    movie.setTime(relTime);
                    if("true".equalsIgnoreCase(is_scale)) {
                        Bitmap bitmap = Bitmap.createBitmap(movie.width(),movie.height(), Bitmap.Config.ARGB_8888);
                        Canvas tCanvas = new Canvas(bitmap);
                        movie.draw(tCanvas, 0, 0);
                        Drawable drawable = new BitmapDrawable(null, bitmap);
                        drawable.setBounds(0, 0, this.getWidth(),this.getHeight());
                        drawable.draw(canvas);
                    } else {
                        movie.draw(canvas, 0, 0);
                    }
                    Message msg = new Message();
                    msg.what = what_update;
                    handler.sendMessageDelayed(msg, 80);
                }
            }
            if(drawable != null) {
                if("true".equalsIgnoreCase(is_scale)) {
                    drawable.setBounds(0, 0, this.getWidth(),this.getHeight());
                } else {
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                }
                drawable.draw(canvas);
            }
        }
        super.onDraw(canvas);
    }
}