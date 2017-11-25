package com.spikes2212.robot.subsystems;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.BasicSubsystem;
import com.spikes2212.genericsubsystems.limitationFunctions.TwoLimits;
import edu.wpi.first.wpilibj.Encoder;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class GearLift extends BasicSubsystem {

    public static final Supplier<Double> middlePositionValue = ConstantHandler.addConstantDouble(
            "Gear Lift Middle Position Value",
            0
    );

    public enum LiftPosition {
         UP(4), DOWN(0), MIDDLE(2), MIDDLE_DOWN(1), MIDDLE_UP(3);

        public int index;
        LiftPosition(int index){
            this.index = index;
        }
    }

    private Encoder liftEncoder;

    private Supplier<Boolean> maxLimit, minLimit;


    public GearLift(Consumer<Double> speedConsumer,
                    Supplier<Boolean> maxLimit,
                    Supplier<Boolean> minLimit,
                    Encoder liftEncoder) {
        super(speedConsumer, new TwoLimits(maxLimit, minLimit));
        this.liftEncoder = liftEncoder;
        this.maxLimit = maxLimit;
        this.minLimit = () -> {
            if (minLimit.get()){
                resetEncoder();
                return true;
            }
            return false;
        };

    }

    public LiftPosition getPosition() {
        if (liftEncoder.get() == middlePositionValue.get())
            return LiftPosition.MIDDLE;
        if (minLimit.get())
            return LiftPosition.DOWN;
        if (maxLimit.get())
            return LiftPosition.UP;
        if (liftEncoder.get() < middlePositionValue.get())
            return LiftPosition.MIDDLE_DOWN;
        return LiftPosition.MIDDLE_UP;
    }

    public void resetEncoder() {
        liftEncoder.reset();
    }
}
