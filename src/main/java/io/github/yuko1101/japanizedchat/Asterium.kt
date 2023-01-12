package io.github.yuko1101.japanizedchat

import gg.essential.api.EssentialAPI
import gg.essential.api.utils.Multithreading
import io.github.yuko1101.japanizedchat.commands.MainCommand
import io.github.yuko1101.japanizedchat.utils.ChatLib
import io.github.yuko1101.japanizedchat.utils.Translate
import net.minecraft.client.Minecraft
import net.minecraft.util.ChatComponentText
import net.minecraft.util.EnumChatFormatting
import net.minecraftforge.client.event.ClientChatReceivedEvent
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLServerStartingEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent


@Mod(modid = Asterium.MODID, version = Asterium.VERSION)
class Asterium {
    private val mc: Minecraft = Minecraft.getMinecraft()


    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
        config.initialize()

        MinecraftForge.EVENT_BUS.register(this)
        EssentialAPI.getCommandRegistry().registerCommand(MainCommand())
    }

    @Mod.EventHandler
    fun start(event: FMLServerStartingEvent) {

    }


    companion object {
        const val MODID = "japanizedchat"
        const val VERSION = "0.2.0"
        val config = Config

    }

    @SubscribeEvent
    fun onChat(event: ClientChatReceivedEvent) {
//            println("> [Chat] ${event.message.formattedText}")
        if (!config.isEnabled) return
        val text: String = event.message.formattedText
        if (/*text.startsWith(EnumChatFormatting.RESET.toString() + "" + EnumChatFormatting.DARK_AQUA + "Officer >") || */text.startsWith(
                EnumChatFormatting.RESET.toString() + "" + EnumChatFormatting.BLUE + "Party " + EnumChatFormatting.DARK_GRAY + ">")) {
            if (text.contains("://")) return
            if (!EnumChatFormatting.getTextWithoutFormattingCodes(text).all { c -> c.toString().toByteArray().size <= 1 }) return
            val msgStartString = EnumChatFormatting.WHITE.toString() + ": " + EnumChatFormatting.RESET
            val msgStartIndex = text.indexOf(msgStartString) + msgStartString.length
            if (msgStartIndex == -1) return
            val msg = text.substring(msgStartIndex)
            event.isCanceled = true
            Multithreading.runAsync {
                val components = event.message.siblings
                components.add(ChatComponentText(" ${EnumChatFormatting.GOLD}(${Translate.convByGoogleIME(Translate.toKana(msg))}${EnumChatFormatting.GOLD})"))
                ChatLib.components(components)
            }

        }
    }
}


