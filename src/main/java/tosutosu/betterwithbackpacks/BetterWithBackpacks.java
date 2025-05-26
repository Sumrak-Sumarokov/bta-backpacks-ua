package tosutosu.betterwithbackpacks;

import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.item.model.ItemModel;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelStandard;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.util.collection.NamespaceID;
import turniplabs.halplibe.helper.ModelHelper;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.ModelEntrypoint;

import java.util.Properties;

public class BetterWithBackpacks implements ModelEntrypoint {
    public static final String MOD_ID = "betterwithbackpacks";
    public static int GUI_LABEL_COLOR = 0x404040;
    public static int GUI_BACKPACK_ID;
    public static boolean ENABLE_BACKPACKS;
    public static int itemID;

    static {
        final Properties prop = new Properties();
        prop.setProperty("starting_item_id","21370");
        prop.setProperty("gui_backpack_id","10");
        prop.setProperty("enable_backpacks", "true");
        final ConfigHandler config = new ConfigHandler(MOD_ID, prop);
        itemID = config.getInt("starting_item_id");

        config.updateConfig();
        ENABLE_BACKPACKS = config.getBoolean("enable_backpacks");
        GUI_BACKPACK_ID = config.getInt("gui_backpack_id");
    }

    @Override
    public void initBlockModels(BlockModelDispatcher dispatcher) {}

    @Override
    public void initItemModels(ItemModelDispatcher dispatcher) {
        // fuck you halplibe <3
        ModelHelper.setItemModel(ModItems.leatherBackpack, () -> {
            ItemModelStandard model = new ItemModelStandard(ModItems.leatherBackpack, MOD_ID);
            model.icon = TextureRegistry.getTexture(NamespaceID.getPermanent(MOD_ID, "item/leather_backpack"));
            return model;
        });
        ModelHelper.setItemModel(ModItems.goldBackpack, () -> {
            ItemModelStandard model = new ItemModelStandard(ModItems.goldBackpack, MOD_ID);
            model.icon = TextureRegistry.getTexture(NamespaceID.getPermanent(MOD_ID, "item/gold_backpack"));
            return model;
        });
        ModelHelper.setItemModel(ModItems.ironBackpack, () -> {
            ItemModelStandard model = new ItemModelStandard(ModItems.ironBackpack, MOD_ID);
            model.icon = TextureRegistry.getTexture(NamespaceID.getPermanent(MOD_ID, "item/iron_backpack"));
            return model;
        });
        ModelHelper.setItemModel(ModItems.diamondBackpack, () -> {
            ItemModelStandard model = new ItemModelStandard(ModItems.diamondBackpack, MOD_ID);
            model.icon = TextureRegistry.getTexture(NamespaceID.getPermanent(MOD_ID, "item/diamond_backpack"));
            return model;
        });
    }

    @Override
    public void initEntityModels(EntityRenderDispatcher dispatcher) {}

    @Override
    public void initTileEntityModels(TileEntityRenderDispatcher dispatcher) {}

    @Override
    public void initBlockColors(BlockColorDispatcher dispatcher) {}
}
