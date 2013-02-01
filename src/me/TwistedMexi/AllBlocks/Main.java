package me.TwistedMexi.AllBlocks;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin implements Listener{


	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		this.getConfig().addDefault("CrackedStoneBrick", true);
		this.getConfig().addDefault("CircleStone", true);
		this.getConfig().addDefault("Glowstone", true);
		this.getConfig().addDefault("MossyStoneBrick", true);
		this.getConfig().addDefault("SmoothSlab", true);
		this.getConfig().addDefault("Heads", true);
		this.getConfig().addDefault("ReturnToSkull", true);
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		AddRecipes();
	}
	
	
	public void AddRecipes()
	{
		if (getConfig().getBoolean("CrackedStoneBrick")) {
		      ShapedRecipe CSB = new ShapedRecipe(new ItemStack(Material.SMOOTH_BRICK, 2, (byte)2));
		      CSB.shape("ss", "ss");
		      CSB.setIngredient('s', Material.SMOOTH_BRICK);
		      getServer().addRecipe(CSB);
		      
		      if (getConfig().getBoolean("CircleStone"))
		      {
			      ShapedRecipe CS = new ShapedRecipe(new ItemStack(Material.SMOOTH_BRICK, 2, (byte)3));
			      CS.shape("ss", "ss");
			      CS.setIngredient('s', Material.SMOOTH_BRICK, (byte)2);
			      getServer().addRecipe(CS);
		      }
		    }
		if (getConfig().getBoolean("Glowstone")) {
			      ShapedRecipe GS = new ShapedRecipe(new ItemStack(Material.GLOWSTONE, 2));
			      GS.shape("ggg", "gsg", "ggg");
			      GS.setIngredient('s', Material.SOUL_SAND);
			      GS.setIngredient('g', Material.GOLD_NUGGET);
			      getServer().addRecipe(GS);
		}
		if (getConfig().getBoolean("SmoothSlab")) {
	      ShapedRecipe SS1 = new ShapedRecipe(new ItemStack(Material.DOUBLE_STEP, 1,(byte)7));
	      SS1.shape("s", "s");
	      SS1.setIngredient('s', Material.STEP);
	      getServer().addRecipe(SS1);
	      ShapedRecipe SS2 = new ShapedRecipe(new ItemStack(Material.DOUBLE_STEP, 1,(byte)7));
	      SS2.shape("s", "s");
	      SS2.setIngredient('s', Material.STEP,(byte)7);
	      getServer().addRecipe(SS2);
		}
		if (getConfig().getBoolean("Heads")) {
			      ShapedRecipe SH = new ShapedRecipe(new ItemStack(Material.SKULL_ITEM, 1));
			      SH.shape("bbb", "bsb", "bbb");
			      SH.setIngredient('b', Material.INK_SACK, (byte)15);
			      SH.setIngredient('s', Material.SKULL_ITEM, (byte)1);
			      getServer().addRecipe(SH);
			      
			      ShapedRecipe ZH = new ShapedRecipe(new ItemStack(Material.SKULL_ITEM, 1, (byte)2));
			      ZH.shape("fff", "fsf", "fff");
			      ZH.setIngredient('f', Material.ROTTEN_FLESH);
			      ZH.setIngredient('s', Material.SKULL_ITEM, (byte)1);
			      getServer().addRecipe(ZH);
			      
			      ShapedRecipe HH = new ShapedRecipe(new ItemStack(Material.SKULL_ITEM, 1, (byte)3));
			      HH.shape("fff", "fsf", "fff");
			      HH.setIngredient('f', Material.CLAY_BALL);
			      HH.setIngredient('s', Material.SKULL_ITEM, (byte)1);
			      getServer().addRecipe(HH);
			      
			      ShapedRecipe CH = new ShapedRecipe(new ItemStack(Material.SKULL_ITEM, 1, (byte)4));
			      CH.shape("fff", "fsf", "fff");
			      CH.setIngredient('f', Material.SULPHUR);
			      CH.setIngredient('s', Material.SKULL_ITEM, (byte)1);
			      getServer().addRecipe(CH);
			      
				if (getConfig().getBoolean("ReturnToSkull")) {
				getServer().addRecipe(new FurnaceRecipe(new ItemStack(Material.SKULL_ITEM, 1,(byte)1), Material.SKULL_ITEM));
				}
		}
		if (getConfig().getBoolean("MossyStoneBrick"))
		getServer().addRecipe(new FurnaceRecipe(new ItemStack(Material.SMOOTH_BRICK, 1,(byte)1), Material.MOSSY_COBBLESTONE));
	}
		
/* //No longer needed as Netherbrick has a legitimate recipe soon.
		if (getConfig().getBoolean("Netherbrick"))
		getServer().addRecipe(new FurnaceRecipe(new ItemStack(Material.NETHER_BRICK), Material.NETHERRACK));
	}
	
	@EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
public void eventFurnaceSmelt(FurnaceSmeltEvent ev)
{
		if (ev.getResult().getTypeId() == 112)
{
	Furnace f = (Furnace) ev.getBlock().getState();
	f.setBurnTime((short)(f.getBurnTime() - 600));
}
}
*/
	
	@EventHandler
	public void updateinv(CraftItemEvent ev)
	{
		final Player p = (Player) ev.getWhoClicked();
		if(p != null)
		{
		//temp bugfix for Bukkit with shift clicking and returned items
		Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable()
		{
		@SuppressWarnings("deprecation")
		@Override
		public void run()
		{
		p.updateInventory();
		}
		});
		}
	}
	
}
