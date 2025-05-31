package top.warmc.country.procedures.war;

import top.warmc.country.network.CountryModVariables;
import top.warmc.country.CountryMod;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;


import java.util.List;
import java.util.ArrayList;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class FallbackProcedure {
	public static InteractionResult execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return InteractionResult.PASS;

		String other_country_name = StringArgumentType.getString(arguments, "country_name");
		CountryMod.LOGGER.info(other_country_name);
		boolean logic_for_my_country = false;
		int number_for_my_country = 0;
		for (int index0 = 0; index0 < (int) CountryModVariables.country_name.size(); index0++) {
			if ((CountryModVariables.country_owner.get(index0)).equals(entity.getStringUUID())) {
				logic_for_my_country = true;
				number_for_my_country = index0;
				break;
			}
		}
		boolean logic_for_other_country = false;
		int number_for_other_country = 0;
		for (int index1 = 0; index1 < (int) CountryModVariables.country_name.size(); index1++) {
			CountryMod.LOGGER.info(CountryModVariables.country_name.get(index1));
			if (((String) CountryModVariables.country_name.get(index1)).equals(other_country_name)) {
				logic_for_other_country = true;
				number_for_other_country = index1;
				break;
			}
		}

		if (!logic_for_my_country) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u60A8\u6CA1\u6709\u5728\u4EFB\u4F55\u4E00\u4E2A\u56FD\u5BB6!"), false);
			return InteractionResult.PASS;
		}
		if (!logic_for_other_country) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u56FD\u5BB6\u4E0D\u5B58\u5728!"), false);
			return InteractionResult.PASS;
		}
		
		if (number_for_my_country == number_for_other_country) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u60A8\u4E0D\u80FD\u5411\u81EA\u5DF1\u64A4\u9000!"), false);
			return InteractionResult.PASS;
		}
		
		List<List> my_country_war_list = new ArrayList<>();
		my_country_war_list.addAll((List) CountryModVariables.country_war.get((int) number_for_my_country));
		List<String> my_country_war_one_data = new ArrayList<>();
		my_country_war_one_data.add((String) CountryModVariables.country_name.get((int) number_for_other_country));
		my_country_war_one_data.add("attack");

		if (my_country_war_list.isEmpty() && (!((String) CountryModVariables.country_start.get((int) number_for_my_country)).equals("peace"))) {
			CountryModVariables.country_start.set((int) number_for_my_country, "peace");
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u72B6\u6001\u4FE1\u606F\u9519\u8BEF!\u00A7a\u5DF2\u91CD\u7F6E!"), false);
			return InteractionResult.PASS;
		}
		
		if (!my_country_war_list.contains(my_country_war_one_data)) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A7c[war]\u00A7c\u60a8\u672a\u5bf9\u8be5\u56fd\u53d1\u52a8\u6218\u4e89!"), false);
			return InteractionResult.PASS;
		}
		
		List<List> other_country_war_list = new ArrayList<>();
		other_country_war_list.addAll((List) CountryModVariables.country_war.get((int) number_for_other_country));
		List<String> other_country_war_one_data = new ArrayList<>();
		other_country_war_one_data.add((String) CountryModVariables.country_name.get((int) number_for_my_country));
		other_country_war_one_data.add("attacked");

		
		my_country_war_list.remove(my_country_war_one_data);
		other_country_war_list.remove(other_country_war_one_data);
		CountryModVariables.country_war.set((int) number_for_my_country, my_country_war_list);
		CountryModVariables.country_war.set((int) number_for_other_country, other_country_war_list);

		if (my_country_war_list.isEmpty()) {
			CountryModVariables.country_start.set((int) number_for_my_country, "peace");
		}
		if (other_country_war_list.isEmpty()) {
			CountryModVariables.country_start.set((int) number_for_other_country, "peace");
		}

		CountryMod.LOGGER.info(CountryModVariables.country_war);
		
		if (entity instanceof Player _player && !_player.level().isClientSide())
 {
			_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A7c[war]\u00A72\u5df2\u64a4\u9000!"), false);
			return InteractionResult.PASS;
		}
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u00A76[Country]\u00A7c[war]\u00A7e \u00A7" + CountryModVariables.country_color.get((int) number_for_my_country) + CountryModVariables.country_name.get((int) number_for_my_country) + "\u00A7r \u00A75\u5BF9\u00A7e \u00A7" + CountryModVariables.country_color.get((int) number_for_my_country) + CountryModVariables.country_name.get((int) number_for_other_country) + "\u00A7r \u00A75\u64a4\u9000")), false);
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
