package ucne.edu.proyectologin.app.presentation.usuarios


import ucne.edu.proyectologin.app.data.remote.dto.UsuarioDto

sealed class UsuarioEvent {

    data class UserNameChanged(val value: String) : UsuarioEvent()
    data class PasswordChanged(val value: String) : UsuarioEvent()
    object Save : UsuarioEvent()
    data class Edit(val usuario: UsuarioDto) : UsuarioEvent()
    object New : UsuarioEvent()
    object DismissDialog : UsuarioEvent()
    object LoadUsuarios : UsuarioEvent()
    object Login : UsuarioEvent()
    object Logout : UsuarioEvent()
}