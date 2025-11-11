package com.petexpress.petexpress_site_backend.config;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.identity.IdentityColumnSupport;
import org.hibernate.dialect.identity.IdentityColumnSupportImpl;

import java.sql.Types;

public class SQLiteDialect extends Dialect {

    public SQLiteDialect() {
        super();
        // Registrando os tipos básicos do SQLite
        this.registerColumnType(Types.BIT, "boolean");
        this.registerColumnType(Types.INTEGER, "integer");
        this.registerColumnType(Types.VARCHAR, "text");
        this.registerColumnType(Types.DOUBLE, "double");
        this.registerColumnType(Types.FLOAT, "float");
    }

    @Override
    public IdentityColumnSupport getIdentityColumnSupport() {
        return new IdentityColumnSupportImpl();
    }

    @Override
    public boolean hasAlterTable() {
        return false;
    }

    @Override
    public boolean dropConstraints() {
        return false;
    }

    @Override
    public String getAddColumnString() {
        return "add column";
    }

    public boolean supportsLimit() {
        return true;
    }

    public String getLimitString(String sql, boolean hasOffset) {
        return sql + " limit ? offset ?";
    }

    @Override
    public boolean supportsTemporaryTables() {
        return true;
    }

    public String getCreateTemporaryTableString() {
        return "create temporary table if not exists";
    }

    public boolean supportsIdentityColumns() {
        return true;
    }

    private void registerColumnType(int BIT, String aboolean) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
