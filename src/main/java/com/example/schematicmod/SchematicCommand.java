package com.example.schematicmod;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public class SchematicCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("schematic")
            .then(Commands.literal("save")
                .then(Commands.argument("name", StringArgumentType.string())
                    .executes(SchematicCommand::saveSchematic)))
            .then(Commands.literal("load")
                .then(Commands.argument("name", StringArgumentType.string())
                    .executes(SchematicCommand::loadSchematic)))
            .then(Commands.literal("place")
                .then(Commands.argument("name", StringArgumentType.string())
                    .executes(SchematicCommand::placeSchematic))));
    }

    private static int saveSchematic(CommandContext<CommandSourceStack> context) {
        String name = StringArgumentType.getString(context, "name");
        CommandSourceStack source = context.getSource();
        Level level = source.getLevel();
        BlockPos pos = new BlockPos(source.getPosition());
        // Logic to save the schematic
        source.sendSuccess(() -> Component.literal("Schematic saved as " + name), false);
        return 1;
    }

    private static int loadSchematic(CommandContext<CommandSourceStack> context) {
        String name = StringArgumentType.getString(context, "name");
        CommandSourceStack source = context.getSource();
        // Logic to load the schematic
        source.sendSuccess(() -> Component.literal("Schematic loaded: " + name), false);
        return 1;
    }

    private static int placeSchematic(CommandContext<CommandSourceStack> context) {
        String name = StringArgumentType.getString(context, "name");
        CommandSourceStack source = context.getSource();
        Level level = source.getLevel();
        BlockPos pos = new BlockPos(source.getPosition());
        // Logic to place the schematic
        source.sendSuccess(() -> Component.literal("Schematic placed: " + name), false);
        return 1;
    }
}