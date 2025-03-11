fun main() {
    val mascotas = mutableListOf<Mascota>()
    val consultas = mutableListOf<ConsultaMedica>()

    fun agregarMascota(mascota: Mascota) {
        mascotas.add(mascota)
    }

    fun registrarConsulta(consulta: ConsultaMedica) {
        consultas.add(consulta)
    }

    fun mostrarMascotas(): List<String> {
        return mascotas.map { it.describirMascota() }
    }

    fun mostrarHistorialConsultas(): List<String> {
        return consultas.map { it.describirConsulta() }
    }

    fun modificarPesoMascota(mascota: Mascota, nuevoPeso: Double) {
        mascota.actualizarPeso(nuevoPeso)
    }

    fun actualizarEdadMascota(mascota: Mascota, nuevaEdad: Int) {
        mascota.actualizarEdad(nuevaEdad)
    }

    fun buscarMascotaPorNombre(nombre: String): Mascota? {
        return mascotas.find { it.nombre == nombre }
    }

    while (true) {
        println("\nSeleccione una opción:")
        println("1. Agregar mascota")
        println("2. Registrar consulta médica")
        println("3. Mostrar mascotas")
        println("4. Mostrar historial de consultas")
        println("5. Modificar peso de mascota")
        println("6. Modificar edad de mascota")
        println("7. Salir")
        when (readLine()!!.toInt()) {
            1 -> {
                println("Ingrese el nombre de la mascota:")
                val nombre = readLine()!!.trim()
                println("Ingrese la especie de la mascota:")
                val especie = readLine()!!.trim()
                println("Ingrese la edad de la mascota en años:")
                val edad = readLine()!!.toInt()
                println("Ingrese el peso de la mascota en kilos:")
                val peso = readLine()!!.toDouble()
                agregarMascota(Mascota(nombre, especie, edad, peso))
            }
            2 -> {
                println("Ingrese el nombre de la mascota para la consulta:")
                val nombreMascota = readLine()!!.trim()
                val mascota = buscarMascotaPorNombre(nombreMascota)
                if (mascota != null) {
                    println("Ingrese el diagnóstico:")
                    val diagnostico = readLine()!!.trim()
                    println("Ingrese el costo base de la consulta en pesos colombianos:")
                    val costoBase = readLine()!!.toDouble()
                    println("¿Incluye medicación? (true/false):")
                    val incluyeMedicacion = readLine()!!.toBoolean()
                    registrarConsulta(ConsultaMedica(mascota, diagnostico, costoBase, incluyeMedicacion))
                } else {
                    println("Mascota no encontrada.")
                }
            }
            3 -> mostrarMascotas().forEach { println(it) }
            4 -> mostrarHistorialConsultas().forEach { println(it) }
            5 -> {
                println("Ingrese el nombre de la mascota para modificar el peso:")
                val nombre = readLine()!!.trim()
                val mascota = buscarMascotaPorNombre(nombre)
                if (mascota != null) {
                    println("Ingrese el nuevo peso:")
                    val nuevoPeso = readLine()!!.toDouble()
                    modificarPesoMascota(mascota, nuevoPeso)
                } else {
                    println("Mascota no encontrada.")
                }
            }
            6 -> {
                println("Ingrese el nombre de la mascota para modificar la edad:")
                val nombre = readLine()!!.trim()
                val mascota = buscarMascotaPorNombre(nombre)
                if (mascota != null) {
                    println("Ingrese la nueva edad de la mascota:")
                    val nuevaEdad = readLine()!!.toInt()
                    actualizarEdadMascota(mascota, nuevaEdad)
                } else {
                    println("Mascota no encontrada.")
                }
            }
            7 -> {
                println("Gracias por usar el programa")
                break
            }
            else -> println("Opción no válida. Intente de nuevo.")
        }
    }
}