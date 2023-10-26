package com.soar.delicacy.activity

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.bumptech.glide.Glide
import com.soar.common.router.RouteConstants
import com.soar.delicacy.databinding.ActivityDetailsBinding
import com.soar.mvi.base.BaseActivity
import com.soar.network.bean.response.RecipesItem

@Route(path = RouteConstants.Delicacy.DELICACY_DETAILS)
class DetailsActivity : BaseActivity<ActivityDetailsBinding>() {

    companion object{
        const val RECIPE_ITEM_KEY="RECIPE_ITEM_KEY"
    }

    @JvmField
    @Autowired(name = RECIPE_ITEM_KEY)
    var recipesItem: RecipesItem?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
        initView()
    }

    private fun initView() {
        recipesItem?.let {
            binding.tvName.text = recipesItem!!.name
            binding.tvHeadline.text = recipesItem!!.headline
            binding.tvDescription.text = recipesItem!!.description
            Glide.with(this).load(recipesItem!!.image)
                .into(binding.ivRecipeImage)
        }
    }

}