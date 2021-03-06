package com.ltt.overseasuser.base;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ltt.overseasuser.R;
import com.ltt.overseasuser.utils.ToastUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2018/6/24 0024.
 */

public class MediaPlayObject {
    private ImageView mSoundIamge;
    private SeekBar seekBar;
    private TextView musicCur;
    private String mMp3Path = "";//Recording location
    private View mView = null;
    private Activity mParentActivity;
    private SimpleDateFormat format=null;
    private Timer timer;
    private MediaPlayer mediaPlayer;
    public MediaPlayObject(View view, String mp3Path, Activity activity) {
        format = new SimpleDateFormat("mm:ss");
        mView = view;
        mMp3Path = mp3Path;
        mParentActivity=activity;
        initUI();

    }

    private void initUI() {

        mSoundIamge = mView.findViewById(R.id.play_stop);
        seekBar = mView.findViewById(R.id.seekBar);
        musicCur = mView.findViewById(R.id.voice_cur);
        mSoundIamge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickPlayVoice(mMp3Path);

            }
        });

    }

    protected void finalize() {

        if (timer != null){
            timer.cancel();
            timer=null;
        }
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;;
        }


    }



    //Click the voice playback button.
    private void clickPlayVoice(String mp3Path) {
        if (mp3Path.isEmpty())
            return;
         mediaPlayer = new MediaPlayer();
        timer = new Timer();

        try {
            mediaPlayer.setDataSource(mp3Path);//Specify the path of the audio file.
            mediaPlayer.prepareAsync();//让mediaplayer prepare
        } catch (IOException e) {
            e.printStackTrace();
            ToastUtils.showToast("play error!");
            if (timer != null){
                timer.cancel();
                timer=null;
            }
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=null;;
            }
            return;

        }

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                // Callback after playback.
                mSoundIamge.setImageResource(R.mipmap.play);
                if (timer != null){
                    timer.cancel();
                    timer=null;
                }

                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer=null;;
                }



            }
        });
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
              ; ToastUtils.showToast("play error!");
                if (timer != null){
                    timer.cancel();
                    timer=null;
                }
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer=null;;
                }
                return true;
            }
        });
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(final MediaPlayer mp) {
                seekBar.setMax(mp.getDuration());
                musicCur.setText("00:00");
                mSoundIamge.setImageResource(R.mipmap.stop);
                mp.start();//begin
                mp.seekTo(0);

                //Monitor the playback callback function
                timer.schedule(new TimerTask() {

                    Runnable updateUI = new Runnable() {
                        @Override
                        public void run() {
                            if (mp == null)
                                return;
                            musicCur.setText(format.format(mp.getCurrentPosition()) + "");

                        }
                    };

                    @Override
                    public void run() {
                        if (mp == null)
                            return;
                        seekBar.setProgress(mp.getCurrentPosition());
                        mParentActivity.runOnUiThread(updateUI);
                    }
                }, 0, 50);

            }
        });
    }


}