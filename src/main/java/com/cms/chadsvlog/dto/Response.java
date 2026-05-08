package com.cms.chadsvlog.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.cms.chadsvlog.constants.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {
    protected Integer code;
    protected String message;
    protected T data;

    @Setter
    protected String traceId;

    protected Response(){}
    public static ResponseBuilder custom(Constants.ERROR_CODE errorCode){
        return new ResponseBuilder().buildCustom(errorCode);
    }
    public static ResponseBuilder success(){
        return new ResponseBuilder().buildSuccess();
    }
    public static ResponseBuilder failed(){
        return new ResponseBuilder().buildFailed();
    }

    public static class ResponseBuilder{
        private final Response<Object> response = new Response<>();

        private ResponseBuilder buildSuccess(){
            response.code = Constants.ERROR_CODE.SUCCESS.getCode();
            response.message = Constants.ERROR_CODE.SUCCESS.getMessage();
            return this;
        }

        private ResponseBuilder buildFailed(){
            response.code = Constants.ERROR_CODE.FAILED.getCode();
            response.message = Constants.ERROR_CODE.FAILED.getMessage();
            return this;
        }

        private ResponseBuilder buildCustom(Constants.ERROR_CODE errorCode){
            response.code = errorCode.getCode();
            response.message = errorCode.getMessage();
            return this;
        }

        public ResponseBuilder withData(Object data){
            response.data = data;
            return this;
        }

        public ResponseBuilder withMessage(String message){
            response.message = message;
            return this;
        }

        public ResponseBuilder traceId(String traceId){
            response.traceId = traceId;
            return this;
        }
        public Response<?> build(){
            return response;
        }
    }
}
