package com.hxl.alarmdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        var a = 1
        var b = 2
        var c = 3
        if (a < c)
            Log.e("hxl",""+a)
        if (a is Int){
            Log.e("hxl","a is Int")
        }

        breakLoop()
        var max = function01(3,8)
        Log.e("hxl","max = "+max)
    }

    // 方法带有返回值的三种写法

    fun sum (a : Int,b : Int):Int{
        return a+b
    }

    fun sum0(a:Int,b:Int): Int = a+b

    fun sum1(a:Int,b:Int) = a+b

    //方法调用
    fun printSum(a:Int,b:Int) :Unit = print(sum(a,b))

    //选择语句
    fun max(a: Int,b: Int): Int = if (a > b) a else b

    fun max01(a: Int,b: Int):Int{
        if (a>b)
            return a
        else
            return b
    }
    //类型检测
    fun stringLength(obj: Any) :Int?{
        if (obj is String){
            return obj.length
        }else{
            return null
        }
    }

    //for循环 使用in关键字
    fun loop(args:Array<String>){
        for (arg in args){
            print(arg)
        }

        for (i in args.indices){
            print(args[i])
        }

        for ((index,value) in args.withIndex()){
            print("index:$index,value:$value")
        }
    }

    //when语句判断，相当于switch
    fun findSpecial(){
        var you = 1
        when(you){
            1 -> print("you:$you")
            2 -> print("you are not mine")
            else -> print(you)
        }

        var a = 4
        when(a){
            in 1..10 -> print("a is the range")
            !in 2..8 -> print("a is outside the range")
        }
    }

    //跳出循环标签lable
    fun breakLoop(){
        var numbers = arrayOf(1,2,3,4,5)
       label1@ for (num in numbers){
            if (num == 4){
                break@label1
            }
           Log.e("hxl","num"+num)
       }
    }



    //两个数的最大值
    fun function01(a:Int,b:Int):Int{
        var max:Int
        if(a > b){
            max = a
        }else{
            max = b
        }
        return max
    }

    fun maxValue(a:Int,b: Int):Int{
        var max = if(a>b) b else a
        return max
    }

    fun maxMaxValue(a:Int,b:Int):Int{
        var max = if (a>b){
            a
        }else{
            b
        }
        return max
    }

    open class person(name:String,age:Int){
       open fun h(){}
    }
    class child(childName:String,childAge:Int):person(childName,childAge){
         override fun h(){
         }
    }


}


