package r2DBDataConverter.orders.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.stereotype.Repository;

import r2DBDataConverter.orders.Order;

//@Qualifier("OrderRepository")
public interface OrderRepository extends R2dbcRepository<Order,Integer> {
	
}