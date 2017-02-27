package javabean.generate.parse;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TypeMapper {

    private static final Map<Integer, Class<?>> TYPE_MAPPERS = new HashMap<>();

    static {
        TYPE_MAPPERS.put(Types.CHAR, String.class);
        TYPE_MAPPERS.put(Types.NUMERIC, BigDecimal.class);
        TYPE_MAPPERS.put(Types.DECIMAL, BigDecimal.class);
        TYPE_MAPPERS.put(Types.INTEGER, Integer.class);
        TYPE_MAPPERS.put(Types.SMALLINT, Integer.class);
        TYPE_MAPPERS.put(Types.FLOAT, Float.class);
        TYPE_MAPPERS.put(Types.REAL, Float.class);
        TYPE_MAPPERS.put(Types.DOUBLE, Double.class);
        TYPE_MAPPERS.put(Types.VARCHAR, String.class);//12
        TYPE_MAPPERS.put(Types.DATE, Date.class);//91
        TYPE_MAPPERS.put(Types.TIME, Date.class);//92
        TYPE_MAPPERS.put(Types.TIMESTAMP, Date.class);//93
        TYPE_MAPPERS.put(Types.BLOB, byte[].class);//2004
        TYPE_MAPPERS.put(Types.BIGINT, BigInteger.class);//-5
        TYPE_MAPPERS.put(Types.TINYINT, Integer.class);//-6
        TYPE_MAPPERS.put(Types.BIT, Boolean.class);//-7
        TYPE_MAPPERS.put(Types.OTHER,String.class);
    }

    public static Class<?> getMapperClass(int sqlType) {
        Class<?> clazz = null;
        for (Entry<Integer, Class<?>> entry : TYPE_MAPPERS.entrySet()) {
            if (entry.getKey().intValue() == sqlType) {
                clazz = entry.getValue();
                return clazz;
            }
        }
        clazz = String.class;//提高兼容性，避免NPE;
        return clazz;
    }
}
