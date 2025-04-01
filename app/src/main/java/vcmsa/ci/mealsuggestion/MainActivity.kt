package vcmsa.ci.mealsuggestion
// REFERENCE LIST
 // Kotlin for developers. 2024. “Write Conditionals in Kotlin  |  Android Developers”.
// Android Developers. 2024 <https://developer.android.com/codelabs/basic-android-kotlin-compose-conditionals#0>
// [accessed 1 April 2025].

// Kincade Garanganga. 2024. “IMAD5112 Practicum Discussion 2024”. YouTube. December 7, 2024
// <https://www.youtube.com/watch?v=_u8zA1CxxV4>
// [accessed 1 April 2025].


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

    private lateinit var mealText: EditText // linking my XML ID's using private lateinit var
    private lateinit var buttonMeal: Button
    private lateinit var displaymeal: TextView
    private lateinit var resetbutton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//(Kotlin for developers 2024)
        // linking current activity variables to UI components
        mealText = findViewById(R.id.mealText)
        buttonMeal = findViewById(R.id.buttonMeal)
        displaymeal = findViewById(R.id.displaymeal)
        resetbutton = findViewById(R.id.resetbutton)
       // (Kotlin for developers 2024)
        buttonMeal.setOnClickListener{ // button used to display food items in textview
            handleButtonMealClick()
        }
        resetbutton.setOnClickListener{
            handleResetButtonClick() // button used to clear food items in textview
        }
    }
//(Kotlin for developers 2024)
    // method logic to clear textview
     private fun handleResetButtonClick(){
         displaymeal.text = ""
     }
    private fun handleButtonMealClick(){ // fuction used to enter the time of a day
        val mealInput = mealText.text.toString().trim().lowercase()
//(Kotlin for developers 2024)
        if (mealInput.isEmpty()) {
            displaymeal.text = "Enter the time of day"
            return
        }

        try {
            //(Kotlin for developers 2024)
            displaymeal.text = when (mealInput.lowercase()) { // case statement used to check and suggest a meal according to the time
                "morning" -> "Pancakes, Omelette, Smoothie"
                "mid-morning" -> "Muffins, Fruit Salad, Biscuits"
                "afternoon" -> "Chips, Sandwich, Wrap"
                "mid-afternoon" -> "Yogurt, Ice Cream, Boiled Eggs"
                "dinner" -> "Soup, Pasta, Pizza"
                "after-dinner" -> "Cheesecake, Brownie, Pudding"
                else -> throw IllegalArgumentException("$mealInput is not a valid meal time") // error handle incase user inputs incorrect mealInput
            }
        } catch (e: IllegalArgumentException) {
            displaymeal.text = e.message // Show error message directly

        }
    }
}



