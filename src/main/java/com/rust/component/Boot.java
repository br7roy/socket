/*
* Package com.rust.component 
* FileName: Boot
* Author:   Rust
* Date:     2017/7/16 20:58
*/
package com.rust.component;

import java.io.IOException;

import com.rust.service.SocketService;

/**
 * FileName:    Boot
 * Author:      Rust
 * Date:        2017/7/16
 * Description:
 */
public class Boot {
    public static void main(String[] args) throws IOException {
//        new SocketService().startup(8434);
//        new SocketService().startup(8421);
//        new SocketService().startup(1099);
//        new SocketService().startup(8437);
        new SocketService().startup(2181);



    }
}
