package com.spikes2212.robot.subsystems;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.BasicSubsystem;
import com.spikes2212.genericsubsystems.limitationFunctions.TwoLimits;
import edu.wpi.first.wpilibj.Encoder;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Elevator extends BasicSubsystem {

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


    public Elevator(Consumer<Double> speedConsumer, Supplier<Boolean> maxLimit, Supplier<Boolean> minLimit,
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
        // the value of the encoder is the given middle value
        if (encoder.get() == MIDDLE_SET_POINT.get())
            return ElevatorState.MIDDLE;
        // the system is on its lower limit
        if (minLimit.get())
            return ElevatorState.DOWN;
        // the system is on its higher limit
        if (maxLimit.get())
            return ElevatorState.UP;
        //  the system is not touching any limits, and encoder value is less than middle
        if (encoder.get() < MIDDLE_SET_POINT.get())
            return ElevatorState.MIDDLE_DOWN;
        // the system is not touching any limits, and encoder value is more than middle (default option)
        return ElevatorState.MIDDLE_UP;
    }

    public void resetEncoder() {
        encoder.reset();
    }
}
