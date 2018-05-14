package cynitech.wrad.recyclerview

import java.time.LocalDate
import java.util.*

class Factory {
    companion object {
        var usuarios: ArrayList<Usuario> = ArrayList()

        init {
            usuarios.add(Usuario("1734584736", "Adrian", "Eguez", "Ing. en Sistemas", Date(), true))
            usuarios.add(Usuario("1775384737", "Darwin", "Guzman", "Ing. en Electronica", Date(), true))
            usuarios.add(Usuario("1797584738", "Lola", "Alarcon", "Ing. Civil", Date(), false))

        }

    }
}