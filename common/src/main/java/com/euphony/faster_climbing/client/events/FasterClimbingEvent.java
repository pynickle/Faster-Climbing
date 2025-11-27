package com.euphony.faster_climbing.client.events;

import com.euphony.faster_climbing.config.FasterClimbingConfig;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class FasterClimbingEvent {

    public static void playerPre(Player player) {
        if(!player.level().isClientSide()) return;

        if (player.onClimbable()) {
            Climber climber = new Climber(player);

            if ((!player.isCrouching() && !player.getInBlockState().is(Blocks.SCAFFOLDING)) || player.getInBlockState().is(Blocks.SCAFFOLDING)) {
                if (FasterClimbingConfig.HANDLER.instance().enableFasterDownward && climber.isFacingDownward()
                        && !climber.isMovingForward() && !climber.isMovingBackward()) {
                    climber.moveDownFaster();
                } else if (FasterClimbingConfig.HANDLER.instance().enableFasterUpward && climber.isFacingUpward()
                        && (climber.isMovingForward() || player.isJumping())) {
                    climber.moveUpFaster();
                }
            }
        }
    }

    private record Climber(Player player) {
        private boolean isFacingDownward() {
                return player.getXRot() > 0;
            }

            private boolean isFacingUpward() {
                return player.getXRot() < 0;
            }

            private boolean isMovingForward() {
                return player.zza > 0;
            }

            private boolean isMovingBackward() {
                return player.zza < 0;
            }

            private float getSpeed() {
                return (float) (Math.sin(Math.abs(player.getXRot() * Math.PI / 180F)) * FasterClimbingConfig.HANDLER.instance().speedMultiplier / 10);
            }

            public void moveUpFaster() {
                float dy = getSpeed();
                Vec3 move = new Vec3(0, dy, 0);
                player.move(MoverType.SELF, move);
            }

            public void moveDownFaster() {
                float dy = - getSpeed();
                Vec3 move = new Vec3(0, dy, 0);
                player.move(MoverType.SELF, move);
            }
        }
}
