package guru.springframework.spring5webfluxrest.bootstrap;

import guru.springframework.spring5webfluxrest.domain.Category;
import guru.springframework.spring5webfluxrest.domain.Vendor;
import guru.springframework.spring5webfluxrest.repositories.CategoryRepository;
import guru.springframework.spring5webfluxrest.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrap implements CommandLineRunner {
    private final CategoryRepository categoryRepository;
    private final VendorRepository vendorRepository;

    public BootStrap(CategoryRepository categoryRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(categoryRepository.count().block() == 0){
            //load data
            System.out.println("### Loading data on bootstrap ###");
            categoryRepository.save(Category.builder()
                    .description("Fruits").build()).block();
            categoryRepository.save(Category.builder()
                    .description("Nuts").build()).block();
            categoryRepository.save(Category.builder()
                    .description("Breads").build()).block();
            categoryRepository.save(Category.builder()
                    .description("Meats").build()).block();
            categoryRepository.save(Category.builder()
                    .description("eggs").build()).block();
            System.out.println("Loaded categories "+ categoryRepository.count().block());

            vendorRepository.save(Vendor.builder()
                    .firstName("Joe")
                    .lastName("Buck").build()).block();
            vendorRepository.save(Vendor.builder()
                    .firstName("Michael")
                    .lastName("Weston").build()).block();
            vendorRepository.save(Vendor.builder()
                    .firstName("Joe")
                    .lastName("Buck").build()).block();
            vendorRepository.save(Vendor.builder()
                    .firstName("Joe")
                    .lastName("Buck").build()).block();
            vendorRepository.save(Vendor.builder()
                    .firstName("Jimmy ")
                    .lastName("Buck").build()).block();
            System.out.println("Loaded vendors " + vendorRepository.count().block());
        }

    }
}
