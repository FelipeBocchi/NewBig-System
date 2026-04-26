CREATE OR REPLACE FUNCTION arrumar_nome()
RETURNS TRIGGER AS $$
BEGIN
    NEW.nome := INITCAP(NEW.nome); /*Deixa as primeiras letras do nome maiuscula*/
RETURN  NEW;
END;
$$ LANGUAGE plpgsql;


CREATE TRIGGER nome_cliente
    BEFORE INSERT OR UPDATE ON cliente
                         FOR EACH ROW
                         EXECUTE FUNCTION arrumar_nome();

CREATE TRIGGER nome_funcionario
    BEFORE INSERT OR UPDATE ON funcionario
                         FOR EACH ROW
                         EXECUTE FUNCTION arrumar_nome();