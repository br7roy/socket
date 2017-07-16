/*
* Package com.rust.component 
* FileName: Respnse
* Author:   Rust
* Date:     2017/7/16 21:30
*/
package com.rust.component;

import com.alibaba.fastjson.JSONObject;

/**
 * FileName:    Response
 * Author:      Rust
 * Date:        2017/7/16
 * Description:
 */
public class Response {
    private String respCode = "0000";
    private String respMsg = "成功";

    public Response(String respCode, String respMsg) {
        this.respCode = respCode;
        this.respMsg = respMsg;
    }

    public Response() {
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
