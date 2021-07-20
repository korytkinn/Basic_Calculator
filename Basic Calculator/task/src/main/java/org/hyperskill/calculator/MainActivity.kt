package org.hyperskill.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.math.abs
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText: EditText = findViewById(R.id.editText)
        val button0: Button = findViewById(R.id.button0)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button9)
        val clearButton: Button = findViewById(R.id.clearButton)
        val dotButton: Button = findViewById(R.id.dotButton)

        //operation buttons
        val addButton: Button = findViewById(R.id.addButton)
        val subtractButton: Button = findViewById(R.id.subtractButton)
        val multiplyButton: Button = findViewById(R.id.multiplyButton)
        val divideButton: Button = findViewById(R.id.divideButton)

        val equalButton: Button = findViewById(R.id.equalButton)

        var firstValue: Double = 0.0
        var secondValue: Double = 0.0
        var operation: String = ""
        var result: Double = 0.0
        var clicks: Int = 0
        var secondNew: Double = 0.0  /// new LOGIC


        addButton.setOnClickListener {
            /*
            firstValue = editText.text.toString().toDouble()
            operation = "+"
            editText.setText("")
*/

            if (editText.text.toString() == "") {
                editText.setText("")
            } else {
                firstValue = editText.text.toString().toDouble()
                operation = "+"
                editText.setText("")
                secondNew = 0.0
                clicks = 0


                val firstHint: Int = firstValue.toInt()
                if (firstValue - firstHint.toDouble() == 0.0) {
                    editText.setHint("${firstValue.toInt()}")
                } else {
                    editText.setHint("$firstValue")
                }
            }
        }

        subtractButton.setOnClickListener {

            if (editText.text.toString() == "") {
                editText.setText("-")
            } else {
                firstValue = editText.text.toString().toDouble()
                operation = "-"
                editText.setText("")
                secondNew = 0.0
                clicks = 0
//                editText.setHint("${firstValue.toInt()}") //new
//                editText.setHint("$firstValue") //new

                val firstHint: Int = firstValue.toInt()
                if (firstValue - firstHint.toDouble() == 0.0) {
                    editText.setHint("${firstValue.toInt()}")
                } else {
                    editText.setHint("$firstValue")
                }

            }

        }

        multiplyButton.setOnClickListener {
            firstValue = editText.text.toString().toDouble()
            operation = "*"
            editText.setText("")

            val firstHint: Int = firstValue.toInt()
            if (firstValue - firstHint.toDouble() == 0.0) {
                editText.setHint("${firstValue.toInt()}")
            } else {
                editText.setHint("$firstValue")
            }
        }

        divideButton.setOnClickListener {
            firstValue = editText.text.toString().toDouble()
            operation = "/"
            editText.setText("")
            secondNew = 0.0
            clicks = 0

            val firstHint: Int = firstValue.toInt()
            if (firstValue - firstHint.toDouble() == 0.0) {
                editText.setHint("${firstValue.toInt()}")
            } else {
                editText.setHint("$firstValue")
            }
        }


        equalButton.setOnClickListener {
            if (operation == "") {
                editText.setText("0")
            }

            secondValue = editText.text.toString().toDouble()
            if (operation == "+") {
//                result = firstValue + secondValue
//                clicks = 0
//                editText.setText("$result")
                if (clicks == 0) {
                    result = firstValue + secondValue
                    clicks++
                    operation = "+"
                    secondNew = secondValue
                } else {
                    result = result + secondNew
                }

                val res: Int = result.toInt()
                if (result - res.toDouble() == 0.0) {
                    editText.setText("${result.toInt()}")
                } else {
                    editText.setText("$result")
                }
            }
            if (operation == "-") {

                if (clicks == 0) {
                    result = firstValue - secondValue
                    clicks++
                    operation = "-"
                    secondNew = secondValue
                } else {
                    result = result - secondNew
                }

                val res: Int = result.toInt()
                if (result - res.toDouble() == 0.0) {
                    editText.setText("${result.toInt()}")
                } else {
                    editText.setText("$result")
                }
            }
            if (operation == "*") {
//                result = firstValue * secondValue
//                clicks = 0
                if (clicks == 0) {
                    result = firstValue * secondValue
                    clicks++
                    operation = "*"
                    secondNew = secondValue
                } else {
                    result = result * secondNew
                }


//                editText.setText("$result")
                val res: Int = result.toInt()
                if (result - res.toDouble() == 0.0) {
                    editText.setText("${result.toInt()}")
                } else {
                    editText.setText("$result")
                }
            }
            if (operation == "/") {
//                result = firstValue / secondValue
//                editText.setText("$result")

                if (clicks == 0) {
                    result = firstValue / secondValue
                    clicks++
                    operation = "/"
                    secondNew = secondValue
                } else {
                    result = result / secondNew
                }


                val res: Int = result.toInt()
                if (result - res.toDouble() == 0.0) {
                    editText.setText("${result.toInt()}")
                } else {
                    editText.setText("$result")
                }
            }
            editText.setHint("0")
        }

        clearButton.setOnClickListener {
            editText.setText("")
            editText.setHint("0")
            operation = ""
            secondNew = 0.0
            clicks = 0

        }

        dotButton.setOnClickListener {
            // new logic here
//            editText.append(".")
            if (editText.text.toString() == "") {
                editText.setText("0.")
            } else {
                editText.append(".")
            }
        }

        button0.setOnClickListener {
            if (editText.text.toString() == "0") {
                editText.setText("0")
            } else {
                editText.append("0")
            }
        }
        button1.setOnClickListener {
            editText.append("1")
        }
        button2.setOnClickListener {
            editText.append("2")
        }
        button3.setOnClickListener {
            editText.append("3")
        }
        button4.setOnClickListener {
            editText.append("4")
        }
        button5.setOnClickListener {
            editText.append("5")
        }
        button6.setOnClickListener {
            editText.append("6")
        }
        button7.setOnClickListener {
            editText.append("7")
        }
        button8.setOnClickListener {
            editText.append("8")
        }
        button9.setOnClickListener {
            editText.append("9")
        }


    }
}