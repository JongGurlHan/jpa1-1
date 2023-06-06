package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Delivery extends BaseEntity{

    //회원 그룹
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키생성 DB에 위임
    @Column(name = "DELIVERY_ID")
    private Long id;

    private String address;

    @OneToMany(mappedBy = "delivery")
    private List<Order> orders = new ArrayList<>();


    public void addOrder(Order order) {
        order.setDelivery(this);
        orders.add(order);
    }
}
