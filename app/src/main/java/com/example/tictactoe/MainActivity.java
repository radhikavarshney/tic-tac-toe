package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    boolean gameActive= true;
    int activePlayer=0;
    int count=0;
    int []gameState={2,2,2,2,2,2,2,2,2};
    int [][] winPositions={{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,8}};

    public void playerTap (View view)
    {
        ImageView img= (ImageView) view;
        int tappedImage= Integer.parseInt(img.getTag().toString());
        if(!gameActive)
        {
            gameReset(view);
        }
        if (gameState[tappedImage]==2)
        {
            count++;
            gameState[tappedImage]=activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer==0)
            {
                img.setImageResource(R.drawable.cross);
                activePlayer=1;
                TextView statusBar =findViewById(R.id.statusBar);
                statusBar.setText("O's turn- Tap to play");

            }
            else
            {
                img.setImageResource(R.drawable.circle);
                activePlayer=0;
                TextView statusBar =findViewById(R.id.statusBar);
                statusBar.setText("X's turn- Tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        Log.d("radhika", "count "+count);
        if(count==9)
        {
            TextView statusBar =findViewById(R.id.statusBar);
            statusBar.setText("It is a draw!!");
            count=10;
        }
        if(count==10)
        {
            gameReset(view);
        }
        for(int[] winPosition :winPositions)
        {
            if(gameState[winPosition[0]]==gameState[winPosition[1]]&&gameState[winPosition[1]]==gameState[winPosition[2]]&&gameState[winPosition[0]]!=2)
            {
                gameActive=false;
                String winner;
                if(gameState[winPosition[0]]==0)
                {
                    winner="X has won!!";
                    count=0;
                }
                else
                {
                    winner="O has won!!";
                    count=0;
                }
                TextView statusBar =findViewById(R.id.statusBar);
                statusBar.setText(winner);
            }
        }

    }
    public void gameReset (View view)
    {
        gameActive=true;
        activePlayer=0;
        for(int i=0; i<gameState.length;i++)
        {
            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        TextView statusBar =findViewById(R.id.statusBar);
        statusBar.setText("X's turn- Tap to play");


    }
    @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

        }
}


