package elshod.imtihon1.screens.favourites

import android.content.Context
import elshod.imtihon1.database.AppDataBase
import elshod.imtihon1.database.Item

class FavouritesModel(context: Context) {
    val localDB = AppDataBase.getInstance(context)

    fun getLikedItems(): MutableList<Item> {
        return localDB.getItemDAO().getLikedData()
    }
}