package com.example.cryptodemo.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

/**
 * @author : Mingaleev D
 * @data : 9/11/2022
 */

abstract class BaseFragment<VB:ViewBinding,VM:ViewModel>(
   private val bindingInflater:(inflater: LayoutInflater) -> VB
):Fragment(){

   private var mBinding:VB? = null
   protected val binding:VB get() = mBinding as VB

   protected abstract val viewModel:VM
   protected abstract fun onCreateFinished()
   protected abstract fun initializeListeners()
   protected abstract fun observerEvents()

   override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View? {

      mBinding = bindingInflater.invoke(inflater)
      if(mBinding == null){
         throw IllegalArgumentException("mBinding is null")
      }

      return binding.root
   }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)
      onCreateFinished()
      initializeListeners()
      observerEvents()
   }

   override fun onDestroyView() {
      super.onDestroyView()
      mBinding = null
   }
}