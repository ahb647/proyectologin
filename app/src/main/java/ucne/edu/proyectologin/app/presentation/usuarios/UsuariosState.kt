package ucne.edu.proyectologin.app.presentation.usuarios

import ucne.edu.proyectologin.app.data.remote.dto.UsuarioDto

data class UsuarioState(
    val isLoading: Boolean = false,
    val usuarios: List<UsuarioDto> = emptyList(),
    val error: String? = null,

    val isDialogOpen: Boolean = false,
    val isEditing: Boolean = false,
    val usuarioId: Int? = null,

    val userNameInput: String = "",
    val passwordInput: String = "",

    val isLoggedIn: Boolean = false,
    val loggedInUserName: String? = null
)