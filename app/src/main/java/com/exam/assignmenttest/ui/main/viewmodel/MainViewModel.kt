package com.exam.assignmenttest.ui.main.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.exam.assignmenttest.data.model.Items
import com.exam.assignmenttest.data.model.ItemList
import com.exam.assignmenttest.utils.DummyData

class MainViewModel(application: Application) : AndroidViewModel(application) {

    fun callSearch(_searchitem: String, items: ArrayList<ItemList>) : LiveData<ArrayList<ItemList>> =
        liveData { emit(
            items.filter {
                it._title.contains(_searchitem,true)
            } as ArrayList<ItemList>
          )
    }

    val list: List<Items>
        get() = getData()

    private fun getData() : List<Items>{
        return  DummyData.callDummyItems()
    }
}