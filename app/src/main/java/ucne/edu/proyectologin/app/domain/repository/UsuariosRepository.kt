package ucne.edu.proyectologin.app.domain.repository

import ucne.edu.proyectologin.app.data.remote.dto.UsuarioDto
import ucne.edu.proyectologin.app.data.remote.resource.Resource

interface UsuariosRepository {

    suspend fun getUsuarios(): Resource<List<UsuarioDto>>

    suspend fun getUsuario(id: Int): Resource<UsuarioDto>

    suspend fun postUsuario(usuario: UsuarioDto): Resource<UsuarioDto>

    suspend fun putUsuario(id: Int, usuario: UsuarioDto): Resource<Unit>
}