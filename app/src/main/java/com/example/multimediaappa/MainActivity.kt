package com.example.multimediaappa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    var menu = arrayOf(
        "Audio",
        "Video",
        "Camara",
        "TextToSpeech"
    )
    var activities = arrayOf(
        "AudioActivity",
        "VideoActivity",
        "CamaraActivity",
        "TextToSpeechActivity"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, menu
        )
        val listView: ListView = findViewById(R.id.listview_1)
        listView.setAdapter(adapter)
        listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                var nombreClase = activities[position]
                try {
                    var activity =
                        Class.forName("multimediaappaa.$nombreClase")
                    var numbersIntent = Intent(this@MainActivity, activity)
                    startActivity(numbersIntent)
                } catch (e: ClassNotFoundException) {
                    e.printStackTrace()
                }
            }

    }
}