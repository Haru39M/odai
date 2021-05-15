package app.wakayama.harusame.count_0509_new

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val array_command = arrayOf("↑","↓","→","←")//配列
        var array_index:Int = 0//配列のインデックス

        var teach_val:String = "teacher"
        var student_val:String = "student"
        student.text = student_val
        teach.text = teach_val

        var score:Int = 0

        fun gameOver(){
            iconStudent.text = "(TAT)"
            iconTeacher.text = "<(▼A▼#)>"
        }

        var second = 60
        val timer: CountDownTimer = object : CountDownTimer(60000,1000) {
            override fun onFinish() {
                gameOver()
            }

            override fun onTick(millisUntilFinished: Long) {
                TODO("Not yet implemented")
            }

        }

        iconTeacher.text = "＜(▼__▼)＞"//init
        iconStudent.text = "(-_-)"//init

        upButton.setOnClickListener{
            student_val += "↑"
            student.text = student_val
        }
        downButton.setOnClickListener{
            student_val += "↓"
            student.text = student_val
        }
        rightButton.setOnClickListener{
            student_val += "→"
            student.text = student_val
        }
        leftButton.setOnClickListener{
            student_val += "←"
            student.text = student_val
        }

        fun init(){
            teach_val = ""//init
            student_val = ""//init
            for (i in 1..5) {
                array_index = Random.nextInt(3)//0~3の数値をランダムに取得
                teach_val += array_command[array_index]
            }
            teach.text = teach_val
            student.text = student_val
        }

        startButton.setOnClickListener{
            score = 0//init
            scoreLabel.text = score.toString()//init

            init()

        }



        checkButton.setOnClickListener{
            if(teach_val == student_val){
                iconStudent.text = "(^o<). *ミ☆"
                iconTeacher.text = "<(▼w▼)>"
                score += 10
                scoreLabel.text = score.toString()
            }else{
                gameOver()
            }
            init()
        }
    }
}