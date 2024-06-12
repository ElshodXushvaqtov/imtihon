package elshod.imtihon1.screens.info

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import elshod.imtihon1.screens.BottomNavigationComponent
import elshod.imtihon1.screens.info.InfoViewModel

@Composable
fun InfoView(viewModel: InfoViewModel, navController: NavController) {
    val item by viewModel.item.observeAsState()
    Scaffold(bottomBar = {
        BottomNavigationComponent(navController = navController)
    }) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(10.dp)
        ) {
            Text(item!!.name, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(25.dp))
            Text(item!!.description, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(25.dp))
            IconButton(onClick = {
                viewModel.onClick()
                viewModel.updateItem()
            }) {
                if (item!!.liked) Icon(Icons.Default.Favorite, contentDescription = null)
                else Icon(Icons.Default.FavoriteBorder, contentDescription = null)
            }
        }
    }
}