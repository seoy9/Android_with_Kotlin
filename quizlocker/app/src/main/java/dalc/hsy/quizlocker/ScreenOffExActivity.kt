package dalc.hsy.quizlocker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.IntentFilter

class ScreenOffExActivity : AppCompatActivity() {
    //ScreenOffReceiver 객체
    var screenOffReceiver: ScreenOffReceiver? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_off_ex)

        //screenOffReceiver가 null인 경우에만 screenOffReceiver를 생성하고 등록
        if(screenOffReceiver == null) {
            screenOffReceiver = ScreenOffReceiver()
            val intentFilter = IntentFilter(Intent.ACTION_SCREEN_OFF)
            registerReceiver(screenOffReceiver, intentFilter)
        }
    }
}