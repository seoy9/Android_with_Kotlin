package dalc.hsy.lotto

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        //코드에서 View에 이벤트 리스너를 설정하는 방법
        //버튼과 같은 View가 클릭되었을 때 실행될 listener를 등록하는 메소드가 setOnClickListener
        findViewById<View>(R.id.button).setOnClickListener {
            //MainActivity를 시작하는 Intent를 생성
            val intent = Intent(this@TestActivity, MainActivity::class.java)
            //intent를 사용하여 Activity를 시작
            startActivity(intent)
        }

        findViewById<View>(R.id.button2).setOnClickListener {
            //ConstellationActivity를 시작하는 Intent를 생성
            val intent = Intent(this@TestActivity, ConstellationActivity::class.java)
            //intent를 사용하여 Activity를 시작
            startActivity(intent)
        }

        findViewById<View>(R.id.button3).setOnClickListener {
            //NameActivity를 시작하는 Intent를 생성
            val intent = Intent(this@TestActivity, NameActivity::class.java)
            //intent를 사용하여 Activity를 시작
            startActivity(intent)
        }

        findViewById<View>(R.id.button4).setOnClickListener {
            //ResultActivity를 시작하는 Intent를 생성
            val intent = Intent(this@TestActivity, ResultActivity::class.java)
            //intent를 사용하여 Activity를 시작
            startActivity(intent)
        }
    }

    fun callWeb(view: View) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.naver.com"))
        startActivity(intent)
    }
}