package com.exam.assignmenttest.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.exam.assignmenttest.data.model.Items
import com.exam.assignmenttest.databinding.AdapterPagerItemBinding

class ImagePagerAdapter(val list: List<Items>) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as View
    }
    override fun instantiateItem(parent : ViewGroup, position: Int): Any {

        val binding = AdapterPagerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.ivParent.setImageResource(list[position]._image)

        (parent as ViewPager).addView(binding.root, 0)

        return binding.root
    }
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        (container as ViewPager).removeView(`object` as View?)
    }

    override fun getCount(): Int {
        return list.size
    }
}