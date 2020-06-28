package com.lastclick.Comparables;

import com.lastclick.LastClickPlugin;
import net.runelite.api.MenuEntry;

public interface ClickComparable
{
	boolean isEntryValid(MenuEntry event);

	void modifyEntry(LastClickPlugin plugin, MenuEntry event);

	boolean isClickValid(MenuEntry event);

	void modifyClick(LastClickPlugin plugin, MenuEntry event);
}
