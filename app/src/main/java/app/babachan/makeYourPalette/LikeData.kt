package app.babachan.makeYourPalette

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class LikeData (
    @PrimaryKey open var id: String = UUID.randomUUID().toString(),
    open var name: String ="",
    open var primaryR: Int = 0,
    open var primaryG: Int = 0,
    open var primaryB: Int = 0,
    open var primary: Int = 0,
    open var primaryDarkR: Int = 0,
    open var primaryDarkG: Int = 0,
    open var primaryDarkB: Int = 0,
    open var dark: Int =0,
    open var accentR: Int =0,
    open var accentG: Int =0,
    open var accentB: Int =0,
    open var accent: Int = 0
): RealmObject()