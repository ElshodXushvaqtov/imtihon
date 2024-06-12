package elshod.imtihon1.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import elshod.imtihon1.database.Item

class HomeViewModel(private val model: HomeModel) : ViewModel() {
    private var _items = MutableLiveData(mutableListOf<Item>())
    val items: LiveData<MutableList<Item>> = _items

    val database = listOf(
        Item(name = "Massasiz zarralar bormi?", description = "Ha, haqiqatan ham nol massaga ega fizik zarralar mavjud. Massasiz zarralar: glyuon, foton va graviton."),
        Item(name = "Olovning soyasi bo'lishi mumkinmi?", description = "Ha, olov soyaga ega bo'lishi mumkin, chunki ular issiq havo va kuyikni o'z ichiga oladi, lekin ular yorug'likni o'z ichiga olmaydi."),
        Item(name = "Oltinni boshqa elementlardan yaratish mumkinmi?", description = "Ha, oltin boshqa elementlardan yaratilishi mumkin. Ammo bu jarayon yadroviy reaktsiyalarni talab qiladi va shu qadar qimmatki, siz hozirda boshqa elementlardan yaratgan oltinni sotish orqali pul ishlay olmaysiz."),
        Item(name = "Vaqt qora tuynuk ichida to'xtaydi.", description = "Bu qora tuynuk ichida, hodisa gorizontida mumkin. Lekin bu biroz qiyin, qora tuynukga tushgan odam uchun emas, uzoqdagi kuzatuvchi uchun vaqt ichida muzlab qoladi. Bu hodisa vaqtining gravitatsion kengayib va shu tufayli sekinlashib, butunlay to'xtab qolishi mumkin."),
        Item(name = "Saturn muz kabi suvda suzishi mumkin.", description = "Agar zichlikni hisobga oladigan bo'lsak, unda bu zichligi suvning zichligidan kamroq bo'lgan yagona sayyoradir, ya'ni. 0,7 g/sm3 (suv zichligi 1 g/sm3). Va flotatsiya nazariyasiga ko'ra, bu suyuqlikda suyuqlikdan pastroq zichlikka ega bo'lgan modda suzadi."),
        Item(name = "Po'lat rezinadan ko'ra elastikroqdir.", description = "Fizikaga ko'ra, elastiklik - bu deformatsiyadan keyin shaklini tiklash uchun materialning xususiyati. Aslida, po'lat rezinadan ancha elastikroq. Shu sababli, u ko'priklar va binolarni qurish uchun ishlatiladi. Deformatsiyalanganda, u o'zining asl shaklini rezinadan yaxshiroq, tezroq tiklashi mumkin.")
    )

    init {
        if (model.isFirstRun()) addItems()
        getItems()
    }

    private fun getItems() {
        _items.value = model.getItems()
    }

    private fun addItems() {
        for (item in database) {
            model.addItem(item)
        }
    }
}