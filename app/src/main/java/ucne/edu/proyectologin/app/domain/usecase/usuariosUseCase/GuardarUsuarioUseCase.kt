package ucne.edu.proyectologin.app.domain.usecase.usuariosUseCase

import ucne.edu.proyectologin.app.data.remote.dto.UsuarioDto
import ucne.edu.proyectologin.app.data.remote.resource.Resource
import ucne.edu.proyectologin.app.domain.repository.UsuariosRepository
import javax.inject.Inject

class GuardarUsuariouseCase @Inject constructor(
    private val repository: UsuariosRepository,
    private val validarUsuario: ValidarUsuariouseCase
) {
    suspend operator fun invoke(usuarioId: Int?, usuario: UsuarioDto): Result<Unit> {
        val validacion = validarUsuario(usuario, usuarioId)
        if (validacion.isFailure) {
            return Result.failure(validacion.exceptionOrNull()!!)
        }

        return try {
            val response: Resource<*> = if (usuarioId == null || usuarioId == 0) {
                repository.postUsuario(
                    usuario.copy(usuarioId = 0)
                )
            } else {
                repository.putUsuario(
                    usuarioId,
                    usuario.copy(usuarioId = usuarioId)
                )
            }

            if (response.isSuccess()) {
                Result.success(Unit)
            } else {
                Result.failure(Exception(response.message ?: "Error al guardar el usuario"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}