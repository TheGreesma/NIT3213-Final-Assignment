package com.example.myassssmentapplication.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myassssmentapplication.R
import com.example.myassssmentapplication.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.logoutButton.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }

        displayEntityDetails()
    }

    private fun displayEntityDetails() {
        val entity = args.entity
        val container = binding.detailsContainer
        container.removeAllViews()

        for ((key, value) in entity.fields) {
            val textView = TextView(requireContext())
            textView.text = "${key.replaceFirstChar { it.uppercase() }}: $value"
            textView.textSize = 16f
            textView.setPadding(0, 8, 0, 8)
            container.addView(textView)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 