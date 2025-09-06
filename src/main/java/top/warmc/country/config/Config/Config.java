package top.warmc.country.config.Config;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.ArrayList;
import java.util.List;

public class Config {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Boolean> A;
	public static final ForgeConfigSpec.ConfigValue<Boolean> COUNTRY_PROTECTION;
	public static final ForgeConfigSpec.ConfigValue<Double> MAX_CHUCK;
	public static final ForgeConfigSpec.ConfigValue<List<String>> DEL_ENTITY;
	public static final ForgeConfigSpec.ConfigValue<List<String>> CANT_OPEN;
	public static final ForgeConfigSpec.ConfigValue<Boolean> TAKE_OVER_MESSAGE_EVENT;
	public static final ForgeConfigSpec.ConfigValue<String> CHAT_FORMAT;
	public static final ForgeConfigSpec.ConfigValue<Double> WAR_START_MIN_LEVEL;
	public static final ForgeConfigSpec.ConfigValue<Double> MIN_WAR_START_PLAYER_NUMBER;
	static {
		BUILDER.push("main");
		A = BUILDER.comment("a").define("a", false);
		BUILDER.pop();
		BUILDER.push("country");
		COUNTRY_PROTECTION = BUILDER.comment("是否对和平国家的领土保护").define("country_protection", true);
		BUILDER.pop();
		BUILDER.push("chuck");
		MAX_CHUCK = BUILDER.comment("领土最大区块数").define("max_chuck", (double) 0);
		DEL_ENTITY = BUILDER.define("del_entity", new ArrayList<>());
		CANT_OPEN = BUILDER.define("cant_open", new ArrayList<>());
		BUILDER.pop();
		BUILDER.push("level");
		BUILDER.pop();
		BUILDER.push("chat");
		TAKE_OVER_MESSAGE_EVENT = BUILDER.comment("是否接管消息事件").define("Take_over_Message_Event", true);
		CHAT_FORMAT = BUILDER.comment("消息格式 例如%country_disname% %player_name% >> %message% ").define("chat_format", "[%country_disname%] %player% >> %message% ");
		BUILDER.pop();
		BUILDER.push("war");
		WAR_START_MIN_LEVEL = BUILDER.comment("敌方最小开战等级").define("war_start_min_level", (double) 0);
		MIN_WAR_START_PLAYER_NUMBER = BUILDER.comment("敌方最小开战人数").define("war_start_player_number", (double) 0);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
