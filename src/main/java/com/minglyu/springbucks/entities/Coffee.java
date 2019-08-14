package com.minglyu.springbucks.entities;

import lombok.*;
import org.hibernate.annotations.Type;
import org.joda.money.Money;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_MENU")
@ToString(callSuper = true) // 打印上一级的 toString
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coffee extends BaseEntity implements Serializable {


    private String name;

    @Column
    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyMinorAmount",
            parameters = {@org.hibernate.annotations.Parameter(name = "currencyCode", value = "CNY")}
    )
    private Money price;

}
