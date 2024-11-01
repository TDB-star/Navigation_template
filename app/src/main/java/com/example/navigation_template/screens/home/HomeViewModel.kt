package com.example.navigation_template.screens.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel(userId: String): ViewModel() {

    private val sourceListSkiers = mutableListOf<Skier>().apply {
        repeat(5) {
            add(Skier(
                skierId = it,
            ))
        }
    }

    private val sourceListPaths = mutableListOf<Path>().apply {
        repeat(20) {
            add(
                Path(
                    name = "mouse",
                    type = PathType.MOUSE
                )
            )
        }
    }

    private val _skiers = MutableLiveData<List<Skier>>(sourceListSkiers)
    val skiers: LiveData<List<Skier>> = _skiers

    private val _paths = MutableLiveData<List<Path>>(sourceListPaths)
    val paths: LiveData<List<Path>> = _paths

    private val _skier = MutableLiveData<Skier>()
    val skier: LiveData<Skier> = _skier

    val initialState = HomeScreenState.Home(sourceListSkiers, sourceListPaths)

    private val _screenState = MutableLiveData<HomeScreenState>(initialState)
    val screenState: LiveData<HomeScreenState> = _screenState

    init {
        loadData(userId)
    }

    fun changeStatus(skier: Skier) {
//        val newSkierList = _skiers.value?.toMutableList() ?: mutableListOf()
//        newSkierList.replaceAll {
//            if (it == skier) {
//                it.copy(skierSelected = !it.skierSelected)
//            } else {
//                it
//            }
//        }
//        _skiers.value = newSkierList
        _skiers.value?.forEach {it.selected = false}
        _skiers.value?.find { it.skierId == skier.skierId }?.selected = true
    }


    fun selectedPath(path: Path, skier: Skier) {
        if (skier.selected) {
            // navigate on path
            Log.d("TAG", path.name)
        } else {
            Log.d("TAG", "no selection")
        }
    }

    fun selectedSkier(skier:Skier) {
        if (skier.selected) {
            _skier.value = skier
        }
    }

    private fun loadData(userId: String) {
        val skiers = mutableListOf<Skier>().apply {
            repeat(5) {
                add(Skier(skierId = it))
            }
        }
        _screenState.value = HomeScreenState.Home(skiers, sourceListPaths)
    }
}

sealed class HomeScreenState {

    object Initial: HomeScreenState()

    data class Home(val skiers: List<Skier>, val paths: List<Path>): HomeScreenState()
    data class SkierPath(val skier: Skier, val path: Path): HomeScreenState()
}


data class Skier(
    val skierId: Int,
    val avatarLink: String = "",
    val name: String = "Alex",
    val surname: String = "Post",
    val birthDate: String = "23.12.2008",
    val instructor: String = "Mick",
    var skierSelected: Boolean = false,
   // var SkierProgress: listOf<PathEntity>
) {
    var selected by mutableStateOf(skierSelected)
}

data class Path(
    val itemImage: String = "",
    val name: String = "Mouse",
    val backgroundTerrainImage: String = "",
    val pathImage: String = "",
    val type: PathType = PathType.MOUSE,
    //val cristals: [CristalEntity]
    var isValidated: Boolean = false,
    var progress: Int = 0
) {


}