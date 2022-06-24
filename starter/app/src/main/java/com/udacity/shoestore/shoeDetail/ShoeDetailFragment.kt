package com.udacity.shoestore.shoeDetail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.screens.shoeList.ShoeListFragment
import com.udacity.shoestore.screens.shoeList.ShoeListViewModel
import java.lang.Error


class ShoeDetailFragment : Fragment() {
    private lateinit var viewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoeDetailBinding =DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_detail,container,false)
        viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)

        binding.cancelBtn.setOnClickListener{
                view: View ->  view.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }
        binding.saveBtn.setOnClickListener{
                view: View ->
            run {
                try{
                    viewModel.addShoe(binding.nameInput.text.toString(),binding.sizeInput.text.toString().toDouble(),binding.companyInput.text.toString(),binding.descInput.text.toString())

                }catch (err:Error){
                    Log.i("Error","Invalid Data")
                }

                view.findNavController()
                    .navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
            }


        }

        return binding.root
    }
}