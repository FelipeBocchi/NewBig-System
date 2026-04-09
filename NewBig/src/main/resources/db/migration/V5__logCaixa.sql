CREATE TABLE logs_caixa(
    id serial primary key not null ,
    descricao varchar(100),
    data timestamp not null default now()
);
ALTER TABLE dados_caixa
    ADD COLUMN valorAtual NUMERIC;

CREATE OR REPLACE FUNCTION registra_log_caixa() /*Cria a funçao*/
       RETURNS TRIGGER AS $$ /*Define como trigger*/
        BEGIN /*inicio*/
            IF TG_OP = 'INSERT' THEN
                INSERT INTO logs_caixa(descricao)
                VALUES ('Caixa aberto com R$' || NEW.valorAbertura);
            ELSIF TG_OP = 'UPDATE' THEN
                IF OLD.valorFechamento = 0 AND NEW.valorFechamento > 0 THEN
                    INSERT INTO logs_caixa(descricao)
                    VALUES ('Fechamento de caixa de R$' || NEW.valorFechamento);
                ELSIF NEW.valorAtual != OLD.valorAtual THEN
                    INSERT INTO logs_caixa(descricao)
                    VALUES('Mudanca de caixa de R$' || OLD.valorAtual || ' para R$' || NEW.valorAtual );
                END IF;
            END IF;

            RETURN NEW;
        END; /*fim*/
       $$ LANGUAGE plpgsql;


CREATE TRIGGER trigger_log_caixa
AFTER INSERT OR UPDATE ON dados_caixa
FOR EACH ROW
EXECUTE FUNCTION registra_log_caixa();


