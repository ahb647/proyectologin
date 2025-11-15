package ucne.edu.proyectologin.app.domain.usecase.usuariosUseCase

import ucne.edu.proyectologin.app.data.remote.dto.UsuarioDto
import ucne.edu.proyectologin.app.data.remote.resource.Resource
import ucne.edu.proyectologin.app.domain.repository.UsuariosRepository
import javax.inject.Inject

class ObtenerUsuarioUseCase @Inject constructor(
    private val repository: UsuariosRepository
) {
    suspend operator fun invoke(id: Int): Resource<UsuarioDto> {
        return repository.getUsuario(id)
    }
}