package edu.itsco.misnotasapp.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import edu.itsco.misnotasapp.bd.Nota
import edu.itsco.misnotasapp.bd.NotaRepositorio
import kotlinx.coroutines.launch

class NotaViewModel(private val repositorio: NotaRepositorio): ViewModel(){

    val allNotas: LiveData<List<Nota>> = repositorio.allNotas.asLiveData()

    fun insert(nota: Nota) = viewModelScope.launch {
        repositorio.insert(nota)
    }
}