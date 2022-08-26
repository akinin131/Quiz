package quiz89.example.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GamesLevel extends AppCompatActivity {
    Button button;
    TextView button_level_1;
    TextView button_level_2;
    TextView button_level_3;
    TextView button_level_4;
    TextView button_level_5;
    TextView button_level_6;
    TextView button_level_7;
    TextView button_level_8;
    TextView button_level_9;
    TextView button_level_10;
    TextView button_level_11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelavels);

        SharedPreferences save = getSharedPreferences("Save",MODE_PRIVATE);
        final int level = save.getInt("Level",1);
        Button button_back;




        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        button_back = findViewById(R.id.button_back);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(GamesLevel.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                } catch (Exception e) {

                }
            }
        });

        button_level_1 = findViewById(R.id.textView1);
        button_level_2 = findViewById(R.id.textView2);
        button_level_3 = findViewById(R.id.textView3);
        button_level_4 = findViewById(R.id.textView4);
        button_level_5 = findViewById(R.id.textView5);
        button_level_6 = findViewById(R.id.textView6);
        button_level_7 = findViewById(R.id.textView7);
        button_level_8 = findViewById(R.id.textView8);
        button_level_9 = findViewById(R.id.textView9);
        button_level_10 = findViewById(R.id.textView10);
        button_level_11 = findViewById(R.id.textVie11);


        button_level_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    if(level>=1) {
                        Intent intent = new Intent(GamesLevel.this, level1.class);
                        startActivity(intent);
                        finish();
                    }else {

                    }
                }catch (Exception e){

                }

            }
        });

        button_level_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    if(level>=2) {
                        Intent intent = new Intent(GamesLevel.this, level2.class);
                        startActivity(intent);
                        finish();
                    }else {

                    }
                }catch (Exception e){

                }
            }
        });
        button_level_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    if(level>=3) {
                        Intent intent = new Intent(GamesLevel.this, level3.class);
                        startActivity(intent);
                        finish();
                    }else {

                    }
                }catch (Exception e){

                }
            }
        });
        button_level_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    if(level>=4) {
                        Intent intent = new Intent(GamesLevel.this, level4.class);
                        startActivity(intent);
                        finish();
                    }else {

                    }
                }catch (Exception e){

                }
            }
        });
        button_level_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    if(level>=5) {
                        Intent intent = new Intent(GamesLevel.this, level5.class);
                        startActivity(intent);
                        finish();
                    }else {

                    }
                }catch (Exception e){

                }
            }
        });
        button_level_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    if(level>=6) {
                        Intent intent = new Intent(GamesLevel.this, level6.class);
                        startActivity(intent);
                        finish();
                    }else {

                    }
                }catch (Exception e){

                }
            }
        });
        button_level_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    if(level>=7) {
                        Intent intent = new Intent(GamesLevel.this, level7.class);
                        startActivity(intent);
                        finish();
                    }else {

                    }
                }catch (Exception e){

                }
            }
        });
        button_level_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    if(level>=8) {
                        Intent intent = new Intent(GamesLevel.this, level8.class);
                        startActivity(intent);
                        finish();
                    }else {

                    }
                }catch (Exception e){

                }
            }
        });
        button_level_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    if(level>=9) {
                        Intent intent = new Intent(GamesLevel.this, level9.class);
                        startActivity(intent);
                        finish();
                    }else {

                    }
                }catch (Exception e){

                }
            }
        });
        button_level_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    if(level>=10) {
                        Intent intent = new Intent(GamesLevel.this, level10.class);
                        startActivity(intent);
                        finish();
                    }else {

                    }
                }catch (Exception e){

                }
            }
        });
        button_level_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    if(level>=11) {
                        Intent intent = new Intent(GamesLevel.this, level11.class);
                        startActivity(intent);
                        finish();
                    }else {

                    }
                }catch (Exception e){

                }
            }
        });

        final int[] x={
                R.id.textView1,
                R.id.textView2,
                R.id.textView3,
                R.id.textView4,
                R.id.textView5,
                R.id.textView6,
                R.id.textView7,
                R.id.textView8,
                R.id.textView9,
                R.id.textView10,
                R.id.textVie11,
        };

        for (int i =1; i <level; i++){
            TextView tv = findViewById(x[i]);
            tv.setText(""+(i+1));
        }




    }

    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(GamesLevel.this, MainActivity.class);
            startActivity(intent);
            finish();

        } catch (Exception e) {
        }

    }
}