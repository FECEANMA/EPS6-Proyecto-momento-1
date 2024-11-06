package com.example.proyectom.controller

import com.example.proyectom.model.Mesa
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/mesas")
class MesasController {

    @PostMapping("/{id}")
    fun mesas(
        @PathVariable("id") id: Int,
        @RequestParam(value = "Ubicacion", defaultValue = "desconocido") origen: String,
        @RequestBody mesa: Mesa
    ): ResponseEntity<Map<String, Any>> {
        val response = mapOf(
            "status" to "success",
            "data" to mapOf(
                "id" to id,
                "ubicacion" to origen,
                "numeroMesa" to mesa.numeroMesa,
                "disponible" to mesa.disponible
            ),
            "message" to "Actualizado exitosamente."
        )
        return ResponseEntity(response, HttpStatus.ACCEPTED)
    }
}