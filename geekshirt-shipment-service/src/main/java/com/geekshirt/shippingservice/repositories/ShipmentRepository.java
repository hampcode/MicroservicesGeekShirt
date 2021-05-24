package com.geekshirt.shippingservice.repositories;

import com.geekshirt.shippingservice.entities.Shipment;
import com.geekshirt.shippingservice.util.enums.OrderShippingStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

    public Shipment findByTrackingId(String trackingId);

    public List<Shipment> findByStatus(String status);

    public List<Shipment> findByStatusIsNotContaining(String status);

    @Modifying
    @Transactional
    @Query("UPDATE Shipment shipment SET shipment.status = :status WHERE shipment.id = :shipmentId ")
    int updateStatus(@Param("shipmentId") long shipmentId, @Param("status") String status);
}
