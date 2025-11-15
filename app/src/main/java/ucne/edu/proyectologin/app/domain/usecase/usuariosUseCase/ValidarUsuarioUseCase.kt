package ucne.edu.proyectologin.app.domain.usecase.usuariosUseCase

import ucne.edu.proyectologin.app.data.remote.dto.UsuarioDto
import ucne.edu.proyectologin.app.data.remote.resource.Resource
import ucne.edu.proyectologin.app.domain.repository.UsuariosRepository
import javax.inject.Inject

class ValidarUsuariouseCase @Inject constructor(
    private val repository: UsuariosRepository
) {
    suspend operator fun invoke(usuario: UsuarioDto, currentId: Int? = null): Result<Unit> {
        if (usuario.userName.isNullOrBlank()) {
            return Result.failure(IllegalArgumentException("El nombre de usuario no puede estar vacío"))
        }

        if (usuario.password.isNullOrBlank()) {
            return Result.failure(IllegalArgumentException("La contraseña no puede estar vacía"))
        }

        val usuariosResource = repository.getUsuarios()

        val existentes = when (usuariosResource) {
            is Resource.Success -> usuariosResource.data ?: emptyList()
            is Resource.Error -> {
                return Result.failure(
                    IllegalStateException(
                        usuariosResource.message ?: "No se pudieron obtener los usuarios para validar"
                    )
                )
            }
            is Resource.Loading -> emptyList()
        }

        val userNameRepetido = existentes.any {
            it.userName.equals(usuario.userName, ignoreCase = true) &&
                    it.usuarioId != (currentId ?: it.usuarioId)
        }

        return if (userNameRepetido) {
            Result.failure(IllegalStateException("Ya existe un usuario con ese nombre"))
        } else {
            Result.success(Unit)
        }
    }
}