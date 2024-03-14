package mmcs.assignment3_calculator.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.ObservableField
import kotlin.math.abs

class CalculatorViewModel: BaseObservable(), Calculator {
    override var display = ObservableField<String>()

    val eps = 0.000000001
    val e = 1000000.0
    var wasPoint: Boolean = false
    var wasСompute: Boolean = false
    var digit: Double = 0.0
    var digit2: String = ""
    var lastDigit: Double? = 0.0
    var k: Int = 10
    var operation: Operation? = null

    override fun addDigit(dig: Int) {
        if (!wasСompute){
            if (wasPoint){
                digit2 += dig
                digit += dig / (k + 0.0)
                k*=10
                display.set(""+digit.toInt()+"."+digit2)
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
        digit2 = ""
        k = 10
        wasPoint = false
        wasСompute = false
        operation = op
    }

    override fun compute() {
        var b = true
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
                        display.set("ERROR")
                        digit = 0.0
                        b = false
                    }
                }
                else -> {}
            }
            lastDigit = null
            wasСompute = true
            if (b){
                var dInt1 = digit.toInt()
                if (abs(dInt1 - digit) < eps){
                    display.set(""+digit.toInt())
                }else{
                    display.set(""+(digit*e).toInt() / e)
                }
            }
        }
    }

    override fun clear() {
        lastDigit = null
        digit = 0.0
        digit2 = ""
        k = 10
        wasPoint = false
        wasСompute = false
        operation = null
        display.set("0")
    }

}