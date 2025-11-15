package ucne.edu.proyectologin.app.presentation.navigation



sealed class  UiEvent {
    data class ShowMessage(val message: String) : UiEvent()
    object NavigateBack : UiEvent()
    data class NavigateTo(val route: String) : UiEvent()


}