package dalc.hsy.quizlocker

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pref_ex.*

class PrefExActivity : AppCompatActivity() {
    //nameField의 데이터를 저장할 Key
    val nameFieldKey = "nameField"

    //pushCkeckBox의 데이터를 저장할 Key
    val pushCheckBoxKey = "pushCheckBox"

    //shared preference 객체, Activity 초기화 이후에 사용해야 하기 때문에 lazy 위임 사용
    val preference by lazy {getSharedPreferences("PrefExActivity", Context.MODE_PRIVATE)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pref_ex)

        //저장 버튼이 클릭된 경우
        saveButton2.setOnClickListener {
            //SharedPreference에서 nameFieldKey 키 값으로 nameField의 현재 텍스트를 저장
            preference.edit().putString(nameFieldKey, nameField.text.toString()).apply()

            //SharedPreference에서 pushCheckBoxKey 키 값으로 체크 박스의 현재 체크 상태를 저장
            preference.edit().putBoolean(pushCheckBoxKey, pushCheckBox.isChecked).apply()
        }

        //불러오기 버튼이 클릭된 경우
        loadButton2.setOnClickListener {
            //SharedPreference에서 nameFieldKey로 저장된 문자열을 불러와 nameField의 텍스트로 설정
            nameField.setText(preference.getString(nameFieldKey, ""))

            //SharedPreference에서 pushCheckBoxKey 키 값으로 불린 값을 불러와 pushCheckBox의 체크상태를 설정
            pushCheckBox.isChecked = preference.getBoolean(pushCheckBoxKey, false)
        }
    }
}