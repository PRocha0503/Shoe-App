package com.udacity.shoestore.screens.shoeList

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.models.Shoe


class ShoeListFragment : Fragment() {
    private lateinit  var binding: FragmentShoeListBinding
    private lateinit var viewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         binding = DataBindingUtil.inflate(
             inflater,
             R.layout.fragment_shoe_list,
             container,
             false)

        viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)

        viewModel.shoesList.observe(viewLifecycleOwner, Observer { newList ->
            for (shoe in newList){
                addShoe(shoe)
            }
        })
        setHasOptionsMenu(true)
        binding.addShoeBtn.bringToFront()
        binding.addShoeBtn.setOnClickListener{view: View -> view.findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment) }
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
    private fun addShoe(shoe: Shoe) {
        val shoeListBinding: ShoeItemBinding = ShoeItemBinding.inflate(layoutInflater, binding.shoeList, false)
        shoeListBinding.shoeName.text = shoe.name
        shoeListBinding.companyTxt.text = shoe.company
        shoeListBinding.descTxt.text = shoe.description
        shoeListBinding.sizeTxt.text = shoe.size.toString()
        shoeListBinding.image.setImageResource(R.drawable.ic_shoe)
        binding.shoeList.addView(shoeListBinding.root)
    }
}