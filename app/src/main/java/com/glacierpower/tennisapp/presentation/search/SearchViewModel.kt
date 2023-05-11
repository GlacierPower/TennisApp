package com.glacierpower.tennisapp.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.glacierpower.tennisapp.domain.search.SearchInteractor
import com.glacierpower.tennisapp.model.resultModel.SearchResultModel
import com.glacierpower.tennisapp.utils.Constants
import com.glacierpower.tennisapp.utils.InternetConnection
import com.glacierpower.tennisapp.utils.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchInteractor: SearchInteractor
) : ViewModel() {

    @Inject
    lateinit var internetConnection: InternetConnection

    private var _search = MutableLiveData<ResultState<List<SearchResultModel>>>()
    val search: LiveData<ResultState<List<SearchResultModel>>> get() = _search

    private var _connection = MutableLiveData<Boolean>()
    val connection: LiveData<Boolean> get() = _connection

    var searchPage = 1

    fun searchPlayer(query: String) {
        _search.postValue(ResultState.Loading())
        viewModelScope.launch {
            try {
                if (internetConnection.isOnline()) {
                    val searchResponse = searchInteractor.playerSearch(query)
                    _search.value = searchResponse
                    _connection.value = false
                } else {
                    _connection.value = true
                    _search.postValue(ResultState.Error(Constants.NO_CONNECTION))
                }

            } catch (exception: Exception) {
                when (exception) {
                    is IOException -> _search.postValue(ResultState.Error(exception.message!!))
                }
            }
        }

    }

}
