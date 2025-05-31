package top.warmc.country.procedures.player.country;

import top.warmc.country.network.CountryModVariables;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import java.util.List;
import java.util.ArrayList;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class InviteProcedure {
	public static InteractionResult execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return InteractionResult.PASS;
		double number = 0;
		boolean logic = false;
		List<String> player_list = new ArrayList<>();
		if ((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "name");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()) == null) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A74[error]\u00A7c\u9519\u8BEF:\u7A7A\u5B9E\u4F53!"), false);
			return InteractionResult.SUCCESS;
		}
		if ((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "name");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()) == entity) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u4F60\u4E0D\u80FD\u9080\u8BF7\u4F60\u81EA\u5DF1!"), false);
			return InteractionResult.SUCCESS;
		}
		int number_admin = 0;
		boolean logic_admin = false;
		List<String> admin_list = new ArrayList<>();
		logic = false;
		for (int index0 = 0; index0 < (int) CountryModVariables.country_name.size(); index0++) {
			player_list.clear();
			player_list.addAll((List) CountryModVariables.country_admin.get((int) number_admin));
			if (player_list.contains((entity.getStringUUID()))) {
				logic_admin = true;
				break;
			}
			number_admin = number_admin + 1;
		}
		if (!logic_admin) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u60A8\u6CA1\u6709\u5EFA\u7ACB\u56FD\u5BB6!"), false);
			return InteractionResult.SUCCESS;
		}
		number = 0;
		logic = false;
		for (int index0 = 0; index0 < (int) CountryModVariables.country_name.size(); index0++) {
			player_list.clear();
			player_list.addAll((List) CountryModVariables.country_player.get((int) number));
			if (player_list.contains(((new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "name");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getStringUUID()))) {
				logic = true;
				break;
			}
			number = number + 1;
		}
		if (logic) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u5BF9\u65B9\u5DF2\u6709\u6240\u5C5E\u56FD!"), false);
			return InteractionResult.SUCCESS;
		}
		if ((((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "name");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()).getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModVariables.PlayerVariables())).country_invite_spend_time > 0)) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u5BF9\u65B9\u6709\u672A\u5904\u7406\u7684\u9080\u8BF7!"), false);
			return InteractionResult.SUCCESS;
		}
		if ((entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModVariables.PlayerVariables())).country_invite_cooling > 0) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u9080\u8BF7\u51B7\u5374\u4E2D!"), false);
			return InteractionResult.SUCCESS;
		}
		{
			double _setval = 1200;
			(new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "name");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.country_invite_spend_time = _setval;
				capability.syncPlayerVariables((new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "name");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()));
			});
		}
		{
			double _setval = 6000;
			entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.country_invite_cooling = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = entity.getStringUUID();
			(new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "name");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.country_invite_player_uuid = _setval;
				capability.syncPlayerVariables((new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "name");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()));
			});
		}
		if ((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "name");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()) instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u00A78---------\u00A76[Country]\u00A78---------"), false);
		if ((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "name");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()) instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("\u00A72" + entity.getDisplayName().getString() + "\u5411\u60A8\u53D1\u9001\u52A0\u5165\u9080\u8BF7")), false);
		if ((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "name");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()) instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("\u00A72" + entity.getDisplayName().getString() + "\u5411\u60A8\u53D1\u9001\u52A0\u5165\u9080\u8BF7")), false);
		if ((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "name");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()) instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u00A72\u8F93\u5165 \"/country invitations accept\" \u540C\u610F "), false);
		if ((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "name");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()) instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u00A7c\u8F93\u5165 \"/country invitations deny\" \u62D2\u7EDD"), false);
		if ((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "name");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()) instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u00A73\u8BE5\u9080\u8BF7\u5C06\u57281\u5206\u949F\u540E\u88AB\u64A4\u56DE"), false);
		if ((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "name");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()) instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u00A78----------------------------"), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("\u00A76[Country]\u00A72\u5DF2\u5411 " + (new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "name");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getDisplayName().getString() + " \u53D1\u9001\u9080\u8BF7")), false);
		return InteractionResult.SUCCESS;
	}
}
