package com.example.ecommerceapplication

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CategoryFragment : Fragment() {

    companion object {
        fun newInstance() = CategoryFragment()
    }

    private lateinit var viewModel: CategoryViewModel
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapterCategory: RecyclerView.Adapter<CategoryRecyclerViewAdapter.ViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.category_fragment, container, false)
        layoutManager = LinearLayoutManager(context)

        val recyclerView : RecyclerView = view.findViewById(R.id.CategoryRecyclerView)
        recyclerView.layoutManager = layoutManager

        var categories = arrayOf("Informatique", "Beauté", "Hi-tech", "Bullshit", "Clothes", "Informatique", "Beauté", "Hi-tech", "Bullshit", "Clothes", "Beauté", "Hi-tech", "Bullshit", "Clothes" )
        var categoriesImages = arrayOf(R.drawable.ic_baseline_laptop_24, R.drawable.ic_baseline_laptop_24,
            R.drawable.ic_baseline_laptop_24, R.drawable.ic_baseline_laptop_24, R.drawable.ic_baseline_laptop_24, R.drawable.ic_baseline_laptop_24, R.drawable.ic_baseline_laptop_24,
            R.drawable.ic_baseline_laptop_24, R.drawable.ic_baseline_laptop_24, R.drawable.ic_baseline_laptop_24, R.drawable.ic_baseline_laptop_24, R.drawable.ic_baseline_laptop_24, R.drawable.ic_baseline_laptop_24, R.drawable.ic_baseline_laptop_24)

        adapterCategory = CategoryRecyclerViewAdapter(categories, categoriesImages)
        recyclerView.adapter = adapterCategory

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)
        // TODO: Use the ViewModel
    }

}