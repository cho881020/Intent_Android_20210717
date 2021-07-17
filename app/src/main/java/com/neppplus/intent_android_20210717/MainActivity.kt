package com.neppplus.intent_android_20210717

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        DIAL버튼 누르면 => 입력한 폰번을 받아와서 => 거기로 전화 걸기 (DIAL) 실행 (Intent).

        dialBtn.setOnClickListener {

            val inputPhoneNum = phoneNumEdt.text.toString()

//            DIAL Intent 사용.
//            1. 어디에 전화를 걸 것인가? (폰번이 뭔가?) : Uri 에 담아준다. => inputPhoneNum에 저장된 번호 활용.
            val myUri = Uri.parse("tel:${inputPhoneNum}")

//            2. 어떤 종류의 행동 (Intent)를 사용할것인가? => 전화 or 문자 or 인터넷 등등..
            val myIntent = Intent(Intent.ACTION_DIAL, myUri)

//            3. startActivity 화면 실행.
            startActivity(myIntent)


        }


        callBtn.setOnClickListener {
            val inputPhoneNum = phoneNumEdt.text.toString()
            val myUri = Uri.parse("tel:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_CALL, myUri)
            startActivity(myIntent)
        }

        smsBtn.setOnClickListener {
            val inputPhoneNum = phoneNumEdt.text.toString()
            val myUri = Uri.parse("smsto:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_SENDTO, myUri)
            myIntent.putExtra("sms_body", "테스트용 문구입니다.")
            startActivity(myIntent)
        }

    }
}