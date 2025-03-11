open class Mascota(
    var nombre: String,
    var especie: String,
    var edad: Int,
    var peso: Double
) {
    fun actualizarPeso(nuevoPeso: Double) {
        peso = nuevoPeso
    }

    fun actualizarEdad(nuevaEdad: Int) {
        edad = nuevaEdad
    }

    open fun describirMascota(): String {
        return "Nombre: $nombre, Especie: $especie, Edad: $edad años, Peso: $peso kg"
    }
}