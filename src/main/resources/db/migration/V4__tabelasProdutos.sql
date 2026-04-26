
CREATE TABLE IF NOT EXISTS product (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    product_name VARCHAR(100) NOT NULL,
    description VARCHAR(100) NOT NULL,
    department VARCHAR(100) NOT NULL,
    category VARCHAR(100) NOT NULL,
    bar_code BIGINT NOT NULL,
    cost_price DECIMAL(10,2),
    sale_price DECIMAL(10,2),
    minimum_stock INT NOT NULL,
    type VARCHAR(100) NOT NULL,
    unit VARCHAR(100) NOT NULL
);


CREATE TABLE batch (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    series CHAR(1) NOT NULL,
    amount INT NOT NULL,
    validity DATE NOT NULL,
    product_id UUID NOT NULL,
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES product(id)
);

-- . Tabela de Movimentação de Estoque
CREATE TABLE stock_movement (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    type VARCHAR(50) NOT NULL,
    quantity INT NOT NULL,
    value DECIMAL(10,2) NOT NULL,
    date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    id_batch UUID NOT NULL,
    CONSTRAINT fk_batch FOREIGN KEY (id_batch) REFERENCES batch(id)
);

-- . Tabela de Vendas (Sale)
CREATE TABLE sale (
    id SERIAL PRIMARY KEY,
    start_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    payment_method VARCHAR(50) NOT NULL,
    status VARCHAR(50) NOT NULL,
    total DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    cliente_id int NOT NULL,
    funcionario_id INT NOT NULL,
    CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id),
    CONSTRAINT fk_funcionario FOREIGN KEY (funcionario_id) REFERENCES funcionario(id)
);

-- . Tabela de Ligação (Sale Movement)
CREATE TABLE sale_movement (
    id SERIAL PRIMARY KEY,
    sale_id INT NOT NULL,
    stock_movement_id UUID NOT NULL,
    CONSTRAINT fk_sale FOREIGN KEY (sale_id) REFERENCES sale(id),
    CONSTRAINT fk_stock_movement FOREIGN KEY (stock_movement_id) REFERENCES stock_movement(id)
);

