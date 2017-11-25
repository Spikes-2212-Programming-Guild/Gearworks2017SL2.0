package com.spikes2212.robot.subsystems;

import com.spikes2212.genericsubsystems.BasicSubsystem;
import edu.wpi.first.wpilibj.Encoder;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class GearLift extends BasicSubsystem {
    public GearLift(Consumer<Double> speedConsumer,
                    Supplier<Boolean> maxLimit,
                    Supplier<Boolean> minLimit,
                    Encoder liftEncoder) {
        super(speedConsumer, maxLimit, minLimit);
    }
}
