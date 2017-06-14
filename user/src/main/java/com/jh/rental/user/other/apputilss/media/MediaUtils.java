package com.jh.rental.user.other.apputilss.media;

import android.media.MediaRecorder;

/**
 * Created by LostJason on 2017/4/17.
 */

public class MediaUtils {
    /*录音*/
    public static void startrecoder(String  path){
        MediaRecorder mediaRecorder =new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
         mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        mediaRecorder.setOutputFile(path);
    }
}
