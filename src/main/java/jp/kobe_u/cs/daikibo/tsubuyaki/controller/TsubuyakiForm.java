package jp.kobe_u.cs.daikibo.tsubuyaki.controller;

import lombok.Data;

@Data
public class TsubuyakiForm {
    /**
     * 投稿者
     */
    String name;
    /**
     * つぶやき（省略不可）
     */
    String comment;
}
