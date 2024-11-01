package com.example.navigation_template.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PathViewModel: ViewModel() {

    private val _screenState = MutableLiveData<PathScreenState>(PathScreenState.Initial)
    val screenState: LiveData<PathScreenState> = _screenState

    fun loadData(skier: Skier, path: Path) {


    }
}


sealed class PathScreenState {

    object Initial: PathScreenState()

    data class SkierPath(
        val skier: Skier,
        val path: Path,
        val crystals: List<Crystal>): PathScreenState()
}

data class Crystal(
    val type: PathType,
    val name: String,
    val image: String = ""
)