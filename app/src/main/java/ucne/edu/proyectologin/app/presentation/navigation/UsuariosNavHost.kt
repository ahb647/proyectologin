package ucne.edu.proyectologin.app.presentation.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ucne.edu.proyectologin.app.presentation.usuarios.UsuariosScreen
import ucne.edu.proyectologin.app.presentation.usuarios.VerificacionScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            UsuariosScreen(
                onLoginSuccess = {
                    navController.navigate(Screen.Verificacion.route) {
                        popUpTo(Screen.Login.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(Screen.Verificacion.route) {
            VerificacionScreen(
                onLogout = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Login.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}