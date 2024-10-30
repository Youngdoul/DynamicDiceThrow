package edu.temple.dicethrow

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


/*
Our DieThrow application has been refactored to move the dieRoll() logic
into the ViewModel instead of the Fragment.
Study the DieViewModel, ButtonFragment, and DieFragment classes to
see the changes.

Follow the requirements below to have this app function
in both portrait and landscape configurations.
The Activity layout files for both Portrait and Landscape are already provided
*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Display generated number using this TextView
        val numberDisplay = findViewById<TextView>(R.id.numberDisplay)

        // Retrieve ViewModel
        val viewModel = ViewModelProvider(this)[DiceViewModel::class.java]

        viewModel.getselectednum().observe(this){
            numberDisplay.text = it.toString()
        }

        // Fragment created using factory method and added dynamically using fragmentTransaction
        // argument is the number of sides the die will have
        supportFragmentManager.beginTransaction()
            .add(R.id.diceFragmentContainer, DiceFragment.newInstance(6))
            .commit()
    }
}
