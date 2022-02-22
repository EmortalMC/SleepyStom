package dev.emortal.sleepystom.game.editor;

import dev.emortal.sleepystom.model.config.map.MapGenerator;
import net.kyori.adventure.text.Component;
import net.minestom.server.entity.Player;
import net.minestom.server.event.EventFilter;
import net.minestom.server.event.EventNode;
import net.minestom.server.event.trait.InventoryEvent;
import net.minestom.server.event.trait.PlayerEvent;
import net.minestom.server.inventory.Inventory;
import net.minestom.server.inventory.InventoryType;
import net.minestom.server.item.ItemStack;
import net.minestom.server.item.Material;
import org.jetbrains.annotations.NotNull;

public class EditGeneratorInventory extends Inventory {
    private final @NotNull MapGenerator generator;
    private final @NotNull EventNode<PlayerEvent> eventNode;

    public EditGeneratorInventory(EventNode<PlayerEvent> eventNode, @NotNull MapGenerator generator) {
        super(InventoryType.CHEST_1_ROW, Component.text("Create Generator"));
        this.generator = generator;
        this.eventNode = eventNode
            .addChild(EventNode.value("edit-generator", EventFilter.PLAYER, player -> true));

        Material currentMaterial = this.generator.getMaterial();
        this.setItemStack(0,
            ItemStack.builder(Material.BEDROCK)
                .displayName(Component.text("Generated Material"))
                .lore(Component.text("Current Material: " + (currentMaterial == Material.AIR ? "None" : currentMaterial.name())))
                .build()
        );
    }

    public void show(Player player) {
        player.openInventory(this);
    }

    private void startListeners() {

    }
}