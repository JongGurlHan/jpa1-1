package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

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
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL) //ORDER생성하면 Delivery 자동생성
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;

    //주문서에 연관된 아이템 목록 조회시 양방향 연관관계
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL) ////ORDER생성하면 orderItems 자동생성
    private List<OrderItem> orderItems = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    private LocalDateTime orderDate;





}
