package ucne.edu.proyectologin.app.data.repository

import ucne.edu.proyectologin.app.data.remote.dto.UsuarioDto
import ucne.edu.proyectologin.app.data.remote.resource.Resource
import ucne.edu.proyectologin.app.data.remote.resource.UsuarioRemoteDataSource
import ucne.edu.proyectologin.app.domain.repository.UsuariosRepository
import javax.inject.Inject

class UsuariosRepositoryApi @Inject constructor(
    private val remoteDataSource: UsuarioRemoteDataSource
) : UsuariosRepository {

    override suspend fun getUsuarios(): Resource<List<UsuarioDto>> {
        return remoteDataSource.getUsuarios()
    }

    override suspend fun getUsuario(id: Int): Resource<UsuarioDto> {
        return remoteDataSource.getUsuario(id)
    }

    override suspend fun postUsuario(usuario: UsuarioDto): Resource<UsuarioDto> {
        return remoteDataSource.postUsuario(usuario)
    }

    override suspend fun putUsuario(id: Int, usuario: UsuarioDto): Resource<Unit> {
        return remoteDataSource.putUsuario(id, usuario)
    }
}