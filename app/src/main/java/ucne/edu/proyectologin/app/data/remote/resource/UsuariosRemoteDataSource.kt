package ucne.edu.proyectologin.app.data.remote.resource

import retrofit2.HttpException
import ucne.edu.proyectologin.app.data.remote.UsuariosApi
import ucne.edu.proyectologin.app.data.remote.dto.UsuarioDto
import java.io.IOException
import javax.inject.Inject

class UsuarioRemoteDataSource @Inject constructor(
    private val api: UsuariosApi
) {

    suspend fun getUsuarios(): Resource<List<UsuarioDto>> {
        return try {
            val response = api.getUsuarios()
            if (response.isSuccessful) {
                response.body()?.let { Resource.Success(it) }
                    ?: Resource.Error("Respuesta vacía del servidor")
            } else {
                Resource.Error("HTTP ${response.code()} ${response.message()}")
            }
        } catch (e: IOException) {
            Resource.Error("Error de red: ${e.message}")
        } catch (e: HttpException) {
            Resource.Error("Error HTTP ${e.code()}: ${e.message()}")
        } catch (e: Exception) {
            Resource.Error("Error inesperado: ${e.message}")
        }
    }

    suspend fun getUsuario(id: Int): Resource<UsuarioDto> {
        return try {
            val response = api.getUsuario(id)
            if (response.isSuccessful) {
                response.body()?.let { Resource.Success(it) }
                    ?: Resource.Error("Respuesta vacía del servidor")
            } else {
                Resource.Error("HTTP ${response.code()} ${response.message()}")
            }
        } catch (e: IOException) {
            Resource.Error("Error de red: ${e.message}")
        } catch (e: HttpException) {
            Resource.Error("Error HTTP ${e.code()}: ${e.message()}")
        } catch (e: Exception) {
            Resource.Error("Error inesperado: ${e.message}")
        }
    }

    suspend fun postUsuario(request: UsuarioDto): Resource<UsuarioDto> {
        return try {
            val response = api.postUsuario(request)
            if (response.isSuccessful) {
                response.body()?.let { Resource.Success(it) }
                    ?: Resource.Error("Respuesta vacía del servidor")
            } else {
                Resource.Error("HTTP ${response.code()} ${response.message()}")
            }
        } catch (e: IOException) {
            Resource.Error("Error de red: ${e.message}")
        } catch (e: HttpException) {
            Resource.Error("Error HTTP ${e.code()}: ${e.message()}")
        } catch (e: Exception) {
            Resource.Error("Error inesperado: ${e.message}")
        }
    }

    suspend fun putUsuario(id: Int, request: UsuarioDto): Resource<Unit> {
        return try {
            val response = api.putUsuario(id, request)
            if (response.isSuccessful) {
                Resource.Success(Unit)
            } else {
                Resource.Error("HTTP ${response.code()} ${response.message()}")
            }
        } catch (e: IOException) {
            Resource.Error("Error de red: ${e.message}")
        } catch (e: HttpException) {
            Resource.Error("Error HTTP ${e.code()}: ${e.message()}")
        } catch (e: Exception) {
            Resource.Error("Error inesperado: ${e.message}")
        }
    }
}
