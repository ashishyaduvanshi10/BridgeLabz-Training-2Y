class Order {
    String orderId;
    String orderDate;

    Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    String getOrderStatus() {
        return "Order placed";
    }
}

class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    String getOrderStatus() {
        return "Order shipped, Tracking: " + trackingNumber;
    }
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    String getOrderStatus() {
        return "Order delivered on " + deliveryDate;
    }
}

public class Main {
    public static void main(String[] args) {
        Order order = new Order("O101", "2025-09-10");
        System.out.println(order.getOrderStatus());

        ShippedOrder shipped = new ShippedOrder("O102", "2025-09-11", "TRK12345");
        System.out.println(shipped.getOrderStatus());

        DeliveredOrder delivered = new DeliveredOrder("O103", "2025-09-12", "TRK54321", "2025-09-14");
        System.out.println(delivered.getOrderStatus());
    }
}
