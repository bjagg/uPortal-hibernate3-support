package org.apereo.uportal.hibernate3.support;

import java.sql.Types;

import org.hibernate.dialect.Oracle10gDialect;

/**
 * When using Oracle 10g dialect with Oracle 12, ensure strings over 4000 characters are handled
 * correctly.
 *
 * <p>See also https://groups.google.com/a/apereo.org/forum/#!topic/uportal-user/j1Opk6Knv_k
 */
public class Oracle12ForceClobDialect extends Oracle10gDialect {

    public Oracle12ForceClobDialect() {
        super();
    }

    protected void registerCharacterTypeMappings() {
        super.registerCharacterTypeMappings();
        registerColumnType(Types.VARCHAR, "clob");
    }

    protected void registerLargeObjectTypeMappings() {
        super.registerLargeObjectTypeMappings();
        registerColumnType( Types.LONGVARCHAR, "clob");
    }
}
