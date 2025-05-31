package top.warmc.country.procedures.war;

import top.warmc.country.network.CountryModVariables;
import top.warmc.country.config.ConfigConfiguration;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;

import java.util.List;
import java.util.ArrayList;

import com.mojang.util.UUIDTypeAdapter;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class LaunchProcedure {
	public static InteractionResult execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return InteractionResult.PASS;
		boolean logic_for_my_country = false;
		boolean logic_for_other_country = false;
		List<String> other_country_player_list = new ArrayList<>();
		double player_number = 0;
		double number_for_my_country = 0;
		double number_for_other_country = 0;
		double number_for_other_country_online_player = 0;
		double number_for_other_country_player_list = 0;
		number_for_my_country = 0;
		logic_for_my_country = false;
		for (int index0 = 0; index0 < (int) CountryModVariables.country_name.size(); index0++) {
			if ((CountryModVariables.country_owner.get((int) number_for_my_country)).equals(entity.getStringUUID())) {
				logic_for_my_country = true;
				break;
			}
			number_for_my_country = number_for_my_country + 1;
		}
		if (!logic_for_my_country) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u60A8\u6CA1\u6709\u5EFA\u7ACB\u56FD\u5BB6!"), false);
			return InteractionResult.PASS;
		}
		number_for_other_country = 0;
		logic_for_other_country = false;
		for (int index1 = 0; index1 < (int) CountryModVariables.country_name.size(); index1++) {
			if ((CountryModVariables.country_name.get((int) number_for_other_country)).equals(StringArgumentType.getString(arguments, "country_name"))) {
				logic_for_other_country = true;
				break;
			}
			number_for_other_country = number_for_other_country + 1;
		}

		List<List> my_country_war_list_old = new ArrayList<>();
		my_country_war_list_old.addAll((List) CountryModVariables.country_war.get((int) number_for_my_country));
		List<String> my_country_war_one_data_new = new ArrayList<>();
		my_country_war_one_data_new.add((String) CountryModVariables.country_name.get((int) number_for_other_country));
		my_country_war_one_data_new.add("attack");

		if (my_country_war_list_old.contains(my_country_war_one_data_new)) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A7c[war]\u00A7c\u60a8\u5df2\u5bf9\u8be5\u56fd\u53d1\u52a8\u6218\u4e89!"), false);
			return InteractionResult.PASS;
		}
		
		if (!logic_for_other_country) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u672A\u77E5\u7684\u56FD\u5BB6!"), false);
			return InteractionResult.PASS;
		}
		if (number_for_my_country == number_for_other_country) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A7c[war]\u00A7c\u60a8\u4e0d\u80fd\u81ea\u5df1\u6253\u81ea\u5df1!"), false);
			return InteractionResult.PASS;
		}

		if ((int) CountryModVariables.country_level.get((int) number_for_other_country) < (int) ((double) ConfigConfiguration.WAR_START_MIN_LEVEL.get())) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A75[level]\u00A7c\u5BF9\u65B9\u7B49\u7EA7\u4E0D\u8DB3!"), false);
			return InteractionResult.PASS;
		}
		if ((int) CountryModVariables.country_level.get((int) number_for_my_country) > (int) CountryModVariables.country_level.get((int) number_for_other_country)) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A75[level]\u00A7c\u60A8\u4E0D\u80FD\u653B\u6253\u7B49\u7EA7\u4F4E\u4E8E\u60A8\u7684\u56FD\u5BB6!"), false);
			return InteractionResult.PASS;
		}
		if (false) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A7c[war]\u00A7c\u60A8\u5DF2\u53D1\u8D77\u4E86\u6218\u4E89!"), false);
			return InteractionResult.PASS;
		}
		number_for_other_country_online_player = 0;
		number_for_other_country_player_list = 0;
		other_country_player_list.addAll((List) CountryModVariables.country_player.get((int) number_for_other_country));
		for (int index2 = 0; index2 < (int) other_country_player_list.size(); index2++) {
			if (!(new Object() {
				Entity getEntity(String uuid) {
					Entity _uuidentity = null;
					if (world instanceof ServerLevel _server) {
						try {
							_uuidentity = _server.getEntity(UUIDTypeAdapter.fromString(uuid));
						} catch (IllegalArgumentException e) {
						}
					}
					return _uuidentity;
				}
			}.getEntity(other_country_player_list.get((int) number_for_other_country_player_list)) == null)) {
				number_for_other_country_online_player = number_for_other_country_online_player + 1;
			}
			number_for_other_country_player_list = number_for_other_country_player_list + 1;
		}
		if ((double) number_for_other_country_online_player < (double) ConfigConfiguration.MIN_WAR_START_PLAYER_NUMBER.get()) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u5BF9\u65B9\u4EBA\u6570\u4E0D\u8DB3!"), false);
			return InteractionResult.PASS;
		}
		List<String> war_to_other_country = new ArrayList<>();
		war_to_other_country.add((String) CountryModVariables.country_name.get((int) number_for_other_country));
		war_to_other_country.add("attack");
		List<String> war_to_my_country = new ArrayList<>();
		war_to_my_country.add((String) CountryModVariables.country_name.get((int) number_for_my_country));
		war_to_my_country.add("attacked");
		CountryModVariables.country_start.set((int) number_for_my_country, "war");
		CountryModVariables.country_start.set((int) number_for_other_country, "war");
		List<List> war_my_country_old_list = new ArrayList<>();
		war_my_country_old_list.addAll((List) CountryModVariables.country_war.get((int) number_for_my_country));
		war_my_country_old_list.add(war_to_other_country);
		List<List> war_other_country_old_list = new ArrayList<>();
		war_other_country_old_list.addAll((List) CountryModVariables.country_war.get((int) number_for_other_country));
		war_other_country_old_list.add(war_to_my_country);
		CountryModVariables.country_war.set((int) number_for_my_country, war_my_country_old_list);
		CountryModVariables.country_war.set((int) number_for_other_country, war_other_country_old_list);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A7c[war]\u00A74\u53D1\u52A8\u6210\u529F!"), false);
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u00A76[Country]\u00A7c[war]\u00A7e \u00A7" + CountryModVariables.country_color.get((int) number_for_my_country) + CountryModVariables.country_name.get((int) number_for_my_country) + "\u00A7r \u00A75\u5BF9\u00A7e \u00A7"
					+ CountryModVariables.country_color.get((int) number_for_my_country) + CountryModVariables.country_name.get((int) number_for_other_country) + "\u00A7r \u00A75\u53D1\u52A8\u4E86\u6218\u4E89")), false);
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.experience_orb.pickup")), SoundSource.PLAYERS, 1,
							1);
				} else {
					_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.experience_orb.pickup")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
		}
		return InteractionResult.SUCCESS;
	}
}
