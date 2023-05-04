package deliveryapp.domain;

import deliveryapp.domain.DeliveryStarted;
import deliveryapp.DeliveryApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import org.springframework.context.ApplicationContext;

@Entity
@Table(name="Delivery_table")
@Data

public class Delivery  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    private Long id;    
    
    
    
    private String address;    
    
    
    
    private String userId;    
    
    
    
    private Integer qty;    
    
    
    
    private Long orderId;

    @PostPersist
    public void onPostPersist(){
       

        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();


    
    }



    public static DeliveryRepository repository(){
        DeliveryRepository deliveryRepository = applicationContext().getBean(DeliveryRepository.class);
        return deliveryRepository;
    }

    public static ApplicationContext applicationContext(){        
        return DeliveryApplication.applicationContext;
    }

    public void Start delivery(){
        //
    }


    public void cancelDelivery(CancelDeliveryCommand cancelDeliveryCommand){
        // implement the business logics here:

        DeliveryCanceled deliveryCanceled = new DeliveryCanceled(this);
        deliveryCanceled.setOrderId(cancelDeliveryCommand.getOrderId());
        /** Logic **/
        
        deliveryCanceled.publishAfterCommit();

    }
    public void returnDelivery(ReturnDeliveryCommand returnDeliveryCommand){
        // implement the business logics here:

        DeliveryReturned deliveryReturned = new DeliveryReturned(this);
        deliveryReturned.setOrderId(returnDeliveryCommand.getOrderId());
        /** Logic **/
        
        deliveryReturned.publishAfterCommit();

    }



}
