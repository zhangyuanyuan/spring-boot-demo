package com.kg.ws.domain.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by quanquan on 2017/6/21.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Msg {

    private String title;

    private String content;

    private String extraInfo;

}
