package net.softglobe.loginregistertutoriall

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import net.softglobe.loginregistertutoriall.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding : FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =  DataBindingUtil.inflate(layoutInflater, R.layout.fragment_home, container, false)
        inItView()
        return binding.root
    }

    private fun inItView() {
        val prefs = activity?.getSharedPreferences("myNewPrefs", MODE_PRIVATE)
        val editor = prefs?.edit()
        val email = prefs?.getString("email", "")
        val token = prefs?.getString("token", "")
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val result = RetofitInstance.api.getUserDetails(email!!, token!!)
                if (result.isSuccessful && result.body() != null) {
                    withContext(Dispatchers.Main) {
                        if (!result.body()!!.result.error) {
                            binding.txtWelcome.text = "Welcome, ${result.body()!!.user?.name}"
                        }
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(activity, "Something went wrong", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
                Log.d("checkApiError", result.body()!!.result.message)
            } catch (e : Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(activity, "Something went wrong", Toast.LENGTH_SHORT)
                        .show()
                }
                Log.d("checkApiError", e.message.toString())
            }
        }

        binding.btnLogout.setOnClickListener {
            editor?.clear()
            editor?.apply()
            findNavController().navigate(R.id.action_homeFragment2_to_loginFragment)
        }
    }

}