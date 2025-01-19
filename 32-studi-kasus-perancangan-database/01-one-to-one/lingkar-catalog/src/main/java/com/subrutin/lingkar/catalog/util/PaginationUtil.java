package com.subrutin.lingkar.catalog.util;

import io.quarkus.panache.common.Sort.Direction;

public class PaginationUtil {

    public static Direction getDirection(String direction){
        if(direction.equalsIgnoreCase("asc")){
            return Direction.Ascending;
        }else{
            return Direction.Descending;
        }
    }

}
