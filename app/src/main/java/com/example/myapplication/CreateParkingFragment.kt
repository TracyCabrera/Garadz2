package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentCreateParkingBinding
import com.example.myapplication.databinding.FragmentHomeBinding

class CreateParkingFragment : Fragment() {
    private lateinit var binding: FragmentCreateParkingBinding
    private var homeFragment = HomeFragment()
    private var locationFragment = LocationFragment()
    private var bookingFragment = BookingFragment()
    private var historyFragment = HistoryFragment()
    private var profileFragment = ProfileFragment()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCreateParkingBinding.inflate(inflater, container, false)

        return inflater.inflate(R.layout.fragment_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.home -> {
                    replaceFragment(homeFragment)
                }
                R.id.location -> {
                    replaceFragment(locationFragment)
                }
                R.id.fab -> {
                    replaceFragment(bookingFragment)
                }
                R.id.history -> {
                    replaceFragment(historyFragment)
                }
                R.id.profile -> {
                    replaceFragment(profileFragment)
                }
            }
            true

        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }




}