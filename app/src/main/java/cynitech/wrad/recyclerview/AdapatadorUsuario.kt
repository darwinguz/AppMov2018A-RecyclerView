package cynitech.wrad.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
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
        var cedula = textView.lbl_cedula
        var nombre = textView.lbl_nombre
        var apellido = textView.lbl_apellido
        var btnLike = textView.btn_like
        var btnDetail = textView.btn_detail
    }


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): AdapatadorUsuario.ViewHolder {
        // create a new view
        val textView = LayoutInflater.from(parent.context)//root=null para que se ajuste la pantalla
                .inflate(R.layout.lista_fila_usuario, null, false)
        // set the view's size, margins, paddings and layout parameters
        //...
        return ViewHolder(textView)
    }

    // Replace the contents of a view (invoked by the layout manager)
    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        val context = this

        holder.cedula.text = usuarios[position].cedula
        holder.nombre.text = usuarios[position].nombre
        holder.apellido.text = usuarios[position].apellido
        holder.btnLike.text = if (usuarios[position].like) "No like" else "Like"
        holder.btnLike.setBackgroundColor(if (usuarios[position].like) Color.YELLOW else Color.BLUE)

        holder.btnLike.setOnClickListener(View.OnClickListener {
            //FIXME NO FUNCA EL COLOR DESDE R.color.*
            if (!usuarios[position].like) {
                holder.btnLike.text = "No like"
                //holder.btnLike.setBackgroundColor(R.color.colorUnlike)
                holder.btnLike.setBackgroundColor(Color.YELLOW)
            } else {
                holder.btnLike.text = "Like"
                //holder.btnLike.setBackgroundColor(R.color.colorLike)
                holder.btnLike.setBackgroundColor(Color.BLUE)
            }
            usuarios[position].like = !usuarios[position].like
        })

        holder.btnDetail.setOnClickListener { v ->
            irAActividadInfoUsuario(v.context, usuarios[position])
        }

    }

    fun irAActividadInfoUsuario(context: Context, usuarioSelected: Usuario) {
        val intent = Intent(context, InfoUsuarioActivity::class.java)
        intent.putExtra("usuario-intent", usuarioSelected)
        Log.e("VERBOSE", "USUARIO ENVIADO: $usuarioSelected ")

        startActivity(context, intent, null)
    }


    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = usuarios.size
}