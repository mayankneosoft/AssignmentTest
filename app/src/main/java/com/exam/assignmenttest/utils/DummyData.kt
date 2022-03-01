package com.exam.assignmenttest.utils

import com.exam.assignmenttest.R
import com.exam.assignmenttest.data.model.Items
import com.exam.assignmenttest.data.model.ItemList


object DummyData {

    fun callDummyItems() :List<Items> {

        val arrItems: ArrayList<Items> = ArrayList()

        val arritemList : ArrayList<ItemList> = ArrayList()
        arritemList.add(ItemList("Item 1_1"))
        arritemList.add(ItemList("Item 1_2"))
        arritemList.add(ItemList("Item 1_3"))
        arritemList.add(ItemList("Item 1_4"))
        arritemList.add(ItemList("Item 1_5"))
        arritemList.add(ItemList("Item 1_6"))

        arrItems.add(Items(R.drawable.sample1,arritemList))


        val arritemList1 : ArrayList<ItemList> = ArrayList()
        arritemList1.add(ItemList("Item 2_1"))
        arritemList1.add(ItemList("Item 2_2"))
        arritemList1.add(ItemList("Item 2_3"))
        arritemList1.add(ItemList("Item 2_4"))
        arritemList1.add(ItemList("Item 2_5"))
        arritemList1.add(ItemList("Item 2_6"))

        arrItems.add(Items(R.drawable.sample2,arritemList1))

        val arritemList2 : ArrayList<ItemList> = ArrayList()
        arritemList2.add(ItemList("Item 3_1"))
        arritemList2.add(ItemList("Item 3_2"))
        arritemList2.add(ItemList("Item 3_3"))
        arritemList2.add(ItemList("Item 3_4"))
        arritemList2.add(ItemList("Item 3_5"))
        arritemList2.add(ItemList("Item 3_6"))

        arrItems.add(Items(R.drawable.sample3,arritemList2))

        val arritemlist3 : ArrayList<ItemList> = ArrayList()
        arritemlist3.add(ItemList("Item 4_1"))
        arritemlist3.add(ItemList("Item 4_2"))
        arritemlist3.add(ItemList("Item 4_3"))
        arritemlist3.add(ItemList("Item 4_4"))
        arritemlist3.add(ItemList("Item 4_5"))
        arritemlist3.add(ItemList("Item 4_6"))

        arrItems.add(Items( R.drawable.sample4,arritemlist3))

        val arritemlist4 : ArrayList<ItemList> = ArrayList()
        arritemlist4.add(ItemList("Item 5_1"))
        arritemlist4.add(ItemList("Item 5_2"))
        arritemlist4.add(ItemList("Item 5_3"))
        arritemlist4.add(ItemList("Item 5_4"))
        arritemlist4.add(ItemList("Item 5_5"))
        arritemlist4.add(ItemList("Item 5_6"))

        arrItems.add(Items(R.drawable.sample5,arritemlist4))

        return arrItems

    }

}