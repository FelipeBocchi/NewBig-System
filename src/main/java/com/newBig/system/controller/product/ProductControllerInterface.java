package com.newBig.system.controller.product;

import com.newBig.system.controller.product.dto.ProductEditSummaryDto;
import com.newBig.system.controller.product.dto.ProductSummaryDto;

import java.util.List;

public interface ProductControllerInterface {

    List<ProductSummaryDto> listAll();

    void editProduct(ProductEditSummaryDto summaryDto);

    void deleteProduct(int barCode);

    void salveProduct(ProductEditSummaryDto summaryDto);

}
