package com.example.myassssmentapplication.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myassssmentapplication.data.model.DashboardResponse
import com.example.myassssmentapplication.data.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    private val _dashboardData = MutableLiveData<Result<DashboardResponse>>()
    val dashboardData: LiveData<Result<DashboardResponse>> = _dashboardData

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun loadDashboard(keypass: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _dashboardData.value = repository.getDashboard(keypass)
            _isLoading.value = false
        }
    }
} 