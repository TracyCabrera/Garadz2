package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private var homeFragment = HomeFragment()
    private var locationFragment = LocationFragment()
    private var bookingFragment = BookingFragment()
    private var historyFragment = HistoryFragment()
    private var profileFragment = ProfileFragment()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        replaceFragment(homeFragment)
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
        val imageView2 = view.findViewById<ImageView>(R.id.imageView2)
        imageView2.setOnClickListener{
            replaceFragment(bookingFragment)
        }

        val imageView3 = view.findViewById<ImageView>(R.id.imageView3)
        imageView3.setOnClickListener{
            replaceFragment(bookingFragment)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }




}
