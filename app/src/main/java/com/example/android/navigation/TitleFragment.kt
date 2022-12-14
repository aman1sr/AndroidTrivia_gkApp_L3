package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding



class TitleFragment : Fragment() ,View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(
            inflater,
            R.layout.fragment_title,
            container,
            false
        )


        //The complete onClickListener with Navigation , todo: this type of OnClick is crashing (find why)
//        binding.playButton.setOnClickListener { view : View ->
//            view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
//        }

        binding.playButton.setOnClickListener(this)

         setHasOptionsMenu(true)        // for About menu -> in action Bar


        // Inflate the layout for this fragment
        return binding.root

    }

            /*  inflate the menu resource file. */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)

    }

    /* onOptionsItemSelected() method - take the appropriate action when the menu item is tapped.*/
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)


    }

    override fun onClick(p0: View?) {

        val id = p0!!.id
        when (id) {
            R.id.playButton ->{
            p0.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
            }
        }

    }


}