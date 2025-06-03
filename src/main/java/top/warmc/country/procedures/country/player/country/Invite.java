package top.warmc.country.procedures.country.player.country;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import top.warmc.country.core.pool.CountryPool;
import top.warmc.country.network.CountryModNetWork;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

@Mod.EventBusSubscriber(value = Dist.DEDICATED_SERVER)
public class Invite {
    public static boolean Invite(CommandContext<CommandSourceStack> arguments, Player player) {
        if (player == null) return false;

        Entity entity = null;
        try { entity = EntityArgument.getEntity(arguments, "name"); } catch (CommandSyntaxException e) { throw new RuntimeException(e); }
        if (!(entity instanceof Player other_player)) { player.displayClientMessage(Component.literal("§6[Country]§4[error]§c错误:空实体!"), false); return false; }

        if (CountryPool.getCountryFromTown(CountryPool.getTownFromPlayer(player)) == null) { player.displayClientMessage(Component.literal("§6[Country]§3[player]§c您没有建立国家!"), false); return false; }
        if (player.getUUID().equals(other_player.getUUID())) { player.displayClientMessage(Component.literal("§6[Country]§3[player]§c你不能邀请你自己!"), false); return false; }
        if (CountryPool.getCountryFromTown(CountryPool.getTownFromPlayer(other_player)) != null) { player.displayClientMessage(Component.literal("§6[Country]§3[player]§c对方已有所属国!"), false); return false; }


        if ((((new Object() {
            public Entity getEntity() {
                try {
                    return EntityArgument.getEntity(arguments, "name");
                } catch (CommandSyntaxException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }.getEntity()).getCapability(CountryModNetWork.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModNetWork.PlayerVariables())).country_invite_spend_time > 0)) {
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("§6[Country]§3[player]§c对方有未处理的邀请!"), false);
            return InteractionResult.SUCCESS;
        }
        if ((entity.getCapability(CountryModNetWork.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModNetWork.PlayerVariables())).country_invite_cooling > 0) {
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("§6[Country]§3[player]§c邀请冷却中!"), false);
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
            }.getEntity()).getCapability(CountryModNetWork.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
            entity.getCapability(CountryModNetWork.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
            }.getEntity()).getCapability(CountryModNetWork.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
