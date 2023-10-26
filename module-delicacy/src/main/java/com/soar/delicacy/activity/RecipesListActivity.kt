package com.soar.delicacy.activity

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.soar.common.router.RouteConstants
import com.soar.delicacy.action.RecipesListViewAction
import com.soar.delicacy.adapter.RecipesAdapter
import com.soar.delicacy.databinding.ActivityHomeBinding
import com.soar.delicacy.vm.RecipesListViewModel
import com.soar.mvi.base.BaseActivity
import com.soar.mvi.core.FetchStatus
import com.soar.mvi.core.ViewState
import com.soar.network.bean.response.Recipes

@Route(path = RouteConstants.Delicacy.DELICACY_RECIPES)
class RecipesListActivity : BaseActivity<ActivityHomeBinding>() {

    private lateinit var recipesAdapter: RecipesAdapter

    private val recipesListViewModel: RecipesListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        observeViewModel()
        initData()
    }

    private fun initView() {
        val layoutManager = LinearLayoutManager(this)
        binding.rvRecipesList.layoutManager = layoutManager
        binding.rvRecipesList.setHasFixedSize(true)
    }

    private fun observeViewModel() {
        recipesListViewModel.viewStates.observe(this, ::handleRecipesList)
    }

    private fun initData() {
        recipesListViewModel.dispatch(RecipesListViewAction.GetRecipes)
    }

    private fun handleRecipesList(status: ViewState<Recipes>) {
        when (status.fetchStatus) {
            is FetchStatus.Fetching -> {
                binding.pbLoading.visibility=View.VISIBLE
                binding.tvNoData.visibility=View.GONE
                binding.rvRecipesList.visibility=View.GONE
            }
            is FetchStatus.Fetched -> status.data?.let { bindListData(recipes = it) }
            is FetchStatus.Error -> {
                binding.pbLoading.visibility=View.GONE
                binding.tvNoData.visibility=View.VISIBLE
                binding.rvRecipesList.visibility=View.GONE
                (status.fetchStatus as FetchStatus.Error).errorCode.let {
                    //Toast.makeText(this, ErrorMapper.getErrorString(this,status.errorCode), Toast.LENGTH_LONG).show()
                }
            }
            is FetchStatus.NotFetched -> {
            }
        }
    }

    private fun bindListData(recipes: Recipes) {
        if (!(recipes.recipesList.isNullOrEmpty())) {
            binding.pbLoading.visibility=View.GONE
            binding.tvNoData.visibility=View.GONE
            binding.rvRecipesList.visibility=View.VISIBLE

            recipesAdapter = RecipesAdapter(recipes.recipesList)
            binding.rvRecipesList.adapter = recipesAdapter
            recipesAdapter.setItemClickListener(itemClickListener)
        } else {
            binding.pbLoading.visibility=View.GONE
            binding.tvNoData.visibility=View.VISIBLE
            binding.rvRecipesList.visibility=View.GONE
        }
    }

    private val itemClickListener = RecipesAdapter.ItemClickListener {
        val item = recipesAdapter.getItem(it)
        ARouter.getInstance()
            .build(RouteConstants.Delicacy.DELICACY_DETAILS)
            .withSerializable(DetailsActivity.RECIPE_ITEM_KEY,item)
            .navigation(this)
    }
}