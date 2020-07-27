package com.support.ticket.system.model;

import lombok.Getter;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Status {
    COMPLETED("Completed"),
    CANCELLED("Cancelled");
    @Getter
    private  String columnName;

    Status(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }

    public static Map<String, Status> getNameToConditionType() {
        return Stream
                .of(Status.values())
                .collect(Collectors.toMap(Status::getColumnName, Function.identity()));
    }

}
