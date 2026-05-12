CREATE TABLE log_usuario(
    id serial primary key not null,
    descricao varchar(100) not null,
    data timestamp not null default now()
);

CREATE OR REPLACE FUNCTION registra_log_usuario() /*Cria a funçao*/
       RETURNS TRIGGER AS $$ /*Define como trigger*/
        BEGIN /*inicio*/
            INSERT INTO log_usuario(descricao) /*Insere na tabela log*/
            VALUES(TG_OP || ' na tabela ' || TG_TABLE_NAME || ' ID: ' || COALESCE(NEW.id, OLD.id));
            /*TG_OP guarda a operacao, TG_TABLE_NAME guarda o nome, COALESCE pega o id */
            RETURN NEW;
        END; /*fim*/
       $$ LANGUAGE plpgsql;

CREATE TRIGGER reg_log_funcionario /*cria um trigger*/
    AFTER INSERT OR UPDATE OR DELETE ON funcionario /*Condicao para disparar*/
    FOR EACH ROW /*Para cada linha*/
    EXECUTE FUNCTION registra_log_usuario(); /*chama a funcao*/

CREATE TRIGGER reg_log_cliente /*cria um trigger*/
    AFTER INSERT OR UPDATE OR DELETE ON cliente /*Condicao para disparar*/
    FOR EACH ROW /*Para cada linha*/
    EXECUTE FUNCTION registra_log_usuario(); /*chama a funcao*/