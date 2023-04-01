package com.example.androidfundamentalkotlin

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    // Best practice disimpan di lateinit
    // karena nantinya akan ada banyak component maka tidak disarankan menggunakan findViewById langsung
    private lateinit var nameEditText : EditText
    private lateinit var sayHelloButton : Button
    private lateinit var sayHelloTextView : TextView

    private fun initComponent(){
        nameEditText = findViewById(R.id.nameEditTable)
        sayHelloButton = findViewById(R.id.sayHelloButton)
        sayHelloTextView = findViewById(R.id.sayHelloTextView)
    }

    // Cek apakah device tersedia feature fingerprint atau tidak
    private fun checkFingerprint(){
        if(packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)){
            Log.i("FEATURE", "FEATURE FINGERPRINT ON")
        }else{
            Log.w("FEATURE", "FEATURE FINGERPRINT OFF")
        }
    }

    // Ceka apakah sdk nya dibawah dari system operation S
    private fun checkPlatformVersion(){
        Log.i("SDK", Build.VERSION.SDK_INT.toString())
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.S){
            Log.i("SDK", "Disable feature because SDK version is lower than 31")
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_world)

        initComponent()

        sayHelloTextView.text = "Hello"

        sayHelloButton.setOnClickListener {

            checkFingerprint()

            checkPlatformVersion()

            val sample = resources.openRawResource(R.raw.sample)
                .bufferedReader()
                .use { it.readText() }
            Log.i("RAW", sample)

            val json = assets.open("sample.json")
                .bufferedReader()
                .use { it.readText() }

            Log.i("ASSET", json)

            // untuk melihat log, mengeprint ke console, untuk melihatnya di Logcat bawah
            Log.d("Nur", "This is debug log")
            Log.i("Nur", "This is info log")
            Log.w("Nur", "This is warn log")
            Log.e("Main Activity", "Tis is error log")
            // Untuk mencari nya cepat bisa menggunakan Ctrl + spasi, lalu ketik Nur
            // Biasanya Tag nya adalah nama dari class dan componentnya

            Log.i("ValueResource",resources.getInteger(R.integer.maxPage).toString())
            Log.i("ValueResource",resources.getIntArray(R.array.numbers).joinToString(","))
            Log.i("ValueResource",resources.getBoolean(R.bool.isProductionMode).toString())
            Log.i("ValueResource", resources.getColor(R.color.background, theme).toString())
            sayHelloButton.setBackgroundColor(resources.getColor(R.color.background, theme))

            val name = nameEditText.text.toString()
            sayHelloTextView.text = "Hello $name"
        }

    }


//-----------------------------------------------------------------------------------------------
        // Cara awal
//        override fun onCreate(savedInstanceState: Bundle?) {
//            super.onCreate(savedInstanceState)
//            setContentView(R.layout.hello_world)

//        // cara mengambil id dari component, R adalah Class indux
//        val nameEditText : EditText = findViewById(R.id.nameEditTable)
//        val sayHelloButton : Button = findViewById(R.id.sayHelloButton)
//        val sayHelloTextView : TextView = findViewById(R.id.sayHelloTextView)
//
//        // Menampilkannya di layout component sebagai nilai default
//        sayHelloTextView.text = "Hi"
//
//        // Menambahkan listener dan menangkap nilai dari input text
//        sayHelloButton.setOnClickListener {
//            // lambda
//            val name = nameEditText.text.toString()
//            sayHelloTextView.text = "Hi $name"
//        }

//    }
}