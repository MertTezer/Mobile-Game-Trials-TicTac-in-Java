package com.merttezer.tictacgame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {

        Button btnSelected=(Button)view;
        btnSelected.setBackgroundColor(Color.RED);
        int CellID=0;

        switch ((btnSelected.getId())){

            case R.id.button1:
                CellID=1;
                break;

            case R.id.button2:
                CellID=2;
                break;

            case R.id.button3:
                CellID=3;
                break;

            case R.id.button4:
                CellID=4;
                break;

            case R.id.button5:
                CellID=5;
                break;

            case R.id.button6:
                CellID=6;
                break;

            case R.id.button7:
                CellID=7;
                break;

            case R.id.button8:
                CellID=8;
                break;

            case R.id.button9:
                CellID=9;
                break;

        }
        PlayGame(CellID,btnSelected);
    }

    int ActivePlayer=1;
    ArrayList<Integer> Player1= new ArrayList<Integer>();
    ArrayList<Integer> Player2= new ArrayList<Integer>();

    void PlayGame(int CellID, Button btnSelected){
        btnSelected.setBackgroundColor(Color.RED);
        Log.d("Player",String.valueOf(CellID));

        if(ActivePlayer==1){
            btnSelected.setText("X");
            btnSelected.setBackgroundColor(Color.GREEN);
            Player1.add(CellID);
            ActivePlayer=2;
        }

        else if(ActivePlayer==2){
            btnSelected.setText("O");
            btnSelected.setBackgroundColor(Color.BLACK);
            Player2.add(CellID);
            ActivePlayer=1;
        }
        CheckWinner();
    }

    void CheckWinner(){
        int Winner=-1;

        /* ROW 1*/
        if (Player1.contains(1) && Player1.contains(2) && Player1.contains(3))
            Winner=1;
        else if(Player2.contains(1) && Player2.contains(2) && Player2.contains(3))
            Winner=2;

        /* ROW 2 */
        if (Player1.contains(4) && Player1.contains(5) && Player1.contains(6))
            Winner=1;
        else if(Player2.contains(4) && Player2.contains(5) && Player2.contains(6))
            Winner=2;

        /* ROW 3 */
        if (Player1.contains(7) && Player1.contains(8) && Player1.contains(9))
            Winner=1;
        else if(Player2.contains(7) && Player2.contains(8) && Player2.contains(9))
            Winner=2;

        /* COL 1 */
        if (Player1.contains(1) && Player1.contains(4) && Player1.contains(7))
            Winner=1;
        else if(Player2.contains(1) && Player2.contains(4) && Player2.contains(7))
            Winner=2;

        /* COL 2 */
        if (Player1.contains(2) && Player1.contains(5) && Player1.contains(8))
            Winner=1;
        else if(Player2.contains(2) && Player2.contains(5) && Player2.contains(8))
            Winner=2;

        /* COL 3 */
        if (Player1.contains(3) && Player1.contains(6) && Player1.contains(9))
            Winner=1;
        else if(Player2.contains(3) && Player2.contains(6) && Player2.contains(9))
            Winner=2;

        if (Winner!=-1){
            if (Winner==1)
                Toast.makeText(this,"Player1 is Winner",Toast.LENGTH_LONG).show();
            if (Winner==2)
                Toast.makeText(this,"Player2 is Winner",Toast.LENGTH_LONG).show();

        }

        else if(Player1.size()==5 && Player2.size()==4)
            Toast.makeText(this,"DRAW",Toast.LENGTH_LONG).show();

    }
}