package com.example.mycalculator

import android.bluetooth.BluetoothClass
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var zero:TextView
    lateinit var one:TextView
    lateinit var two:TextView
    lateinit var three:TextView
    lateinit var four:TextView
    lateinit var five:TextView
    lateinit var six:TextView
    lateinit var seven:TextView
    lateinit var eight:TextView
    lateinit var nine:TextView
    lateinit var dot:TextView
    lateinit var plus:TextView
    lateinit var minus:TextView
    lateinit var multi:TextView
    lateinit var devide:TextView
    lateinit var expression:TextView
    lateinit var result:TextView
    lateinit var backspace:ImageView

    lateinit var tvClick:String
    var firstNumber = ""
    var operator = "+"
    var expressionTV:String=""
    var isNewOp : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        zero = findViewById(R.id.tvZero)
        one = findViewById(R.id.tvOne)
        two = findViewById(R.id.tvTwo)
        three = findViewById(R.id.tvThree)
        four = findViewById(R.id.tvFour)
        five = findViewById(R.id.tvFive)
        six = findViewById(R.id.tvSix)
        seven =findViewById(R.id.tvSeven)
        eight = findViewById(R.id.tvEight)
        nine = findViewById(R.id.tvNine)
        plus = findViewById(R.id.tvPlus)
        minus = findViewById(R.id.tvMinus)
        multi = findViewById(R.id.tvMultiply)
        devide = findViewById(R.id.tvDivision)
        dot = findViewById(R.id.tvDot)
        backspace= findViewById(R.id.tvBack)

        expression = findViewById(R.id.tvExpression)
        result = findViewById(R.id.tvResult)

        tvClick = expression.text.toString()
    }

    fun numberEvent(view: View) {
        if(isNewOp)
            expression.text=""
        isNewOp = false

        val tvSelected:TextView = view as TextView

        when(tvSelected.id){

            zero.id -> {tvClick += "0"}
            one.id -> {tvClick += "1"}
            two.id -> {tvClick += "2"}
            three.id -> {tvClick += "3"}
            four.id -> {tvClick += "4"}
            five.id -> {tvClick += "5"}
            six.id -> {tvClick += "6"}
            seven.id -> {tvClick += "7"}
            eight.id -> {tvClick += "8"}
            nine.id -> {tvClick += "9"}
            dot.id->{tvClick += "."}

        }
        expression.text =expressionTV+" "+tvClick

    }

    fun operatorEvent(view: View) {
        if(isNewOp){
            firstNumber = result.text.toString()
            tvClick = firstNumber
            isNewOp=false
        }else {
            firstNumber = expression.text.toString()
        }
        val tvSelect = view as TextView

        when(tvSelect.id){

            plus.id -> {operator = "+"}
            minus.id -> {operator = "-"}
            multi.id -> {operator = "*"}
            devide.id -> {operator = "/"}

        }

        expression.text = tvClick+" "+operator

        expressionTV = expression.text.toString()
        tvClick=""

    }

    fun equalEvent(view: View) {

        val secondNumber = tvClick
        var rslt = 0.0

        when(operator){

            "+" ->{rslt = firstNumber.toDouble() + secondNumber.toDouble()}
            "-" ->{rslt = firstNumber.toDouble() - secondNumber.toDouble()}
            "*" ->{rslt = firstNumber.toDouble() * secondNumber.toDouble()}
            "/" ->{rslt = firstNumber.toDouble() / secondNumber.toDouble()}

        }
        result.text = rslt.toString()
        isNewOp = true
    }

    fun cancelEvent(view: View) {
        expressionTV=""
        tvClick=""
        expression.text= "0"
        result.text= "0"
        isNewOp = true

    }

//    fun backspaceEvent(view: View) {
//        val string= expression.text.toString()
//         if (string.isNotEmpty()){
//             expression.text=string.substring(0,string.length-1)
//         }
//        result.text=""
//    }
}