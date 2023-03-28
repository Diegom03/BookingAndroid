package utils;

import interfaces.IMotorSQL;
import java.sql.ResultSet;

public abstract class MotorSQL implements IMotorSQL {
    @Override
    public abstract void connect();

    @Override
    public abstract int execute(String sql);

    @Override
    public abstract ResultSet executeQuery(String sql);

    @Override
    public abstract void disconnect();
}
