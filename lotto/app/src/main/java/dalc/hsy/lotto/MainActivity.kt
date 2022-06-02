package dalc.hsy.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //랜덤으로 번호 생성 카드의 클릭 이벤트 리스너
        findViewById<View>(R.id.randomCard).setOnClickListener {
            //ResultActivity를 시작하는 Intent 생성
            val intent = Intent(this, ResultActivity::class.java)
            //intent에 결과 데이터를 전달
            //int 리스트를 전달하므로 putIntegerArrayListExtra 사용
            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getShuffleLottoNumbers()))
            startActivity(intent)
        }

        //별자리로 번호 생성 카드의 클릭 이벤트 리스너
        findViewById<View>(R.id.constellationCard).setOnClickListener {
            //ResultActivity를 시작하는 Intent 생성
            val intent = Intent(this, ConstellationActivity::class.java)
            startActivity(intent)
        }

        //이름으로 번호 생성 카드의 클릭 이벤트 리스너
        findViewById<View>(R.id.nameCard).setOnClickListener {
            //ResultActivity를 시작하는 Intent 생성
            val intent = Intent(this, NameActivity::class.java)
            startActivity(intent)
        }
    }
}