package com.example.myassssmentapplication.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myassssmentapplication.databinding.FragmentDashboardBinding
import com.example.myassssmentapplication.ui.viewmodel.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint
import android.util.Log
import com.example.myassssmentapplication.R

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DashboardViewModel by viewModels()
    private val args: DashboardFragmentArgs by navArgs()
    private lateinit var adapter: EntityAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.logoutButton.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }

        setupRecyclerView()
        setupObservers()
        viewModel.loadDashboard(args.keypass)
    }

    private fun setupRecyclerView() {
        adapter = EntityAdapter { entity ->
            val action = DashboardFragmentDirections.actionDashboardToDetails(entity)
            findNavController().navigate(action)
        }

        binding.entitiesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@DashboardFragment.adapter
        }
    }

    private fun setupObservers() {
        viewModel.dashboardData.observe(viewLifecycleOwner) { result ->
            result.fold(
                onSuccess = { response ->
                    Log.d("DashboardFragment", "Dashboard response: $response")
                    adapter.submitList(response.entities ?: emptyList())
                },
                onFailure = { error ->
                    Toast.makeText(context, error.message, Toast.LENGTH_LONG).show()
                }
            )
        }

        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 