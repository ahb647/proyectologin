package ucne.edu.proyectologin.app.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class UsuarioDto(
    val usuarioId: Int,
    val userName: String? = null,
    val password: String? = null
)