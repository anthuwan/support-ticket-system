package com.support.ticket.system.model;

import lombok.Getter;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CancelledReason {
    EMPTY(""),
    ENDUSER("Enduser"),
    OTHER("Other");
    @Getter
    private final String columnName;

    CancelledReason(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }

    public static Map<String, CancelledReason> getNameToConditionType() {
        return Stream
                .of(CancelledReason.values())
                .collect(Collectors.toMap(CancelledReason::getColumnName, Function.identity()));
    }
    @Override
    public String toString(){
        return this.columnName;
    }

}
