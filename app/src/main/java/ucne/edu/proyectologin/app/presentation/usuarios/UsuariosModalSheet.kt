package ucne.edu.proyectologin.app.presentation.usuarios


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun UsuarioModalSheet(
    state: UsuarioState,
    onEvent: (UsuarioEvent) -> Unit
) {
    if (!state.isDialogOpen) return

    AlertDialog(
        onDismissRequest = { onEvent(UsuarioEvent.DismissDialog) },
        title = {
            Text(text = if (state.isEditing) "Editar usuario" else "Crear usuario")
        },
        text = {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                OutlinedTextField(
                    value = state.userNameInput,
                    onValueChange = { onEvent(UsuarioEvent.UserNameChanged(it)) },
                    label = { Text("Usuario") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(
                    value = state.passwordInput,
                    onValueChange = { onEvent(UsuarioEvent.PasswordChanged(it)) },
                    label = { Text("Contraseña") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    )
                )
                state.error?.let {
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = it,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        },
        confirmButton = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                TextButton(onClick = { onEvent(UsuarioEvent.DismissDialog) }) {
                    Text("Cancelar")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { onEvent(UsuarioEvent.Save) },
                    enabled = state.userNameInput.isNotBlank() &&
                            state.passwordInput.isNotBlank() &&
                            !state.isLoading
                ) {
                    if (state.isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(18.dp),
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    } else {
                        Text(if (state.isEditing) "Actualizar" else "Crear")
                    }
                }
            }
        },
        dismissButton = {}
    )
}