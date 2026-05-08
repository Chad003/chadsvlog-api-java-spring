package com.cms.chadsvlog.constants;

import lombok.Getter;

public interface Constants {
    @Getter
    enum ERROR_CODE{
        SUCCESS(0, "success"),
        FAILED(-1, "failed"),
        ;

        final Integer code;
        final String message;
        ERROR_CODE(Integer code, String message){
            this.code = code;
            this.message = message;
        }
    }


}
