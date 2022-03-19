package edu.itsco.misnotasapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class NuevaNotaActivity : AppCompatActivity() {

    private lateinit var txtTitulo: EditText
    private lateinit var txtContenido: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva_nota)

        txtTitulo = findViewById(R.id.txt_titulo)
        txtContenido = findViewById(R.id.txt_contenido)

        val btnGuardar = findViewById<Button>(R.id.btn_guardar)

        btnGuardar.setOnClickListener {
            val intent = Intent()
            if(TextUtils.isEmpty(txtTitulo.text)||TextUtils.isEmpty(txtContenido.text)){
                setResult(RESULT_CANCELED,intent)
            }else{
                val titulo = txtTitulo.text.toString()
                val contenido = txtContenido.text.toString()

                intent.putExtra(TITULO,titulo)
                intent.putExtra(CONTENIDO, contenido)

                setResult(RESULT_OK,intent)
            }
            finish()
        }
    }

    companion object{
        const val TITULO = "edu.itsco.TITULO_NOTA"
        const val CONTENIDO = "edu.itsco.CONTENIDO_NOTA"
    }
}