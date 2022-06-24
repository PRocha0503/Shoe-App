package com.udacity.shoestore.screens.shoeList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel: ViewModel() {
    // The current word
    private var _shoesList = MutableLiveData<List<Shoe>>()
    val shoesList : LiveData<List<Shoe>>
        get() = _shoesList
    init{
        _shoesList.value = listOf(Shoe("Test",
            2.0,
            "TestCompany",
            "This is a test shoe",
            listOf("https://media.revistagq.com/photos/607d448f3b061fdfaf460c7f/master/w_1600%2Cc_limit/air-force-1-low-zapatillas-gvG9vB%2520(1).png")
            ),Shoe("Test",
            2.0,
            "TestCompany",
            "This is a test shoe",
            listOf("https://media.revistagq.com/photos/607d448f3b061fdfaf460c7f/master/w_1600%2Cc_limit/air-force-1-low-zapatillas-gvG9vB%2520(1).png")
        ),Shoe("Test",
            2.0,
            "TestCompany",
            "This is a test shoe",
            listOf("https://media.revistagq.com/photos/607d448f3b061fdfaf460c7f/master/w_1600%2Cc_limit/air-force-1-low-zapatillas-gvG9vB%2520(1).png")
        ),Shoe("Test",
            2.0,
            "TestCompany",
            "This is a test shoe",
            listOf("https://media.revistagq.com/photos/607d448f3b061fdfaf460c7f/master/w_1600%2Cc_limit/air-force-1-low-zapatillas-gvG9vB%2520(1).png")
        ),Shoe("Test",
            2.0,
            "TestCompany",
            "This is a test shoe",
            listOf("https://media.revistagq.com/photos/607d448f3b061fdfaf460c7f/master/w_1600%2Cc_limit/air-force-1-low-zapatillas-gvG9vB%2520(1).png")
        ),Shoe("Test",
            2.0,
            "TestCompany",
            "This is a test shoe",
            listOf("https://media.revistagq.com/photos/607d448f3b061fdfaf460c7f/master/w_1600%2Cc_limit/air-force-1-low-zapatillas-gvG9vB%2520(1).png")
        ),Shoe("Test",
            2.0,
            "TestCompany",
            "This is a test shoe",
            listOf("https://media.revistagq.com/photos/607d448f3b061fdfaf460c7f/master/w_1600%2Cc_limit/air-force-1-low-zapatillas-gvG9vB%2520(1).png")
        ),Shoe("Test",
            2.0,
            "TestCompany",
            "This is a test shoe",
            listOf("https://media.revistagq.com/photos/607d448f3b061fdfaf460c7f/master/w_1600%2Cc_limit/air-force-1-low-zapatillas-gvG9vB%2520(1).png")
        ),Shoe("Test",
            2.0,
            "TestCompany",
            "This is a test shoe",
            listOf("https://media.revistagq.com/photos/607d448f3b061fdfaf460c7f/master/w_1600%2Cc_limit/air-force-1-low-zapatillas-gvG9vB%2520(1).png")
        ))
    }

    fun addShoe( name: String,  size: Double,  company: String,  description: String) {
        Log.i("Debug","IN ADD")
        val newShoe = Shoe(name,
            size,
            company,
            description,
            listOf("https://media.revistagq.com/photos/607d448f3b061fdfaf460c7f/master/w_1600%2Cc_limit/air-force-1-low-zapatillas-gvG9vB%2520(1).png"))
        _shoesList.value = _shoesList.value?.plus(newShoe) ?: listOf(newShoe)
        Log.i("Debug",shoesList.value.toString())
    }

}