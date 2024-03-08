package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.roundToInt


class BlankFragment : Fragment() {
    private lateinit var textView: TextView
    private lateinit var button0: Button
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var buttond: Button
    private lateinit var buttonm: Button
    private lateinit var button_: Button
    private lateinit var buttonr: Button
    private lateinit var buttonp: Button
    private lateinit var buttonx: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView = view.findViewById(R.id.textView)
        button0 = view.findViewById(R.id.button0) // 0
        button1 = view.findViewById(R.id.button1) // 1
        button2 = view.findViewById(R.id.button2) // 2
        button3 = view.findViewById(R.id.button3) // 3
        button4 = view.findViewById(R.id.button4) // 4
        button5 = view.findViewById(R.id.button5) // 5
        button6 = view.findViewById(R.id.button6) // 6
        button7 = view.findViewById(R.id.button7) // 7
        button8 = view.findViewById(R.id.button8) // 8
        button9 = view.findViewById(R.id.button9) // 9
        buttonp = view.findViewById(R.id.buttonp) // кнопка "+"
        buttonm = view.findViewById(R.id.buttonm) // кнопка "-"
        buttond = view.findViewById(R.id.buttond) // кнопка "delete"
        button_ = view.findViewById(R.id.button_) // кнопка "/"
        buttonx = view.findViewById(R.id.buttonx) // кнопка "x"
        buttonr = view.findViewById(R.id.buttonr) // кнопка "="

        buttonr.setOnClickListener {
            val expression = textView.text
            val elements = expression.split("[+/*-]".toRegex()).toTypedArray() // ["2", "3", "4"]
            var result = elements[0].toDouble() // 2.0
            for (i in 1 until elements.size) {
                val operator =
                    expression.substring(elements[i - 1].length, elements[i - 1].length + 1)
                val number = elements[i].toDouble()
                when (operator) {
                    "+" -> result += number
                    "-" -> result -= number
                    "/" -> result /= number
                    "*" -> result *= number
                }
            }
            textView.text = result.toString()

        }
        button0.setOnClickListener { addButtonText(it as Button) }
        button1.setOnClickListener { addButtonText(it as Button) }
        button2.setOnClickListener { addButtonText(it as Button) }
        button3.setOnClickListener { addButtonText(it as Button) }
        button4.setOnClickListener { addButtonText(it as Button) }
        button5.setOnClickListener { addButtonText(it as Button) }
        button6.setOnClickListener { addButtonText(it as Button) }
        button7.setOnClickListener { addButtonText(it as Button) }
        button8.setOnClickListener { addButtonText(it as Button) }
        button9.setOnClickListener { addButtonText(it as Button) }
        buttonp.setOnClickListener { addButtonText(it as Button) }
        buttonm.setOnClickListener { addButtonText(it as Button) }
        buttond.setOnClickListener { addButtonText(it as Button) }
        button_.setOnClickListener { addButtonText(it as Button) }
        buttonx.setOnClickListener { addButtonText(it as Button) }
    }
    @SuppressLint("SetTextI18n")
    private fun addButtonText(button: Button) {
        val string = textView.text
        val buttonText = button.text.toString()
        if (string.length < 160) {
            when (buttonText) {
                "0" -> textView.text = textView.text.toString() + "0"
                "1" -> textView.text = textView.text.toString() + "1"
                "2" -> textView.text = textView.text.toString() + "2"
                "3" -> textView.text = textView.text.toString() + "3"
                "4" -> textView.text = textView.text.toString() + "4"
                "5" -> textView.text = textView.text.toString() + "5"
                "6" -> textView.text = textView.text.toString() + "6"
                "7" -> textView.text = textView.text.toString() + "7"
                "8" -> textView.text = textView.text.toString() + "8"
                "9" -> textView.text = textView.text.toString() + "9"
                "-" -> textView.text = textView.text.toString() + "-"
                "+" -> textView.text = textView.text.toString() + "+"
                "/" -> textView.text = textView.text.toString() + "/"
                "*" -> textView.text = textView.text.toString() + "*"
                "x" -> textView.text = textView.text.toString() + "*"
                "←" -> {
                    val newStr = string.dropLast(1)
                    textView.text = newStr
                }
            }
        }
    }
}