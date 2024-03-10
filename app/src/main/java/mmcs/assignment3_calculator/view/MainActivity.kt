package mmcs.assignment3_calculator.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import mmcs.assignment3_calculator.R
import mmcs.assignment3_calculator.databinding.ActivityMainBinding
import mmcs.assignment3_calculator.viewmodel.Calculator
import mmcs.assignment3_calculator.viewmodel.CalculatorViewModel
import mmcs.assignment3_calculator.viewmodel.Operation

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding : ActivityMainBinding
    private lateinit var viewModel: Calculator

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = CalculatorViewModel()

        mainBinding.viewModel = viewModel

        textView = findViewById(R.id.textView)
    }

    fun addPoint(view: View){
        viewModel.addPoint()
        textView.text = viewModel.display.get()
    }
    fun addDigit0(view: View){
        viewModel.addDigit(0)
        textView.text = viewModel.display.get()
    }
    fun addDigit1(view: View){
        viewModel.addDigit(1)
        textView.text = viewModel.display.get()
    }
    fun addDigit2(view: View){
        viewModel.addDigit(2)
        textView.text = viewModel.display.get()
    }
    fun addDigit3(view: View){
        viewModel.addDigit(3)
        textView.text = viewModel.display.get()
    }
    fun addDigit4(view: View){
        viewModel.addDigit(4)
        textView.text = viewModel.display.get()
    }
    fun addDigit5(view: View){
        viewModel.addDigit(5)
        textView.text = viewModel.display.get()
    }
    fun addDigit6(view: View){
        viewModel.addDigit(6)
        textView.text = viewModel.display.get()
    }
    fun addDigit7(view: View){
        viewModel.addDigit(7)
        textView.text = viewModel.display.get()
    }
    fun addDigit8(view: View){
        viewModel.addDigit(8)
        textView.text = viewModel.display.get()
    }
    fun addDigit9(view: View){
        viewModel.addDigit(9)
        textView.text = viewModel.display.get()
    }
    fun clear(view: View){
        viewModel.clear()
        textView.text = viewModel.display.get()
    }
    fun compute(view: View){
        viewModel.compute()
        textView.text = viewModel.display.get()
    }
    fun add(view: View){
        viewModel.addOperation(Operation.ADD)
        textView.text = viewModel.display.get()
    }
    fun sub(view: View){
        viewModel.addOperation(Operation.SUB)
        textView.text = viewModel.display.get()
    }
    fun mul(view: View){
        viewModel.addOperation(Operation.MUL)
        textView.text = viewModel.display.get()
    }
    fun div(view: View){
        viewModel.addOperation(Operation.DIV)
        textView.text = viewModel.display.get()
    }
}