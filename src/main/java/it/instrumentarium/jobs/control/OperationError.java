package it.instrumentarium.jobs.control;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class OperationError {
    private final String msg;
}
