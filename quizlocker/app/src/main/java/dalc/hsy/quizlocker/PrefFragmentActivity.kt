package dalc.hsy.quizlocker

import android.preference.PreferenceFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PrefFragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pref_fragment)
        //액티비티의 컨텐트 뷰를 MyPrefFragment로 교체
        fragmentManager.beginTransaction().replace(android.R.id.content, MyPrefFragment()).commit()
    }

    //PreferenceFragment: XML로 작성한 Preference를 UI로 보여주는 클래스
    class MyPrefFragment : PreferenceFragment() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            //Preference 정보가 있는 XML 파일 지정
            addPreferencesFromResource(R.xml.ex_pref)
        }
    }
}