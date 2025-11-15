package ucne.edu.proyectologin.app.presentation.usuarios

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun VerificacionScreen(
    onLogout: () -> Unit,
    viewModel: UsuariosViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val nameToShow = state.loggedInUserName ?: "Usuario"

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = {
                viewModel.onEvent(UsuarioEvent.Logout)
                onLogout()
            },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        ) {
            Text(text = "Cerrar sesión")
        }

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Logeado con éxito")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Bienvenido $nameToShow")
        }
    }
}