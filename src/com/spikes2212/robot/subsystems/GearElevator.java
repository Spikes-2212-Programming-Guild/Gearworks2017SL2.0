package com.spikes2212.robot.subsystems;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.BasicSubsystem;
import com.spikes2212.genericsubsystems.limitationFunctions.TwoLimits;
import edu.wpi.first.wpilibj.Encoder;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class GearElevator extends BasicSubsystem {

    public static final Supplier<Double> MIDDLE_SET_POINT = ConstantHandler.addConstantDouble(
            "Lift-Middle-Position",
            0
    );



    private Encoder encoder;

    private Supplier<Boolean> maxLimit, minLimit;

    public enum ElevatorState {
         UP(4), MIDDLE_UP(3), MIDDLE(2), MIDDLE_DOWN(1), DOWN(1);

        private int index;
        ElevatorState(int index){
            this.index = index;
        }
        public int getIndex(){
            return index;
        }
    }


    public GearElevator(Consumer<Double> speedConsumer, Supplier<Boolean> maxLimit, Supplier<Boolean> minLimit,
                        Encoder encoder) {
        super(speedConsumer, new TwoLimits(maxLimit, minLimit));
        this.encoder = encoder;
        this.maxLimit = maxLimit;
        this.minLimit = () -> {
            if (minLimit.get()) resetEncoder();
            return minLimit.get();
        };

    }

    public ElevatorState getPosition() {
        if (encoder.get() == MIDDLE_SET_POINT.get())
            return ElevatorState.MIDDLE;
        if (minLimit.get())
            return ElevatorState.DOWN;
        if (maxLimit.get())
            return ElevatorState.UP;
        if (encoder.get() < MIDDLE_SET_POINT.get())
            return ElevatorState.MIDDLE_DOWN;
        return ElevatorState.MIDDLE_UP;
    }

    public void resetEncoder() {
        encoder.reset();
    }
}
