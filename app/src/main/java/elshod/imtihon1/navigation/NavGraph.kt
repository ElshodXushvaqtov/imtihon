package elshod.imtihon1.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import elshod.imtihon1.screens.favourites.FavouritesModel
import elshod.imtihon1.screens.favourites.FavouritesView
import elshod.imtihon1.screens.favourites.FavouritesViewModel
import elshod.imtihon1.screens.home.HomeModel
import elshod.imtihon1.screens.home.HomeView
import elshod.imtihon1.screens.home.HomeViewModel
import elshod.imtihon1.screens.info.InfoModel
import elshod.imtihon1.screens.info.InfoView
import elshod.imtihon1.screens.info.InfoViewModel

@Composable
fun NavGraph(navController: NavHostController) {
    val context = LocalContext.current
    NavHost(
        navController = navController, startDestination = Screens.Home.route
    ) {
        composable(route = Screens.Home.route) {
            val model = HomeModel(context)
            val viewModel = HomeViewModel(model)
            HomeView(viewModel, navController)
        }
        composable(route = Screens.Favourites.route) {
            val model = FavouritesModel(context)
            val viewModel = FavouritesViewModel(model)
            FavouritesView(viewModel, navController)
        }
        composable(
            route = Screens.Info.route, arguments = listOf(navArgument("key") {
                type = NavType.IntType
            })
        ) {
            val id = it.arguments?.getInt("key")!!
            val model = InfoModel(context)
            val viewModel = InfoViewModel(model, id)
            InfoView(viewModel, navController)
        }
    }
}