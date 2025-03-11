class ConsultaMedica(
    var mascota: Mascota,
    var diagnostico: String,
    var costoBase: Double,
    var incluyeMedicacion: Boolean
) {
    fun calcularCosto(): Double {
        return if (incluyeMedicacion) {
            costoBase * 1.15
        } else {
            costoBase
        }
    }

    fun describirConsulta(): String {
        return "Mascota: ${mascota.nombre}, Diagnóstico: $diagnostico, Costo: ${calcularCosto()}"
    }
}