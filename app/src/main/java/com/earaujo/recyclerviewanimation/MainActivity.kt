package com.earaujo.recyclerviewanimation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: RecyclerAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = mutableListOf<String>()
        data.add("vestido")
        data.add("casaco")
        data.add("blusa")
        data.add("camiseta")
        data.add("shorts")
        data.add("bermuda")
        data.add("cinto")
        data.add("brinco")

        showRecyclerView(data)
    }

    private fun showRecyclerView(data: MutableList<String>) {
        linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val rvcontext = rv_myrecycler.context
        adapter = RecyclerAdapter(this, data)
        rv_myrecycler.adapter = adapter
        rv_myrecycler.layoutManager = linearLayoutManager

    }
}
