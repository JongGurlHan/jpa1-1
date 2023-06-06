package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "ORDERS")
public class Order extends BaseEntity{

    @Id
    @Column(name = "ORDER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //가급적이면 단반향으로 하자, 필요시에만 양방향으로(복잡도때문에)
    @ManyToOne //연관관계의 주인
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    //주문서에 연관된 아이템 목록 조회시 양방향 연관관계
    @OneToMany(mappedBy = "item")
    private List<OrderItem> orderItems = new ArrayList<>();

    @ManyToOne // 연관관계의 주인
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;



    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;



}
