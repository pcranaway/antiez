package top.retarders.antiez;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = "AntiEZ", version = "1.0")
public class AntiEZMod {

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void receiveChatMessage(ClientChatReceivedEvent event) {
        if(event.message.toString().toLowerCase().contains(" ez")) {
            event.setCanceled(true);

            Minecraft.getMinecraft().thePlayer.addChatMessage(
                    new ChatComponentText("[Blocked a toxic message]")
                            .setChatStyle(new ChatStyle().setBold(true))
            );
        }
    }

}
