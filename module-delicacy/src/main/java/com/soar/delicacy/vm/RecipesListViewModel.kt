package com.soar.delicacy.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.soar.common.base.BaseApplication
import com.soar.delicacy.repository.RecipesListRepository
import com.soar.delicacy.action.RecipesListViewAction
import com.soar.delicacy.action.RecipesListViewEvent
import com.soar.mvi.base.BaseViewModel
import com.soar.mvi.core.FetchStatus
import com.soar.mvi.core.ViewState
import com.soar.network.bean.response.Recipes
import com.zj.mvi.core.SingleLiveEvents
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * NAME：YONG_
 * Created at: 2023/9/5 14
 * Describe:
 */
class RecipesListViewModel : BaseViewModel(){

    private val _viewStates: MutableLiveData<ViewState<Recipes>> = MutableLiveData()
    val viewStates get() = _viewStates

    private val _viewEvents: SingleLiveEvents<RecipesListViewEvent> = SingleLiveEvents() //一次性的事件，与页面状态分开管理
    val viewEvents get()= _viewEvents

    fun dispatch(viewAction: RecipesListViewAction) {
        when (viewAction) {
            is RecipesListViewAction.GetRecipes -> getRecipes()
        }
    }

    fun getRecipes() {
        viewModelScope.launch {
            _viewStates.value = ViewState(FetchStatus.Fetching)
            RecipesListRepository.requestRecipes().collect {
                _viewStates.value = it

                /*_viewEvents.value=listOf(RecipesListViewEvent.ShowToast(
                    BaseApplication
                    .context.getString(R.string.to_loaded)))*/
            }
        }
    }
}