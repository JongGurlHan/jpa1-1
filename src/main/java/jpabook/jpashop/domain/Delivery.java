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

    @Embedded //생략해도 되지만 명확하게 값타임을 명시하기 위해 표시
    private Address address;

    private DeliverStatus status;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;
}

