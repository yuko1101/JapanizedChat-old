package io.github.yuko1101.japanizedchat

import gg.essential.vigilance.Vigilant
import gg.essential.vigilance.data.Property
import gg.essential.vigilance.data.PropertyType
import java.io.File

object Config : Vigilant(File("./config/JapanizedChat.toml")) {

    @Property(
        type = PropertyType.SWITCH,
        name = "Enabled",
        description = "チャットの日本語化のON/OFF",
        category = "System"
    )
    var isEnabled = true
}