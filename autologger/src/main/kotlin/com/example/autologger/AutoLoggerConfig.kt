package com.example.autologger

import net.runelite.client.config.Config
import net.runelite.client.config.ConfigGroup
import net.runelite.client.config.ConfigItem

@ConfigGroup("AutoLoggerConfig")
interface AutoLoggerConfig : Config {
    @ConfigItem(
            keyName = "SimpleSwitch",
            name = "Example config item",
            description = "Example",
            position = 0
    )
    @JvmDefault
    fun example(): Boolean {
        return true
    }
}