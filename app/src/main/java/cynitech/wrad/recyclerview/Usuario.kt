package cynitech.wrad.recyclerview

import java.util.*

class Usuario constructor(var cedula: String,
                          var nombre: String,
                          var apellido: String,
                          var descripcion: String,
                          var fechaNacimiento: Date,
                          var like: Boolean) {

    override fun toString(): String {
        return "$cedula $nombre $apellido $descripcion $fechaNacimiento $like"
    }
}

