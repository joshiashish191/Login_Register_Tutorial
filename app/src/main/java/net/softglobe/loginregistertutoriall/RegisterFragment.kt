package net.softglobe.loginregistertutoriall

import User
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
import net.softglobe.loginregistertutoriall.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    lateinit var binding : FragmentRegisterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =  DataBindingUtil.inflate(layoutInflater, R.layout.fragment_register, container, false)
        inItView()
        return binding.root
    }

    private fun inItView() {
        binding.btnRegister.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            lifecycleScope.launch(Dispatchers.IO) {
                try {
                    val result = RetofitInstance.api.registerUser(User(name, email, password))
                    if (result.isSuccessful && result.body() != null) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                activity,
                                result.body()!!.message,
                                Toast.LENGTH_SHORT
                            ).show()
                            if (!result.body()!!.error) {
                                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                            }
                        }
                    } else {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(activity, "Something went wrong", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                    Log.d("checkApiError", result.body()!!.message)
                } catch (e : Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(activity, "Something went wrong", Toast.LENGTH_SHORT)
                            .show()
                    }
                    Log.d("checkApiError", e.message.toString())
                }
            }
        }
    }
}