package quiz89.example.quiz;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class level7 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogEnd;
    TextView btnclose;
    Button btncontinue1;
    public  int count = 0;

    public int numLeft;
    public int numRight;
    Array2 array = new Array2();
    Random random = new Random();
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);
        TextView textView = findViewById(R.id.textViewLevels);
        textView.setText(R.string.levels7);

        SoundPool soundPool;
        int sound1, sound2;
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            AudioAttributes audioAttributes;
            audioAttributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION).build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(6)
                    .setAudioAttributes(audioAttributes)
                    .build();

        } else {
            soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
        }
        sound1 = soundPool.load(this, R.raw.linewin,1);
        sound2 = soundPool.load(this, R.raw.lineclose,1);

        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer1;
        mediaPlayer= MediaPlayer.create(getApplicationContext(),R.raw.linewin);
        mediaPlayer1= MediaPlayer.create(getApplicationContext(),R.raw.lineclose);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        button = findViewById(R.id.buttonbacklevels);
        final ImageView sloi1 = findViewById(R.id.sloi1);
        final ImageView sloi2 = findViewById(R.id.sloi2);
        TextView textLeft = findViewById(R.id.textLeft);
        TextView textRight = findViewById(R.id.textRight);

        sloi1.setClipToOutline(true);
        sloi2.setClipToOutline(true);

        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.previewdialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // прозрачный фон диалогового окна
        dialog.setCancelable(false);
        ImageView imageView =dialog.findViewById(R.id.previewimg);
        imageView.setImageResource(R.drawable.sevenlevel_diologstart);
        TextView textView1 = dialog.findViewById(R.id.textdescription);
        textView1.setText(R.string.textlevel7start);

        btnclose = findViewById(R.id.btncloseee);

        TextView btnclose = dialog.findViewById(R.id.btncloseee);
       btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(level7.this, GamesLevel.class);
                    startActivity(intent);
                    finish();


                } catch (Exception e){

                }
                dialog.dismiss();

            }
        });

        Button btncontinue1 = dialog.findViewById(R.id.btncontinue);

        btncontinue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();

            }
        });
        dialog.show();

        //___________________________________________________________ Диологовое окно после завершение первого уровня

        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEnd.setContentView(R.layout.previewdialogtwo);
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // прозрачный фон диалогового окна
        dialogEnd.setCancelable(false);
        ImageView imageView1 =dialog.findViewById(R.id.previewimg);
        imageView1.setImageResource(R.drawable.sixlevel_diologstart);
        TextView textView2 = dialogEnd.findViewById(R.id.textdescription);
        textView2.setText(R.string.textlevel7End);


//        btnclose = findViewById(R.id.btncloseee);

        TextView btnclose2 = dialogEnd.findViewById(R.id.btncloseee);
        btnclose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(level7.this, GamesLevel.class);
                    startActivity(intent);
                    finish();


                } catch (Exception e){

                }
                dialog.dismiss();

            }
        });

        Button btncontinue1End = dialogEnd.findViewById(R.id.btncontinue);

        btncontinue1End.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(level7.this, level8.class);
                startActivity(intent);
                finish();


            }
        });

        //___________________________________________________________ Диологовое окно после завершение первого уровня - конец

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(level7.this, GamesLevel.class);
                    startActivity(intent);
                    finish();


                } catch (Exception e){

                }

            }
        });

        // массив для прогресса игры начало
        final int [] progres = {R.id.level1, R.id.level2, R.id.level3, R.id.level4,
                R.id.level5,R.id.level6, R.id.level7, R.id.level8, R.id.level9, R.id.level10,
                R.id.level11, R.id.level12, R.id.level13, R.id.level14, R.id.level15, R.id.level16,
                R.id.level17, R.id.level18, R.id.level19, R.id.level20,
        };
        // массив для прогресса игры конец
            // Подключаем анимацию начало
        final Animation animation = AnimationUtils.loadAnimation(level7.this, R.anim.alpha);
            // Подключаем анимацию конец
        numLeft = random.nextInt(16);
      //  numRight = random.nextInt(10);
        sloi1.setImageResource(array.images7[numLeft]);
        textLeft.setText(array.text7[numLeft]);

        numRight = random.nextInt(16);

        while (numLeft == numRight){
            numRight = random.nextInt(16);
        }

        sloi2.setImageResource(array.images7[numRight]);
        textRight.setText(array.text7[numRight]);
        //обрабатываем нажатие левой картинки - начало
            sloi1.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {

                    // Условие касание картинки - начало
                        if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                            //если коснулся картинки - начло
                            sloi2.setEnabled(false); // блокируем правую картинку
                            if (numLeft < numRight){
                                sloi1.setImageResource(R.drawable.win);
                                soundPool.play(sound1,1,1, 0,0,1);
                            } else{
                                sloi1.setImageResource(R.drawable.close);
                                soundPool.play(sound2,1,1, 0,0,1);
                            }
                            //если коснулся картинки - конец
                        } else if (motionEvent.getAction()==MotionEvent.ACTION_UP){
                            // если отпустил плец начало
                            if (numLeft < numRight){
                            if(count<20){
                                count = count +1;
                            }
                            //закрашиваем прогресс серым цветом - начало
                                for (int i =0; i<20; i++){
                                    TextView tv = findViewById(progres[i]);
                                    tv.setBackgroundResource(R.drawable.text_pointes);
                                }
                            //закрашиваем прогресс серым цветом - цветом
                                // определяем правильные ответы и закрашиваем - начало
                                for (int i =0; i<count; i++){
                                    TextView tv = findViewById(progres[i]);
                                    tv.setBackgroundResource(R.drawable.text_pointes_green);
                                }
                                // определяем правильные ответы и закрашиваем - конец
                        }else {
                                if (count>0)
                                {
                                    if (count == 1){
                                        count = 0;
                                    }else {
                                        count = count -2;}
                                }
                            }
                            //закрашиваем прогресс зеленым цветом - начало
                            for (int i =0; i<20; i++){
                                TextView tv = findViewById(progres[i]);
                                tv.setBackgroundResource(R.drawable.text_pointes);
                            }
                            //закрашиваем прогресс зеленым цветом - цветом
                            // определяем правильные ответы и закрашиваем - начало
                            for (int i =0; i<count; i++){
                                TextView tv = findViewById(progres[i]);
                                tv.setBackgroundResource(R.drawable.text_pointes_green);
                            }
                            // определяем правильные ответы и закрашиваем - конец
                            if(count == 20){
                                // ВЫХОД  ИЗ ПЕРВОГО УРОВНЯ
                                SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                                final int level = save.getInt("Level",1);
                                if(level>7){

                                }else {
                                    SharedPreferences.Editor editor = save.edit();
                                    editor.putInt("Level",8);
                                    editor.commit();
                                }
                                dialogEnd.show();
                            }else {
                                numLeft = random.nextInt(16);
                                //  numRight = random.nextInt(10);
                                sloi1.setImageResource(array.images7[numLeft]);
                                sloi1.startAnimation(animation);
                                textLeft.setText(array.text7[numLeft]);


                                numRight = random.nextInt(16);

                                while (numLeft == numRight){
                                    numRight = random.nextInt(16);
                                }

                                sloi2.setImageResource(array.images7[numRight]);
                                sloi2.startAnimation(animation);
                                textRight.setText(array.text7[numRight]);
                                sloi2.setEnabled(true);

                            }


                        }
                    // Условие касание картинки - конец

                     return true;
                }
            });

        //обрабатываем нажатие левой картинки - конец

        //обрабатываем нажатие правой кнопки - начало
        sloi2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                // Условие касание картинки - начало
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    //если коснулся картинки - начло
                    sloi1.setEnabled(false); // блокируем правую картинку
                    if (numLeft > numRight){
                        sloi2.setImageResource(R.drawable.win);
                        soundPool.play(sound1,1,1, 0,0,1);
                    } else{
                        sloi2.setImageResource(R.drawable.close);
                        soundPool.play(sound2,1,1, 0,0,1);
                    }
                    //если коснулся картинки - конец
                } else if (motionEvent.getAction()==MotionEvent.ACTION_UP){
                    // если отпустил плец начало
                    if (numLeft > numRight){
                        if(count<20){
                            count = count +1;
                        }
                        //закрашиваем прогресс серым цветом - начало
                        for (int i =0; i<20; i++){
                            TextView tv = findViewById(progres[i]);
                            tv.setBackgroundResource(R.drawable.text_pointes);
                        }
                        //закрашиваем прогресс серым цветом - цветом
                        // определяем правильные ответы и закрашиваем - начало
                        for (int i =0; i<count; i++){
                            TextView tv = findViewById(progres[i]);
                            tv.setBackgroundResource(R.drawable.text_pointes_green);
                        }
                        // определяем правильные ответы и закрашиваем - конец
                    }else {
                        if (count>0)
                        {
                            if (count == 1){
                                count = 0;
                            }else {
                                count = count -2;}
                        }
                    }
                    //закрашиваем прогресс зеленым цветом - начало
                    for (int i =0; i<20; i++){
                        TextView tv = findViewById(progres[i]);
                        tv.setBackgroundResource(R.drawable.text_pointes);
                    }
                    //закрашиваем прогресс зеленым цветом - цветом
                    // определяем правильные ответы и закрашиваем - начало
                    for (int i =0; i<count; i++){
                        TextView tv = findViewById(progres[i]);
                        tv.setBackgroundResource(R.drawable.text_pointes_green);
                    }
                    // определяем правильные ответы и закрашиваем - конец
                    if(count == 20){
                        // ВЫХОД  ИЗ ПЕРВОГО УРОВНЯ
                        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                        final int level = save.getInt("Level",1);
                        if(level>7){

                        }else {
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level",8);
                            editor.commit();
                        }
                        dialogEnd.show();
                    }else {
                        numLeft = random.nextInt(16);
                        //  numRight = random.nextInt(10);
                        sloi1.setImageResource(array.images7[numLeft]);
                        sloi1.startAnimation(animation);
                        textLeft.setText(array.text7[numLeft]);


                        numRight = random.nextInt(16);

                        while (numLeft == numRight){
                            numRight = random.nextInt(16);
                        }

                        sloi2.setImageResource(array.images7[numRight]);
                        sloi2.startAnimation(animation);
                        textRight.setText(array.text7[numRight]);
                        sloi1.setEnabled(true);

                    }


                }
                // Условие касание картинки - конец

                return true;
            }
        });


    }
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(level7.this, GamesLevel.class);
            startActivity(intent);
            finish();

        } catch (Exception e) {

        }

    }
}
