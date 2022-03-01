package com.exam.assignmenttest.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.exam.assignmenttest.data.model.ItemList
import com.exam.assignmenttest.databinding.ActivityMainBinding
import com.exam.assignmenttest.ui.main.viewmodel.MainViewModel
import com.exam.assignmenttest.ui.main.adapter.CustomItemAdapter
import com.exam.assignmenttest.ui.main.adapter.ImagePagerAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        /* viewpager & tab layout  */
        binding.viPager.adapter = ImagePagerAdapter(viewModel.list)
        binding.tabLayout.setupWithViewPager(binding.viPager)

        /* recyclerview  */
        binding.rvItem.apply {
            adapter = CustomItemAdapter(viewModel.list[0]._items)
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false);
        }



        listenerPortion()
    }

    private fun listenerPortion() {

        /*  pages changes & search item work */
        binding.viPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {

            override fun onPageSelected(position: Int) {
                val itemadapter: CustomItemAdapter = binding.rvItem.adapter as CustomItemAdapter
                itemadapter.notifyAll(viewModel.list[position]._items)

                val search_item = binding.llSearch.etItem.text
                binding.llSearch.etItem.text?.clear()
                binding.llSearch.etItem.text = search_item
                binding.llSearch.etItem.setSelection(binding.llSearch.etItem.length())

            }
        })

        /* edittext flow */

        binding.llSearch.etItem.addTextChangedListener {
            val pagerAdapter: ImagePagerAdapter = binding.viPager.adapter as ImagePagerAdapter
            val list = pagerAdapter.list[binding.viPager.currentItem]._items

            viewModel.callSearch(it.toString().trim(),list)

                .observe(this, Observer<ArrayList<ItemList>> { it ->
                    val listCustomItemAdapter: CustomItemAdapter = binding.rvItem.adapter as CustomItemAdapter
                    listCustomItemAdapter.notifyAll(it)
                })
        }

    }

}

