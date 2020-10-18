package app.babachan.makeYourPalette

import io.realm.RealmObject

open class ColorPalette (
    open var value: Int = 0
//いらない気がする
): RealmObject()