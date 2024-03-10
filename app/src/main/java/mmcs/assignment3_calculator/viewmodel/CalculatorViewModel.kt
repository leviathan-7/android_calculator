package mmcs.assignment3_calculator.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.ObservableField

class CalculatorViewModel: BaseObservable(), Calculator {
    override var display = ObservableField<String>()

    var wasPoint: Boolean = false
    var wasСompute: Boolean = false
    var digit: Double = 0.0
    var lastDigit: Double? = 0.0
    var k: Int = 10
    var operation: Operation? = null

    override fun addDigit(dig: Int) {
        if (!wasСompute){
            if (wasPoint){
                digit += dig / (k + 0.0)
                k*=10
                display.set(""+digit)
            }else{
                digit = 10 * digit + dig
                display.set(""+digit.toInt())
            }
        }
    }

    override fun addPoint() {
        if (!wasСompute){
            wasPoint = true
            display.set(""+digit.toInt()+".")
        }
    }

    override fun addOperation(op: Operation) {
        if (operation != null){
            compute()
        }
        lastDigit = digit
        digit = 0.0
        k = 10
        wasPoint = false
        wasСompute = false
        operation = op
        display.set("0")
    }

    override fun compute() {
        if (lastDigit != null){
            when (operation) {
                Operation.ADD -> {
                    digit+=lastDigit!!
                }
                Operation.SUB -> {
                    digit = lastDigit!! - digit
                }
                Operation.MUL -> {
                    digit*=lastDigit!!
                }
                Operation.DIV -> {
                    if (digit != 0.0){
                        digit = lastDigit!! / digit
                    }
                    else{
                        digit = 0.0
                    }
                }
                else -> {}
            }
            lastDigit = null
            wasСompute = true
            display.set(""+digit)
        }
    }

    override fun clear() {
        lastDigit = null
        digit = 0.0
        k = 10
        wasPoint = false
        wasСompute = false
        operation = null
        display.set("0")
    }

}