package ucne.edu.proyectologin.app.data.mapper


import ucne.edu.proyectologin.app.data.remote.dto.UsuarioDto
import ucne.edu.proyectologin.app.domain.model.Usuario

fun UsuarioDto.toDomain(): Usuario {
    return Usuario(
        usuarioId = this.usuarioId,
        userName = this.userName,
        password = this.password
    )
}

fun Usuario.toDto(): UsuarioDto {
    return UsuarioDto(
        usuarioId = this.usuarioId,
        userName = this.userName,
        password = this.password
    )
}