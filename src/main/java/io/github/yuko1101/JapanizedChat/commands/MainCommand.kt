package io.github.yuko1101.JapanizedChat.commands

import gg.essential.api.commands.Command
import gg.essential.api.commands.DefaultHandler
import gg.essential.api.commands.SubCommand
import gg.essential.api.utils.GuiUtil
import io.github.yuko1101.JapanizedChat.Asterium
import java.util.*


class MainCommand : Command("japanizedchat") {
    @DefaultHandler
    fun handle() {
        Objects.requireNonNull(Asterium.config.gui())?.let { GuiUtil.open(it) }
    }

    @SubCommand(value = "toggle", description = "Toggle your JapanizedChat enabled or disabled.")
    fun refresh() {
        Asterium.config.isEnabled = !Asterium.config.isEnabled

    }
}