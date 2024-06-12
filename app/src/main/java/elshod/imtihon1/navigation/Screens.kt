package elshod.imtihon1.navigation

sealed class Screens(val route: String) {
    data object Home : Screens("Home")
    data object Favourites : Screens("Saved")
    data object Info : Screens("Info/{key}")
}