package com.soptcode.yilassignment.base


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.soptcode.yilassignment.utils.SharedPreferenceUtil





abstract class BaseFragment: Fragment() {
    lateinit var sharedPreference: SharedPreferenceUtil
    private lateinit var callback: OnBackPressedCallback
  // lateinit var navController: NavController
    var view_:View?=null


    //lateinit var apiViewModel: ApiViewModel
    /**
     * SetBackButtonDispatcher in OnCreate
     */

    var hasInitializedRootView = false
    private var rootView: View? = null


    fun getPersistentView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?, layout: Int): View? {
        if (rootView == null) {
            // Inflate the layout for this fragment
            rootView = inflater?.inflate(layout,container,false)
        } else {
            // Do not inflate the layout again.
            // The returned View of onCreateView will be added into the fragment.
            // However it is not allowed to be added twice even if the parent is same.
            // So we must remove rootView from the existing parent view group
            // (it will be added back).
            (rootView?.parent as? ViewGroup)?.removeView(rootView)
        }

        return rootView
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreference = SharedPreferenceUtil.getInstance(requireActivity())
     //   apiViewModel = ViewModelProvider(this).get(ApiViewModel::class.java)
        setBackButtonDispatcher()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view_=view
        initView()
    }

    abstract fun initView()
    fun setToolbarName(tittleName:String?){
     //   Navigation.findNavController(view_!!).currentDestination?.label=tittleName!!.toString()
    }
    /**
     * Adding BackButtonDispatcher callback to activity
     */
    private fun setBackButtonDispatcher() {
        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {

            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    /**
     * Override this method into your fragment to handleBackButton
     */
}