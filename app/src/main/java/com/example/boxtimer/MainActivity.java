package com.example.boxtimer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.CountDownTimer;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private int TIMER_LENGHT = 120, mTimeToGo, round, timeFight,timeRelax,countRound,timer;
    private String status="Fight";




    MediaPlayer mPlayer;
    private CountDownTimer mCountDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayer=MediaPlayer.create(this, R.raw.gong);
        Button b1 = (Button) findViewById(R.id.start);

    }



    public void start (View view){

        EditText editText = (EditText) findViewById(R.id.timer);
        timeFight =   Integer.parseInt(editText.getText().toString());
        mTimeToGo = timeFight;


        EditText editText2 = (EditText) findViewById(R.id.timeRelaxid);
        timeRelax =   Integer.parseInt(editText.getText().toString());

        TextView timer = (TextView)findViewById(R.id.timeRelaxid);

        timer.setText(""+status);

        EditText editText3 = (EditText) findViewById(R.id.roundid);
        round =   Integer.parseInt(editText.getText().toString());


     //   TextView timer = (TextView)findViewById(R.id.timer);
       // char timeChar = (char)timeFight;


        mCountDownTimer  = new CountDownTimer(timeFight * timeRelax * round * 1000, 1000) {
            public void onTick(long millisUntilFinished) {

                if (round > 0){

                    mTimeToGo -= 1;
                    TextView timer = (TextView)findViewById(R.id.timer);
                    timer.setText(""+mTimeToGo);
                  //  if (round > 0)

                    if (mTimeToGo == 0){
                        mPlayer.start();
                            if (status == "fight"){
                                status = "relax";
                                mTimeToGo = timeRelax;
                                round--;

                                TextView roundid = (TextView)findViewById(R.id.roundid);
                                roundid.setText(""+round);

                            }else
                                mTimeToGo = timeFight;


                    }

                }




            }
            public void onFinish() {
                mPlayer.start();
            }
        }.start();





    }





    public void stop (View view){

        mCountDownTimer.cancel();

        TextView timer = (TextView)findViewById(R.id.timer);
        timer.setText(""+timeFight);


        TextView timeRelaxid = (TextView)findViewById(R.id.timeRelaxid);
        timer.setText(""+timeRelax);

        TextView roundid = (TextView)findViewById(R.id.roundid);
        roundid.setText(""+round);



    }





}
