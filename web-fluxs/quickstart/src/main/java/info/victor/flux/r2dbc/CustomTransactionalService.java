package info.victor.flux.r2dbc;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;
import static org.springframework.data.domain.ExampleMatcher.matching;

@Component
public class CustomTransactionalService {
    @Resource
    private CustomerRepository repository;

    @Transactional
    public Mono<Customer> save(Customer customer) {
        return repository.save(customer).map(it -> {

            if (it.getFirstName().equals("Dave")) {
                throw new IllegalStateException();
            } else {
                return it;
            }
        });
    }

    public Flux<Customer> findByLastName(String name){
        return repository.findByLastname(name);
    }

    public Flux<Customer> searchByLastName(String name){
        Example<Customer> example = Example.of(new Customer(null, "DAVID", "er"),
                matching().
                withIgnorePaths("id").
                withMatcher("firstName", ignoreCase()).
                withMatcher("lastName", endsWith()));
        return repository.findAll(example);
    }


}
