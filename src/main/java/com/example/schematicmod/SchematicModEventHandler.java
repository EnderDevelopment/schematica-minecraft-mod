package com.example.schematicmod;

import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "schematicmod", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SchematicModEventHandler {
    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        SchematicCommand.register(event.getDispatcher());
    }
}