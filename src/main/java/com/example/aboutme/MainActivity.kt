package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.activity_main.*
import com.example.aboutme.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val myName:MyName= MyName("urbanus martin")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity.main)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName=myName //name value declared and used in xml layout file
        binding.doneButton. setOnClickListener {
            addNickname(it)
        }

       // findViewById<Button>(R.id.button_text).setOnClickListener{addNickname(it)}
    }



    private fun addNickname(view: View){
       // val editText=findViewById<EditText>(R.id.nickname_edit)
        //val nicknameTextView=findViewById<TextView>(R.id.nickname_text)
        binding.apply {
            nicknameText.text=binding.nicknameEdit.text
            myName?.nickname=nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility= GONE
            doneButton.visibility= GONE
            nicknameText.visibility= VISIBLE
        }
        //hide the keyboard
        val imm=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }
}

0089098997877887887877








