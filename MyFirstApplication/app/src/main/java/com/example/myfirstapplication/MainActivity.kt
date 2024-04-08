package com.example.myfirstapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.widget.TextView
import android.widget.EditText
import java.util.Collections
import java.util.Arrays

class MainActivity: AppCompatActivity() {

    var textView: TextView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textView = findViewById(R.id.textView2);
    }

    fun generateSeries(view: View) {
        //System.out.println("Button Clicked!");
        if (textView == null) {
            textView = findViewById(R.id.textView2);
        }
        var seriesSize: EditText?;
        seriesSize = findViewById(R.id.editTextNumber);

        var elements: Array<Int> = Array(seriesSize.getText().toString().toInt(), {0});
        for (i in 1..seriesSize.getText().toString().toInt()) {
            elements[i-1] = i;
        }

        var intList: List<Int> = elements.toList();

        Collections.shuffle(intList);

        textView?.setText(intList.joinToString(" , "));

    }

}