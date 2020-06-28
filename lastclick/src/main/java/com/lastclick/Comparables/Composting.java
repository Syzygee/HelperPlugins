package com.lastclick.Comparables;

import com.google.common.collect.ImmutableSet;
import java.util.Set;
import net.runelite.api.ItemID;
import net.runelite.api.MenuEntry;
import net.runelite.api.MenuOpcode;
import com.lastclick.LastClickPlugin;
import org.apache.commons.lang3.tuple.Pair;

public class Composting implements ClickComparable
{
	private static final Set<Integer> COMPOSTS = ImmutableSet.of(
		ItemID.BOTTOMLESS_COMPOST_BUCKET_22997,
		ItemID.SUPERCOMPOST,
		ItemID.ULTRACOMPOST,
		ItemID.COMPOST
	);

	private static final Set<String> PLANTED_THINGS = ImmutableSet.of(
		"<col=ffff>Herbs",
		"<col=ffff>Watermelon seed",
		"<col=ffff>Snape grass seed"
	);

	@Override
	public boolean isEntryValid(MenuEntry event)
	{
		return event.getOpcode() == MenuOpcode.GAME_OBJECT_SECOND_OPTION.getId() &&
			PLANTED_THINGS.contains(event.getTarget());
	}

	@Override
	public void modifyEntry(LastClickPlugin plugin, MenuEntry event)
	{
		Pair<Integer, Integer> compost = plugin.findItem(COMPOSTS);
		if (compost.getLeft() == -1)
		{
			return;
		}

		event.setOption("Use");
		switch(compost.getLeft())
		{
			case ItemID.BOTTOMLESS_COMPOST_BUCKET_22997:
				event.setTarget("<col=ff9040>Bottomless compost bucket<col=ffffff> -> " + plugin.getTargetMap().get(event.getIdentifier()));
				break;
			case ItemID.ULTRACOMPOST:
				event.setTarget("<col=ff9040>Ultracompost<col=ffffff> -> " + plugin.getTargetMap().get(event.getIdentifier()));
				break;
			case ItemID.SUPERCOMPOST:
				event.setTarget("<col=ff9040>Supercompost<col=ffffff> -> " + plugin.getTargetMap().get(event.getIdentifier()));
				break;
			default:
				event.setTarget("<col=ff9040>Compost<col=ffffff> -> " + plugin.getTargetMap().get(event.getIdentifier()));
				break;
		}

		event.setOpcode(MenuOpcode.ITEM_USE_ON_GAME_OBJECT.getId());
		event.setForceLeftClick(true);
	}

	@Override
	public boolean isClickValid(MenuEntry event)
	{
		return event.getOpcode() == MenuOpcode.ITEM_USE_ON_GAME_OBJECT.getId() &&
			event.getTarget().contains("ompost");
	}

	@Override
	public void modifyClick(LastClickPlugin plugin, MenuEntry event)
	{
		plugin.updateSelectedItem(COMPOSTS);
	}
}
