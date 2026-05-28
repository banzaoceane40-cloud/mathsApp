package za.ac.iie.mathsapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var editBirthday = findViewById<EditText>(R.id.birthdayTextInput)
        var buttonCalculate = findViewById<Button>(R.id.submitButton)
        var textTotal = findViewById<TextView>(R.id.textNum)

        buttonCalculate.setOnClickListener{
            var birthday = editBirthday.text.toString().toInt()
            var total = calculateBirthday(birthday)
            textTotal.text = "Your total: $total"
        }
        fun calculateBirthday(num: Int): Int{
            var birthday = num

            birthday = birthday+10
            birthday = birthday*3
            birthday = birthday-5
            birthday = birthday/2

            return birthday

        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}