package com.richter.dddsample.infrastructure.postgresql14.query;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

public class PointAddQuery {
    private MapSqlParameterSource parameters;
    public PointAddQuery() {
        this.parameters = new MapSqlParameterSource();
    }

    public MapSqlParameterSource getParameters() {
        return parameters;
    }

    public PointAddQuery setCustomerId(Integer customerId) {
        this.parameters.addValue("customerId", customerId);
        return this;
    }
    public PointAddQuery setHoldingPoint(Integer holdingPoint) {
        this.parameters.addValue("holdingPoint", holdingPoint);
        return this;
    }


    public static String getQuery() {
        return """
                INSERT INTO holding_point VALUES(:customerId, :holdingPoint)
                ON CONFLICT ON CONSTRAINT holding_point_pkey
                DO UPDATE SET customer_id=:customerId, holding_point=:holdingPoint
                """;

//        return """
//                INSERT INTO holding_point VALUES(?, ?)
//                ON CONFLICT ON CONSTRAINT holding_point_pkey
//                DO UPDATE SET customer_id=?, holding_point=?
//                """;

        //        return """
//                UPDATE holding_point SET customer_id=?, holding_point=200 WHERE customer_id=2;
//                """;
    }
}
