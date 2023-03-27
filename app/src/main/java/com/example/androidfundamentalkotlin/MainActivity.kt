package com.example.androidfundamentalkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_world)

        initComponent()

        sayHelloTextView.text = "Hello"

        sayHelloButton.setOnClickListener {

            // untuk melihat log, mengeprint ke console, untuk melihatnya di Logcat bawah
            Log.d("Nur", "This is debug log")
            Log.i("Nur", "This is info log")
            Log.w("Nur", "This is warn log")
            Log.e("Main Activity", "Tis is error log")
            // Untuk mencari nya cepat bisa menggunakan Ctrl + spasi, lalu ketik Nur
            // Biasanya Tag nya adalah nama dari class dan componentnya

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