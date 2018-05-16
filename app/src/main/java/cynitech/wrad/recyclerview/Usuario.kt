package cynitech.wrad.recyclerview

import android.os.Parcel
import android.os.Parcelable
import java.util.*

class Usuario constructor(var cedula: String,
                          var nombre: String,
                          var apellido: String,
                          var descripcion: String,
                          var fechaNacimiento: Date?,
                          var like: Boolean) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.leerDate(),
            parcel.readByte() != 0.toByte()) {
    }

    override fun toString(): String {
        return "$cedula $nombre $apellido $descripcion $fechaNacimiento $like"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(cedula)
        parcel.writeString(nombre)
        parcel.writeString(apellido)
        parcel.writeString(descripcion)
        parcel?.escribirDate(fechaNacimiento)
        parcel.writeByte(if (like) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Usuario> {
        override fun createFromParcel(parcel: Parcel): Usuario {
            return Usuario(parcel)
        }

        override fun newArray(size: Int): Array<Usuario?> {
            return arrayOfNulls(size)
        }
    }
}


fun Parcel.escribirDate(date: Date?) {
    writeLong(date?.time ?: -1)
}

fun Parcel.leerDate(): Date? {
    val long = readLong()
    return if (long != -1L) Date(long) else null
}
