

public class UniqueDeliveryId {

    public static int findUniqueDeliveryId(int[] deliveryIds) {
        int sum = 0;
        for (int id : deliveryIds) {
            sum = sum ^ id;
        }
        return sum;
    }

}
