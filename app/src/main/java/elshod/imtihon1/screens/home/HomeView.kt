package elshod.imtihon1.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import elshod.imtihon1.screens.BottomNavigationComponent

@Composable
fun HomeView(viewModel: HomeViewModel, navController: NavController) {
    val items = viewModel.items.observeAsState().value
    Scaffold(bottomBar = {
        BottomNavigationComponent(navController = navController)
    }) {
        Text(text = "Fizikadan qiziqarli 3 ta savol va 3 ta fakt", fontSize = 20.sp, modifier = Modifier.padding(start = 20.dp, top = 10.dp), style = TextStyle(textAlign = TextAlign.Center))
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .padding(10.dp)
        ) {
            items(items!!) {
                item ->
                Text(item.name,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp)
                        .clickable {
                            navController.navigate("Info/${item.id}")
                        })
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}