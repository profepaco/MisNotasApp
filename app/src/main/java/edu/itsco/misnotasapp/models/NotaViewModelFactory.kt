package edu.itsco.misnotasapp.models


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.itsco.misnotasapp.bd.NotaRepositorio
import java.lang.IllegalArgumentException

class NotaViewModelFactory(private val repositorio: NotaRepositorio):
ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(NotaViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return NotaViewModel(repositorio) as T
        }
        throw IllegalArgumentException("Clase de ViewModel desconocida")
    }
}