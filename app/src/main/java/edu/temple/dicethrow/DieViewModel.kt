package edu.temple.dicethrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DiceViewModel : ViewModel() {
    private val selectednum = MutableLiveData<Int>()

    fun setselectnum(number: Int){
        selectednum.value = number
    }

    fun getselectednum(): LiveData<Int>{
        return selectednum
    }
    
}
