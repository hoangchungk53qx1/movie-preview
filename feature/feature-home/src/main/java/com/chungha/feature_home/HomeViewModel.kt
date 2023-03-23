package com.chungha.feature_home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_ui.widget.common.LceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
//    private val
) : ViewModel() {

    val upstream = flowOf("1,1,1,1,1,2")
    init {
        viewModelScope.launch {
            upstream.collect { c.send(it) }
        }
    }
    val c = Channel<String>()
    val f = c.receiveAsFlow()



//    val homeState : StateFlow<LceState<S>>
}