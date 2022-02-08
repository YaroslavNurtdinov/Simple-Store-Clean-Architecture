package com.nurtdinov.simpleshop.presenter.screens.home

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.*
import com.nurtdinov.simpleshop.R
import com.nurtdinov.simpleshop.databinding.FragmentHomeBinding
import com.nurtdinov.simpleshop.presenter.adapters.bestseller.BestSellerAdapter
import com.nurtdinov.simpleshop.presenter.adapters.homestore.HomeStoreAdapter
import com.nurtdinov.simpleshop.presenter.adapters.category.Categories
import com.nurtdinov.simpleshop.presenter.adapters.category.CategoryAdapter
import com.nurtdinov.simpleshop.presenter.screens.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val mainViewModel: MainViewModel by viewModels()
    private val bestSellerAdapter by lazy { BestSellerAdapter() }
    private val homeAdapter by lazy { HomeStoreAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        setupCategoryRecyclerView()
        setupBestSellerRecyclerView()
        setupHomeRecyclerView()

        mainViewModel.phonesList.observe(requireActivity()) { data ->
            data.data?.map { bestSellerAdapter.setData(it.bestSeller) }
            Log.d("Home", "${data.data?.map { it.bestSeller.toString() }}")

            data.data?.map { homeAdapter.setData(it.homeStore) }
            Log.d("Home", "${data.data?.map { it.homeStore.toString() }}")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.filter_option) {
            findNavController().navigate(R.id.action_homeFragment_to_filterBottomSheetFragment)
        }

        return super.onOptionsItemSelected(item)
    }

    private fun createCategories(): ArrayList<Categories> {
        return arrayListOf(
            Categories(
                icon = AppCompatResources.getDrawable(
                    binding.root.context,
                    R.drawable.ic_select_category_phone
                ),
                category = "Phones",
                isChecked = true
            ),
            Categories(
                icon = AppCompatResources.getDrawable(
                    binding.root.context,
                    R.drawable.ic_select_category_computer
                ),
                category = "Computer"
            ),
            Categories(
                icon = AppCompatResources.getDrawable(
                    binding.root.context,
                    R.drawable.ic_select_category_health
                ),
                category = "Health"
            ),
            Categories(
                icon = AppCompatResources.getDrawable(
                    binding.root.context,
                    R.drawable.ic_select_category_books
                ),
                category = "Books"
            ),
            Categories(
                icon = AppCompatResources.getDrawable(
                    binding.root.context,
                    R.drawable.ic_select_category_books
                ),
                category = "Books 2"
            )
        )
    }

    private fun setupCategoryRecyclerView() {
        val categoryAdapter = CategoryAdapter(createCategories())
        binding.selectCategoryRecyclerView.adapter = categoryAdapter
        binding.selectCategoryRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
    }

    private fun setupHomeRecyclerView() {
        binding.homeStoreRecyclerView.adapter = homeAdapter
        binding.homeStoreRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.homeStoreRecyclerView)
    }

    private fun setupBestSellerRecyclerView() {
        binding.bestSellerRecyclerView.adapter = bestSellerAdapter
        binding.bestSellerRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}