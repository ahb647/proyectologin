package ucne.edu.proyectologin.app.data.remote

import retrofit2.Response
import retrofit2.http.*
import ucne.edu.proyectologin.app.data.remote.dto.UsuarioDto

interface UsuariosApi {

    @GET("api/Usuarios")
    suspend fun getUsuarios(): Response<List<UsuarioDto>>

    @POST("api/Usuarios")
    suspend fun postUsuario(@Body usuario: UsuarioDto): Response<UsuarioDto>

    @GET("api/Usuarios/{id}")
    suspend fun getUsuario(@Path("id") id: Int): Response<UsuarioDto>

    @PUT("api/Usuarios/{id}")
    suspend fun putUsuario(
        @Path("id") id: Int,
        @Body usuario: UsuarioDto): Response<Unit>
}