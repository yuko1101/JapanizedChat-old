package net.asterium

import net.asterium.utils.Translate
import net.minecraft.client.Minecraft
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
        MinecraftForge.EVENT_BUS.register(this)
    }

    @Mod.EventHandler
    fun start(event: FMLServerStartingEvent) {

    }


    companion object {
        const val MODID = "JapanizedChat"
        const val VERSION = "0.1.0"
    }

    @SubscribeEvent
    fun onChat(event: ClientChatReceivedEvent) {
//            println("> [Chat] ${event.message.formattedText}")
        val text: String = event.message.formattedText
        if (/*text.startsWith(EnumChatFormatting.RESET.toString() + "" + EnumChatFormatting.DARK_AQUA + "Officer >") || */text.startsWith(
                EnumChatFormatting.RESET.toString() + "" + EnumChatFormatting.BLUE + "Party " + EnumChatFormatting.DARK_GRAY + ">")) {
            if (text.contains("://")) return
            if (!EnumChatFormatting.getTextWithoutFormattingCodes(text).all { c -> c.toString().toByteArray().size <= 1 }) return
            val chat: Runnable = Translate(text, "chat")
            Thread(chat).start()
            event.isCanceled = true
        }
    }
}


