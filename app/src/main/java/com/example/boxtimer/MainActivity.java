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
        timeRelax =   Integer.parseInt(editText2.getText().toString());


        TextView timer = (TextView)findViewById(R.id.timeRelaxid);
        timer.setText(""+status);

        TextView statusid = (TextView)findViewById(R.id.statusid);
        statusid.setText("");

        TextView countroundid = (TextView)findViewById(R.id.countroundid);
        countroundid.setText("Осталось раундов");

        TextView timeid = (TextView)findViewById(R.id.timeid);
        timeid.setText("Осталось времени");



        EditText editText3 = (EditText) findViewById(R.id.roundid);
        countRound = round =   Integer.parseInt(editText3.getText().toString());

        View s = findViewById(R.id.start);
        s.setVisibility(View.GONE);

        View p = findViewById(R.id.pause);
        p.setVisibility(View.VISIBLE);





        mCountDownTimer  = new CountDownTimer(timeFight * timeRelax * round * 1000, 1000) {
            public void onTick(long millisUntilFinished) {

                if (round > 0){

                    mTimeToGo -= 1;
                    TextView timer = (TextView)findViewById(R.id.timer);
                    timer.setText(""+mTimeToGo);
                  //  if (round > 0)

                    if (mTimeToGo == 0){
                        mPlayer.start();
                      //  if (status == "Fight") {

                        if ("Fight".equals(status)) {
                                status = "relax";
                                mTimeToGo = timeRelax;
                                round--;

                                TextView roundid = (TextView)findViewById(R.id.roundid);
                                roundid.setText(""+round);

                            }else {
                            mTimeToGo = timeFight;
                            status = "Fight";
                        }

                        TextView timeRelaxid = (TextView)findViewById(R.id.timeRelaxid);
                        timeRelaxid.setText(""+status);

                    }

                }




            }
            public void onFinish() {
                mPlayer.start();

                TextView timer = (TextView)findViewById(R.id.timer);
                timer.setText(""+timeFight);


                TextView timeRelaxid = (TextView)findViewById(R.id.timeRelaxid);
                timer.setText(""+timeRelax);

                TextView roundid = (TextView)findViewById(R.id.roundid);
                roundid.setText(""+countRound);



            }
        }.start();





    }





    public void Stop (View view){

        mCountDownTimer.cancel();

        View s = findViewById(R.id.pause);
        s.setVisibility(View.GONE);

        View p = findViewById(R.id.start);
        p.setVisibility(View.VISIBLE);


        TextView timer = (TextView)findViewById(R.id.timer);
        timer.setText(""+timeFight);


        TextView timeRelaxid = (TextView)findViewById(R.id.timeRelaxid);
        timer.setText(""+timeRelax);

        TextView roundid = (TextView)findViewById(R.id.roundid);
        roundid.setText(""+countRound);



    }

    public void pause (View view){

        mCountDownTimer.cancel();

        View s = findViewById(R.id.pause);
        s.setVisibility(View.GONE);

        View p = findViewById(R.id.start);
        p.setVisibility(View.VISIBLE);




    }






}
