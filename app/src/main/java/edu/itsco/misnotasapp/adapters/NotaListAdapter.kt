package edu.itsco.misnotasapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import edu.itsco.misnotasapp.R
import edu.itsco.misnotasapp.bd.Nota

class NotaListAdapter: ListAdapter<Nota, NotaListAdapter.ViewHolder>(NotasComparator()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotaListAdapter.ViewHolder {
        return ViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: NotaListAdapter.ViewHolder, position: Int) {
        val nota = getItem(position)
        holder.bind(nota.titulo)
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        private  val lbTitulo: TextView = view.findViewById(R.id.lb_titulo_nota)

        fun bind(titulo: String){
            lbTitulo.text = titulo
        }

        companion object {
            fun create(parent: ViewGroup):ViewHolder{
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.nota_item,parent,false)
                return ViewHolder(view)
            }
        }
    }

    class NotasComparator: DiffUtil.ItemCallback<Nota>(){
        override fun areItemsTheSame(oldItem: Nota, newItem: Nota): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Nota, newItem: Nota): Boolean {
            return oldItem.titulo == newItem.titulo
        }
    }
}