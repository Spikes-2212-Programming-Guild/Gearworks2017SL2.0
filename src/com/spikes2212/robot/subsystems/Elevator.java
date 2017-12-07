package com.spikes2212.robot.subsystems;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.BasicSubsystem;
import com.spikes2212.genericsubsystems.limitationFunctions.TwoLimits;
import edu.wpi.first.wpilibj.Encoder;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Elevator extends BasicSubsystem {

    public static final Supplier<Double> SPEED = ConstantHandler.addConstantDouble("Elevator-Speed", 0.2);
    public static final Supplier<Integer> MIDDLE_SET_POINT = ConstantHandler.addConstantInt(
            "Elevator-Middle-Set-Point", 50
    );

    public static final Supplier<Integer> HIGH_SET_POINT = ConstantHandler.addConstantInt(
            "Elevator-High-Set-Point", 100
    );



    private Encoder encoder;

    private Supplier<Boolean> maxLimit, minLimit;

    public enum ElevatorState {
         DOWN(0), MIDDLE_DOWN(1), MIDDLE(2), MIDDLE_UP(3), UP(4);

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

    public ElevatorState getState() {
        // the system is at its middle position (given by the encoder)
        if (encoder.get() == MIDDLE_SET_POINT.get())
            return ElevatorState.MIDDLE;
        // the system is at its lowest position
        if (minLimit.get())
            return ElevatorState.DOWN;
        // the system is at its highest position
        if (encoder.get() == HIGH_SET_POINT.get())
            return ElevatorState.UP;
        // the system is below the middle and above the down position
        if (encoder.get() < MIDDLE_SET_POINT.get())
            return ElevatorState.MIDDLE_DOWN;
        // the system is above the middle and below the up position (default option)
        return ElevatorState.MIDDLE_UP;
    }

    public void resetEncoder() {
        encoder.reset();
    }
}
