package net.heyzeer0.mgh.hacks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Frani on 18/10/2017.
 */
public interface IBlockEvent {

    ITileEntityOwnable getTile();
    void setTile(TileEntity tile);
    EntityPlayer getOwner();
    void setOwner(EntityPlayer player);

}
