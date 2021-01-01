package com.jasonpwy.simplecountdowntimer.game

import android.os.CountDownTimer
import android.text.format.DateUtils
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel(){
    private val _storedText = MutableLiveData<String>()
    val storeText : LiveData<String>
        get() = _storedText;

    private val _ListData = MutableLiveData<List<String>>()
    val ListData : LiveData<List<String>>
        get() = _ListData

    init{
        _storedText.value = ""
        _ListData.value = listOf()
    }


    fun addText(message: String){
        _storedText.value += message
        _storedText.value += "\n"
        _storedText.value?.let { Log.i("Test", it) }
        _ListData.value = _ListData.value?.plus(message)
        Log.i("Test4", _ListData.value.toString())
    }
}
