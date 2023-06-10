package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Delivery extends BaseEntity{

    //회원 그룹
    @Id
    @GeneratedValue
    private Long id;

    private String city;
    private String street;
    private String zipcode;

    private DeliverStatus status;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;
}

