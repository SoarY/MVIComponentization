package com.soar.mvi.base

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

/**
 * NAME：YONG_
 * Created at: 2023/3/25 13
 * Describe:
 */
abstract class BaseFragment <V : ViewBinding> : Fragment() {

    val TAG = javaClass.simpleName

    lateinit var activity: Activity

    protected val binding: V by lazy {
        //使用反射得到viewbinding的class
        val type = javaClass.genericSuperclass as ParameterizedType
        val aClass = type.actualTypeArguments[0] as Class<*>
        val method = aClass.getDeclaredMethod("inflate", LayoutInflater::class.java)
        method.invoke(null, layoutInflater) as V
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        init()
        return binding.root
    }

    private fun init() {
        activity = requireActivity()
    }
}