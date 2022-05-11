package info.victor.flux.r2dbc;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Long>, ReactiveQueryByExampleExecutor<Customer> {

    @Query("select id, first_name, last_name from customer c where c.last_name = :lastName")
    Flux<Customer> findByLastname(String lastName);
}