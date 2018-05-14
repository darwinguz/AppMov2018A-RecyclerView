package cynitech.wrad.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.lista_fila_usuario.view.*
import java.util.*

class AdapatadorUsuario(private val usuarios: ArrayList<Usuario>) :
        RecyclerView.Adapter<AdapatadorUsuario.ViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class ViewHolder(val textView: View) : RecyclerView.ViewHolder(textView) {
        val cedula = textView.lbl_apellido
        val nombre = textView.lbl_nombre
        val apellido = textView.lbl_apellido
    }


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): AdapatadorUsuario.ViewHolder {
        // create a new view
        val textView = LayoutInflater.from(parent.context)
                .inflate(R.layout.lista_fila_usuario, parent, false)
        // set the view's size, margins, paddings and layout parameters
        //...
        return ViewHolder(textView)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        holder.cedula.text = usuarios[position].cedula
        holder.nombre.text = usuarios[position].nombre
        holder.apellido.text = usuarios[position].apellido
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = usuarios.size
}