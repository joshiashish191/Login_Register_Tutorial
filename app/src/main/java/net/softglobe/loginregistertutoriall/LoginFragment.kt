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
import net.softglobe.loginregistertutoriall.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    lateinit var binding : FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
         binding =  DataBindingUtil.inflate(layoutInflater, R.layout.fragment_login, container, false)
        inItView()
        return binding.root
    }

    private fun inItView() {
        val prefs = activity?.getSharedPreferences("myNewPrefs", MODE_PRIVATE)
        val editor = prefs?.edit()

        if (!prefs?.getString("token", "").equals("")) {
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment2)
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            lifecycleScope.launch(Dispatchers.IO) {
                try {
                    val result = RetofitInstance.api.loginUser(email, password)
                    if (result.isSuccessful && result.body() != null) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                activity,
                                result.body()!!.result.message,
                                Toast.LENGTH_SHORT
                            ).show()
                            if (!result.body()!!.result.error && result.body()!!.user != null) {
                                editor?.putString("email", email)
                                editor?.putString("token", result.body()!!.user?.auth_token)
                                editor?.apply()
                                findNavController().navigate(R.id.action_loginFragment_to_homeFragment2)
                            } else {
                                Log.d("checkApiError", result.body()!!.result.message)
                            }
                        }
                    } else {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(activity, "Something went wrong", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                } catch (e : Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(activity, "Something went wrong", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }

        binding.txtRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }
}