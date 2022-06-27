package com.udacity.shoestore.shoeDetail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.shoeList.ShoeListViewModel
import java.lang.Error


class ShoeDetailFragment : Fragment() {
    private lateinit var viewModel: ShoeListViewModel
    private val shoe: Shoe = Shoe("", 0.0, "", "")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoeDetailBinding =DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_detail,container,false)
        viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)
        binding.shoe = Shoe("", 0.0, "", "")
        binding.lifecycleOwner = this
        binding.cancelBtn.setOnClickListener{
                view: View ->  view.findNavController().navigate(R.id.action_shoeDetail_to_shoeList)
        }
        binding.saveBtn.setOnClickListener{
                view: View ->
            run {
                try{
                    viewModel.addShoe(binding.shoe ?: shoe)

                }catch (err:Error){
                    Log.i("Error","Invalid Data")
                }

                view.findNavController()
                    .navigate(R.id.action_shoeDetail_to_shoeList)
            }


        }

        return binding.root
    }
}