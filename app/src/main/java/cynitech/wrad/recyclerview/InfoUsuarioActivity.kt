package cynitech.wrad.recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_info_usuario.*

class InfoUsuarioActivity : AppCompatActivity() {

    var usuario: Usuario? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_usuario)

        usuario = intent.getParcelableExtra("usuario-intent")
        val usuarioGuardado: Usuario? = savedInstanceState?.get("usuario") as Usuario?

        Log.e("VERBOSE", "USUARIO RECIBIDO: $usuario ")

        if (usuarioGuardado != null) {
            Log.e("VERBOSE", "USUARIO RECIBIDO GUARDADO: $usuarioGuardado ")
        }
        lbl_cedula_val.text = usuario?.cedula
        lbl_nombre_val.text = usuario?.nombre
        lbl_apellido_val.text = usuario?.apellido
        lbl_descripcion_val.text = usuario?.descripcion
        lbl_fechanac_val.text = usuario?.fechaNacimiento.toString()
        lbl_like_val.text = usuario?.like.toString()


    }
}
