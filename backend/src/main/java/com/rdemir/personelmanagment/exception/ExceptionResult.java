package com.rdemir.personelmanagment.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResult {

    private int resultCode;

    private String resultMessage;

    private String resultMessageDetail;
}
