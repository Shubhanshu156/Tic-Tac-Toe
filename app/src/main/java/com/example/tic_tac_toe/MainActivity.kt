package com.example.tic_tac_toe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.security.KeyStore

class MainActivity : AppCompatActivity(),View.OnClickListener{
    lateinit var board:Array<Array<Button>>
    val TAG="welcome"
    var Player:Boolean=true
    var turncouunt=0
    var boardstatus=Array(3){IntArray(3)}
    var Draw:Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate: ")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var currentplayer:String="X"
        board= arrayOf(
            arrayOf(findViewById<Button>(R.id.button1),findViewById<Button>(R.id.button2),findViewById<Button>(R.id.button3)),
            arrayOf(findViewById<Button>(R.id.button4),findViewById<Button>(R.id.button5),findViewById<Button>(R.id.button6)),
            arrayOf(findViewById<Button>(R.id.button7),findViewById<Button>(R.id.button8),findViewById<Button>(R.id.button9)),

        )
        for (i in board){
            for (button in i){
                Log.d(TAG, "onCreate: i am here")
                button.setOnClickListener(this)
            }

        }
        initiliseboardstatus()
        Log.d(TAG, "onCreate: ")
        val reset=findViewById<Button>(R.id.reset)
        reset.setOnClickListener {

            initiliseboardstatus()

        }
    }

    override fun onClick(v: View?) {

        Log.d(TAG, "onClick: ")
        val id=v!!.id
        when(id){
            R.id.button1->{
                Log.d(TAG, "onClick: buttppm1")
                updatevalue(0,0,Player)

            }
            R.id.button2->{
                updatevalue(0,1,Player)
            }
            R.id.button3->{
                updatevalue(0,2,Player)
            }
            R.id.button4->{
                updatevalue(1,0,Player)
            }
            R.id.button5->{
                updatevalue(1,1,Player)
            }
            R.id.button6->{
                updatevalue(1,2,Player)
            }
            R.id.button7->{
                updatevalue(2,0,Player)
            }
            R.id.button8->{
                updatevalue(2,1,Player)
            }
            R.id.button9->{
                updatevalue(2,2,Player)
            }
        }
        turncouunt+=1

        if (turncouunt==9){
            findViewById<TextView>(R.id.turn).setText("DRAW")

            initiliseboardstatus()
        }
        else if (Player ){
            findViewById<TextView>(R.id.turn).setText("PLAYER X TURN")

        }
        else{
            findViewById<TextView>(R.id.turn).setText("PLAYER Y TURN")

        }

        checkwinner()
    }
    fun initiliseboardstatus(){
        for (i:Int in 0..2){
            for (j:Int in 0..2){
                boardstatus[i][j]=-1
                board[i][j].isEnabled=true
                board[i][j].text=""
                Draw=false
            }
        }
    }
    fun updatevalue(row:Int, col:Int, Play:Boolean){
        Log.d(TAG, "onCreate: ")
        board[row][col].isEnabled=false
        val t:String=if (Play==true){"X"}
        else{
            "O"
        }
        val tt:Int=if (Play==true){1}
        else{
            0
        }
        val TAG="welcome"
        Log.d(TAG, "updatevalue: "+t+tt)
        board[row][col].setText(t)
            boardstatus[row][col]=tt

        Player=!Play
    }
    fun checkwinner(){
        for (i:Int in 0..2){
            if (boardstatus[i][0]==boardstatus[i][1] && boardstatus[i][0]==boardstatus[i][2]){
                if (boardstatus[i][0]==1){
                    findViewById<TextView>(R.id.turn).setText("PLAYER X is Winner")
                    disablebutton()
                    initiliseboardstatus()
                    break

                }
                if (boardstatus[i][0]==0){
                    findViewById<TextView>(R.id.turn).setText("PLAYER Y is Winner")
                    disablebutton()
                    initiliseboardstatus()
                    break

                }
            }

        }

        for (i:Int in 0..2){
            if (boardstatus[0][i]==boardstatus[1][i] && boardstatus[0][i]==boardstatus[2][i]){
                if (boardstatus[0][i]==1){
                    findViewById<TextView>(R.id.turn).setText("PLAYER X is Winner")
                    disablebutton()
                    initiliseboardstatus()
                    break

                }
                if (boardstatus[0][i]==0){
                    findViewById<TextView>(R.id.turn).setText("PLAYER Y is Winner")
                    disablebutton()
                    initiliseboardstatus()
                    break

                }
            }

        }
        if ((boardstatus[0][0]==boardstatus[1][1] && boardstatus[1][1]==boardstatus[2][2] )){
            if (boardstatus[0][0]==1){
                findViewById<TextView>(R.id.turn).setText("PLAYER X is Winner")
                disablebutton()
                initiliseboardstatus()


            }
            if (boardstatus[0][0]==0){
                findViewById<TextView>(R.id.turn).setText("PLAYER Y is Winner")
                disablebutton()
                initiliseboardstatus()


            }

        }

        if ((boardstatus[2][0]==boardstatus[1][1] && boardstatus[1][1]==boardstatus[0][2])){
            if (boardstatus[2][0]==1){
                findViewById<TextView>(R.id.turn).setText("PLAYER X is Winner")
                disablebutton()
                initiliseboardstatus()


            }
            if (boardstatus[2][0]==0){
                findViewById<TextView>(R.id.turn).setText("PLAYER Y is Winner")

                disablebutton()
                initiliseboardstatus()


            }

        }
    }
    fun disablebutton(){
        for (i in board){
            for (button in i){
                Log.d(TAG, "onCreate: i am here")
                button.isEnabled=false
            }

        }

    }
}