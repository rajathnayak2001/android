package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button goButton;
    ArrayList<Integer> answer=new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    TextView resultTextView;
    int score=0;
    int numberofQuestions=0;
    TextView scoreTextView;
    TextView sumTextView;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button playagain;
    TextView timerTextView;
    public void playagain(View view)
    {
       score=0;
       numberofQuestions=0;
       timerTextView.setText("30s");
        scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberofQuestions));

       newQuestion();
       playagain.setVisibility(View.INVISIBLE);

        new CountDownTimer(30100,1000)
        {

            @Override
            public void onTick(long l) {
                timerTextView.setText(String.valueOf(l/1000) + "s");
            }

            @Override
            public void onFinish() {
                resultTextView.setText("Time Up");
                playagain.setVisibility(View.VISIBLE);
            }
        }.start();
    }
    public void chooseAnswer(View view)
    {
       if( Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString()))
       {
           resultTextView.setText("Correct");
           score++;
       }
       else
       {
           resultTextView.setText("Wrong :(");
       }

      numberofQuestions++;
       scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberofQuestions));
       newQuestion();


    }
    public void start(View view)
    {

        playagain(findViewById(R.id.timerTextView));


    }
    public void newQuestion()
    {
        Random rand=new Random();

        int a=rand.nextInt(21);
        int b=rand.nextInt(21);
        TextView sumTextView=findViewById(R.id.sumTextView);
        sumTextView.setText(Integer.toString(a) +" + "+Integer.toString(b));

        locationOfCorrectAnswer=rand.nextInt(4);
        answer.clear();
        for (int i=0;i<4;i++) {
            if (i == locationOfCorrectAnswer)
            {
                answer.add(a+b);
            }
            else
            {
                int wrongAnswer=rand.nextInt(41);
                while(wrongAnswer==a+b)
                {
                    wrongAnswer=rand.nextInt(41);
                }
                answer.add(wrongAnswer);
            }

        }
        button0.setText(Integer.toString(answer.get(0)));
        button1.setText(Integer.toString(answer.get(1)));
        button2.setText(Integer.toString(answer.get(2)));
        button3.setText(Integer.toString(answer.get(3)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goButton=findViewById(R.id.goButton);

         button0=findViewById(R.id.button0);
         button1=findViewById(R.id.button1);
         button2=findViewById(R.id.button2);
         button3=findViewById(R.id.button3);
        resultTextView=findViewById(R.id.resultTextView);
        scoreTextView=findViewById(R.id.scoreTextView);
        timerTextView=findViewById(R.id.timerTextView);
        playagain=findViewById(R.id.playagainbutton);

        start(findViewById(R.id.resultTextView));




    }

}