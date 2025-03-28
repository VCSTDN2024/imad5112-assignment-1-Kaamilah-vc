package vcmsa.ci.mealsuggestion

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var mealText: EditText
    private lateinit var buttonMeal: Button
    private lateinit var displaymeal: TextView
    private lateinit var resetbutton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        mealText = findViewById(R.id.mealText)
        buttonMeal = findViewById(R.id.buttonMeal)
        displaymeal = findViewById(R.id.displaymeal)
        resetbutton = findViewById(R.id.resetbutton)

        buttonMeal.setOnClickListener{ // added functionality to the meal button
            handleButtonMealClick()
        }
        resetbutton.setOnClickListener{
            handleResetButtonClick()
        }
    } // use the if and else statment

     private fun handleResetButtonClick(){
         displaymeal.text = ""
     }
    private fun handleButtonMealClick(){
        val mealInput = mealText.text.toString().trim().lowercase()
        if(mealInput.isEmpty()){
            displaymeal.text = "Enter the time of day"
            return
        }


        when(mealInput){
            "morning"  -> displaymeal.text = "Pancakes, Omelette ,Smootie"
            "mid-morning" -> displaymeal.text = "Muffins, Fruit Salad, Buscuits"
            "afternoon" -> displaymeal.text = "Chips, Sandwich, Wrap"
            "mid-afternoon" -> displaymeal.text = "Yogurt, Ice Cream, Boiled Eggs"
            "dinner" -> displaymeal.text = "Soup, Pasta, Pizza"
            "after-dinner" -> displaymeal.text = "Cheesecake, Brownie, Pudding"

            else -> {
            }
        }
    }
}



