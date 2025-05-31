package top.warmc.country.network;

import top.warmc.country.CountryMod;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;
import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CountryModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		CountryMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.kick_countdown = original.kick_countdown;
			clone.disband_tick = original.disband_tick;
			clone.spawn_particle_tick = original.spawn_particle_tick;
			clone.spawn_laster_pos_x = original.spawn_laster_pos_x;
			clone.spawn_laster_pos_y = original.spawn_laster_pos_y;
			clone.spawn_laster_pos_z = original.spawn_laster_pos_z;
			clone.surrender_tick = original.surrender_tick;
			clone.country_invite_spend_time = original.country_invite_spend_time;
			clone.country_invite_cooling = original.country_invite_cooling;
			clone.country_invite_player_uuid = original.country_invite_player_uuid;
			clone.auto_add_chuck = original.auto_add_chuck;
			if (!event.isWasDeath()) {
				clone.war_chuck_occupied = original.war_chuck_occupied;
				clone.war_chuck_occupied_time = original.war_chuck_occupied_time;
				clone.war_chuck_occupied_my_country = original.war_chuck_occupied_my_country;
				clone.war_chuck_occupied_other_country = original.war_chuck_occupied_other_country;
				clone.auto_add_chuck_old_pos = original.auto_add_chuck_old_pos;
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("country", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double kick_countdown = 0;
		public double disband_tick = 0;
		public double spawn_particle_tick = 0;
		public double spawn_laster_pos_x = 0;
		public double spawn_laster_pos_y = 0;
		public double spawn_laster_pos_z = 0;
		public String war_chuck_occupied = "\"\"";
		public double war_chuck_occupied_time = 0;
		public double war_chuck_occupied_my_country = 0;
		public double war_chuck_occupied_other_country = 0;
		public double surrender_tick = 0;
		public double country_invite_spend_time = 0;
		public double country_invite_cooling = 0;
		public String country_invite_player_uuid = "\"\"";
		public boolean auto_add_chuck = false;
		public String auto_add_chuck_old_pos = "\"\"";

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				CountryMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("kick_countdown", kick_countdown);
			nbt.putDouble("disband_tick", disband_tick);
			nbt.putDouble("spawn_particle_tick", spawn_particle_tick);
			nbt.putDouble("spawn_laster_pos_x", spawn_laster_pos_x);
			nbt.putDouble("spawn_laster_pos_y", spawn_laster_pos_y);
			nbt.putDouble("spawn_laster_pos_z", spawn_laster_pos_z);
			nbt.putString("war_chuck_occupied", war_chuck_occupied);
			nbt.putDouble("war_chuck_occupied_time", war_chuck_occupied_time);
			nbt.putDouble("war_chuck_occupied_my_country", war_chuck_occupied_my_country);
			nbt.putDouble("war_chuck_occupied_other_country", war_chuck_occupied_other_country);
			nbt.putDouble("surrender_tick", surrender_tick);
			nbt.putDouble("country_invite_spend_time", country_invite_spend_time);
			nbt.putDouble("country_invite_cooling", country_invite_cooling);
			nbt.putString("country_invite_player_uuid", country_invite_player_uuid);
			nbt.putBoolean("auto_add_chuck", auto_add_chuck);
			nbt.putString("auto_add_chuck_old_pos", auto_add_chuck_old_pos);
			return nbt;
		}

		public void readNBT(Tag tag) {
			CompoundTag nbt = (CompoundTag) tag;
			kick_countdown = nbt.getDouble("kick_countdown");
			disband_tick = nbt.getDouble("disband_tick");
			spawn_particle_tick = nbt.getDouble("spawn_particle_tick");
			spawn_laster_pos_x = nbt.getDouble("spawn_laster_pos_x");
			spawn_laster_pos_y = nbt.getDouble("spawn_laster_pos_y");
			spawn_laster_pos_z = nbt.getDouble("spawn_laster_pos_z");
			war_chuck_occupied = nbt.getString("war_chuck_occupied");
			war_chuck_occupied_time = nbt.getDouble("war_chuck_occupied_time");
			war_chuck_occupied_my_country = nbt.getDouble("war_chuck_occupied_my_country");
			war_chuck_occupied_other_country = nbt.getDouble("war_chuck_occupied_other_country");
			surrender_tick = nbt.getDouble("surrender_tick");
			country_invite_spend_time = nbt.getDouble("country_invite_spend_time");
			country_invite_cooling = nbt.getDouble("country_invite_cooling");
			country_invite_player_uuid = nbt.getString("country_invite_player_uuid");
			auto_add_chuck = nbt.getBoolean("auto_add_chuck");
			auto_add_chuck_old_pos = nbt.getString("auto_add_chuck_old_pos");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.kick_countdown = message.data.kick_countdown;
					variables.disband_tick = message.data.disband_tick;
					variables.spawn_particle_tick = message.data.spawn_particle_tick;
					variables.spawn_laster_pos_x = message.data.spawn_laster_pos_x;
					variables.spawn_laster_pos_y = message.data.spawn_laster_pos_y;
					variables.spawn_laster_pos_z = message.data.spawn_laster_pos_z;
					variables.war_chuck_occupied = message.data.war_chuck_occupied;
					variables.war_chuck_occupied_time = message.data.war_chuck_occupied_time;
					variables.war_chuck_occupied_my_country = message.data.war_chuck_occupied_my_country;
					variables.war_chuck_occupied_other_country = message.data.war_chuck_occupied_other_country;
					variables.surrender_tick = message.data.surrender_tick;
					variables.country_invite_spend_time = message.data.country_invite_spend_time;
					variables.country_invite_cooling = message.data.country_invite_cooling;
					variables.country_invite_player_uuid = message.data.country_invite_player_uuid;
					variables.auto_add_chuck = message.data.auto_add_chuck;
					variables.auto_add_chuck_old_pos = message.data.auto_add_chuck_old_pos;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
