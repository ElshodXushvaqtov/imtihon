package elshod.imtihon1.screens.info

import android.content.Context
import elshod.imtihon1.database.AppDataBase
import elshod.imtihon1.database.Item

class InfoModel(context: Context) {
    val localDB = AppDataBase.getInstance(context)

    fun getItem(id: Int): Item {
        return localDB.getItemDAO().getData(id)
    }

    fun updateItem(item: Item) {
        localDB.getItemDAO().updateData(item)
    }
}