package com.newBig.system;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import com.newBig.system.application.usecase.RegisterProductUseCase;
import com.newBig.system.domain.repository.ProductRepository;
import com.newBig.system.domain.service.ProductService;
import com.newBig.system.infrastructure.persistence.ProductMemoryRepository;
import com.newBig.system.presentation.controller.ProductController;
import com.newBig.system.presentation.view.ProductView;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // == Passagem direto do produto
        ProductRepository repository = new ProductMemoryRepository();

        //
        ProductService service = new ProductService(repository);

        //useCase
        RegisterProductUseCase useCase = new RegisterProductUseCase(service);

        ProductController controller = new ProductController(useCase);

        ProductView view = new ProductView(controller);

        view.start();

    }
}

