package com.devmmurray.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel by lazy { ViewModelProvider(this).get(BigDecimalViewModel::class.java) }
        viewModel.stringResult.observe(this,
            Observer<String> { stringResult -> result.setText(stringResult)})
        viewModel.stringNewNumber.observe(this,
            Observer<String> { stringNumber -> newNumber.setText(stringNumber) })
        viewModel.stringOperation.observe(this,
            Observer<String> { stringOperation -> operation.text = stringOperation  })

        val listener = View.OnClickListener { v ->
            viewModel.digitPressed((v as Button).text.toString())
        }

        buttonClear.setOnClickListener {
            viewModel.clearPressed()
        }

        buttonNeg.setOnClickListener {
            viewModel.negPressed()
        }

        val opListener = View.OnClickListener { v ->
            viewModel.operandPressed((v as Button).text.toString())
        }

        buttonZero.setOnClickListener(listener)
        buttonOne.setOnClickListener(listener)
        buttonTwo.setOnClickListener(listener)
        buttonThree.setOnClickListener(listener)
        buttonFour.setOnClickListener(listener)
        buttonFive.setOnClickListener(listener)
        buttonSix.setOnClickListener(listener)
        buttonSeven.setOnClickListener(listener)
        buttonEight.setOnClickListener(listener)
        buttonNine.setOnClickListener(listener)
        buttonDot.setOnClickListener(listener)
        buttonParen.setOnClickListener(listener)
        buttonPlus.setOnClickListener(opListener)
        buttonMinus.setOnClickListener(opListener)
        buttonMultiply.setOnClickListener(opListener)
        buttonDivide.setOnClickListener(opListener)
        buttonEquals.setOnClickListener(opListener)
    }
}
