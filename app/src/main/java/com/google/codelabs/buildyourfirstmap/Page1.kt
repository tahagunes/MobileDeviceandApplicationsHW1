package com.google.codelabs.buildyourfirstmap

import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import kotlinx.android.synthetic.main.activity_page1.*
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast

class Page1 : AppCompatActivity() {
    private lateinit var btnSendData: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page1)
        var durakismi=""
        var sifat=""
        var durak=""
        var cins=""
        var yazilim=""



        var duraklar = resources.getStringArray(R.array.station_arrays)
        if( spinner2 != null){
            val adapter= ArrayAdapter(this,android.R.layout.simple_spinner_item,duraklar)
            spinner2.adapter = adapter

            spinner2.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    //Toast.makeText(applicationContext,"seçilen :" + duraklar[p2],
                    //Toast.LENGTH_SHORT).show()
                    durak= duraklar[p2]
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }
            }
        }


        button2.setOnClickListener{

            sifat= isimal.text.toString()
            if(checkBox.isChecked)
            {yazilim+=" "+checkBox.text}
            //kotlin
            if(checkBox2.isChecked)
            {yazilim+=" "+checkBox2.text}
            //flutter
            if(checkBox3.isChecked)
            {yazilim+=" "+checkBox3.text}





            //java

            textView12.text=sifat + "\n" + durak + "\n" + yazilim + "\n" + cins

            yazilim=""


            val Intent =  Intent(this,Page2::class.java).putExtra("deneme",textView12.text.toString())
            startActivity(Intent)
        }
        radioGroup.setOnCheckedChangeListener{ group , checkID ->
            if(R.id.radioButtonD==checkID)
                cins= radioButtonD.text.toString()
            if(R.id.radioButtonK==checkID)
                cins= radioButtonK.text.toString()
            if(R.id.radioButtonE==checkID)
                cins= radioButtonE.text.toString()
        }
    }
}