package com.lastclick.Comparables;

import com.google.common.collect.ImmutableSet;
import java.util.Set;
import net.runelite.api.ItemID;
import net.runelite.api.MenuEntry;
import net.runelite.api.MenuOpcode;
import com.lastclick.LastClickPlugin;
import org.apache.commons.lang3.tuple.Pair;

public class Farming implements ClickComparable
{
	private static final Set<Integer> HERB_SEEDS = ImmutableSet.of(
		ItemID.GUAM_SEED,
		ItemID.MARRENTILL_SEED,
		ItemID.TARROMIN_SEED,
		ItemID.HARRALANDER_SEED,
		ItemID.RANARR_SEED,
		ItemID.TOADFLAX_SEED,
		ItemID.IRIT_SEED,
		ItemID.AVANTOE_SEED,
		ItemID.KWUARM_SEED,
		ItemID.SNAPDRAGON_SEED,
		ItemID.CADANTINE_SEED,
		ItemID.LANTADYME_SEED,
		ItemID.DWARF_WEED_SEED,
		ItemID.TORSTOL_SEED
	);

	private static final String HERB_PATCH = "<col=ffff>Herb patch";

	@Override
	public boolean isEntryValid(MenuEntry event)
	{
		return event.getOpcode() == MenuOpcode.GAME_OBJECT_SECOND_OPTION.getId() &&
			event.getTarget().equals(HERB_PATCH);
	}

	@Override
	public void modifyEntry(LastClickPlugin plugin, MenuEntry event)
	{
		Pair<Integer, Integer> herb = plugin.findItem(HERB_SEEDS);
		if (herb.getLeft() == -1)
		{
			return;
		}

		event.setOption("Use");

		switch(herb.getLeft())
		{
			case ItemID.GUAM_SEED:
				event.setTarget("<col=ff9040>Guam seed<col=ffffff> -> " + plugin.getTargetMap().get(event.getIdentifier()));
				break;
			case ItemID.MARRENTILL_SEED:
				event.setTarget("<col=ff9040>Marrentill seed<col=ffffff> -> " + plugin.getTargetMap().get(event.getIdentifier()));
				break;
			case ItemID.TARROMIN_SEED:
				event.setTarget("<col=ff9040>Tarromin seed<col=ffffff> -> " + plugin.getTargetMap().get(event.getIdentifier()));
				break;
			case ItemID.HARRALANDER_SEED:
				event.setTarget("<col=ff9040>Harralander seed<col=ffffff> -> " + plugin.getTargetMap().get(event.getIdentifier()));
				break;
			case ItemID.RANARR_SEED:
				event.setTarget("<col=ff9040>Ranarr seed<col=ffffff> -> " + plugin.getTargetMap().get(event.getIdentifier()));
				break;
			case ItemID.TOADFLAX_SEED:
				event.setTarget("<col=ff9040>Toadflax seed<col=ffffff> -> " + plugin.getTargetMap().get(event.getIdentifier()));
				break;
			case ItemID.IRIT_SEED:
				event.setTarget("<col=ff9040>Irit seed<col=ffffff> -> " + plugin.getTargetMap().get(event.getIdentifier()));
				break;
			case ItemID.AVANTOE_SEED:
				event.setTarget("<col=ff9040>Avantoe seed<col=ffffff> -> " + plugin.getTargetMap().get(event.getIdentifier()));
				break;
			case ItemID.KWUARM_SEED:
				event.setTarget("<col=ff9040>Kwuarm seed<col=ffffff> -> " + plugin.getTargetMap().get(event.getIdentifier()));
				break;
			case ItemID.SNAPDRAGON_SEED:
				event.setTarget("<col=ff9040>Snapdragon seed<col=ffffff> -> " + plugin.getTargetMap().get(event.getIdentifier()));
				break;
			case ItemID.CADANTINE_SEED:
				event.setTarget("<col=ff9040>Cadantine seed<col=ffffff> -> " + plugin.getTargetMap().get(event.getIdentifier()));
				break;
			case ItemID.LANTADYME_SEED:
				event.setTarget("<col=ff9040>Lantadyme seed<col=ffffff> -> " + plugin.getTargetMap().get(event.getIdentifier()));
				break;
			case ItemID.DWARF_WEED_SEED:
				event.setTarget("<col=ff9040>Dwarf weed seed<col=ffffff> -> " + plugin.getTargetMap().get(event.getIdentifier()));
				break;
			case ItemID.TORSTOL_SEED:
				event.setTarget("<col=ff9040>Torstol seed<col=ffffff> -> " + plugin.getTargetMap().get(event.getIdentifier()));
				break;
			default:
				event.setTarget("<col=ff9040>Herb seed<col=ffffff> -> " + plugin.getTargetMap().get(event.getIdentifier()));
				break;
		}

		event.setOpcode(MenuOpcode.ITEM_USE_ON_GAME_OBJECT.getId());
		event.setForceLeftClick(true);
	}

	@Override
	public boolean isClickValid(MenuEntry event)
	{
		return event.getOpcode() == MenuOpcode.ITEM_USE_ON_GAME_OBJECT.getId() &&
			event.getTarget().contains("seed<col=ffffff> -> ");
	}

	@Override
	public void modifyClick(LastClickPlugin plugin, MenuEntry event)
	{
		plugin.updateSelectedItem(HERB_SEEDS);
	}
}
