package jp.kobe_u.cs.daikibo.tsubuyaki.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Tsubuyaki {
    /**
     * つぶやきエンティティの識別子
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    /**
     * 名前
     */
    String name;
    /**
     * コメント
     */
    String comment;
    /**
     * 作成日時
     */
    @Temporal(TemporalType.TIMESTAMP)
    Date createdAt;
}
