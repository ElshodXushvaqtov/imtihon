package elshod.imtihon1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import elshod.imtihon1.navigation.NavGraph
import elshod.imtihon1.ui.theme.Imtihon1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Imtihon1Theme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}
