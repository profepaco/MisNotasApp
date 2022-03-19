package edu.itsco.misnotasapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.itsco.misnotasapp.adapters.NotaListAdapter
import edu.itsco.misnotasapp.bd.Nota
import edu.itsco.misnotasapp.models.NotaViewModel
import edu.itsco.misnotasapp.models.NotaViewModelFactory

class MainActivity : AppCompatActivity() {

    private val notasViewModel: NotaViewModel by viewModels{
        NotaViewModelFactory((application as NotasApplication).repositorio)
    }

    val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){ result: ActivityResult->
        if(result.resultCode == RESULT_OK){
            result.data?.let{
                val titulo = it.getStringExtra(NuevaNotaActivity.TITULO)
                val contenido = it.getStringExtra(NuevaNotaActivity.CONTENIDO)
                val nota = Nota(0,titulo!!,contenido!!)
                notasViewModel.insert(nota)
            }
        }else{
            Toast.makeText(
                this.applicationContext,
                "No se pudo registrar la nota",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_notas)
        val adapter = NotaListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        //Creando el observador
        notasViewModel.allNotas.observe(this){ notas ->
            notas.let{ adapter.submitList(it)}
        }

        val fabAdd = findViewById<FloatingActionButton>(R.id.fab_add_nota)
        fabAdd.setOnClickListener {
            val intent = Intent(this@MainActivity, NuevaNotaActivity::class.java)
            startForResult.launch(intent)
        }
    }
}