package com.soar.mvi.base

import android.os.Bundle
import android.view.View
import androidx.viewbinding.ViewBinding

/**
 * NAME：YONG_
 * Created at: 2023/3/25 15
 * Describe:
 */
abstract class BaseLazyFragment<V : ViewBinding> : BaseFragment<V>(){
    //是否可见
    protected var mIsVisible = false

    // 标志位，标志Fragment已经初始化完成。
    var isPrepared = false

    protected abstract fun lazyData()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isPrepared = true
        loadData()
    }

    /**
     * 实现Fragment数据的懒加载
     *
     * @param isVisibleToUser Fragment是否可见
     */
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            mIsVisible = true
            loadData()
        } else {
            mIsVisible = false
        }
    }

    private fun loadData() {
        if (isPrepared && isVisible) {
            isPrepared = false
            lazyData()
        }
    }
}