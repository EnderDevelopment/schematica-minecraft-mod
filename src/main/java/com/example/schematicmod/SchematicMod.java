package com.example.schematicmod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.IEventBus;

@Mod("schematicmod")
public class SchematicMod {
    public SchematicMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register any mod-specific events or registries here
    }
}