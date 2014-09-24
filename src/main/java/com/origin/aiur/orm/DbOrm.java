package com.origin.aiur.orm;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class DbOrm {
    private static SqlMapClient sqlClient = null;
    public static SqlMapClient getORMClient() throws IOException{
        if (sqlClient == null) {
            synchronized (DbOrm.class) {
                InputStream input = null;
                Reader reader = null;
                try {
                    Resources.setDefaultClassLoader(DbOrm.class.getClassLoader());
                    reader = Resources.getResourceAsReader("SqlMapConfig.xml");
                    sqlClient = SqlMapClientBuilder.buildSqlMapClient(reader);
                } catch (IOException e) {
                    throw e;
                } finally {
                    try {
                        if (input != null) {
                            input.close();
                        }
                        if (reader != null) {
                            reader.close();
                        }
                    } catch (Exception ex) {
                    }
                }
            }
        }
        return sqlClient;
    }
}
