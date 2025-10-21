package mvi

import androidx.lifecycle.ViewModel

interface ViewModelAssistedFactory<ArgsT, VM : ViewModel> {
    fun create(args: ArgsT): VM
}
