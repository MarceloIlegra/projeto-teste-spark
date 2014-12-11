package com.ilegra.jt.lancamentodehoras.routes;

import java.util.HashMap;
import java.util.Map;
import spark.Request;

public class MyRequest extends Request{

    private Map<String, String> params = new HashMap<>();
    
    public MyRequest() {
    }

    public MyRequest(Map<String, String> params) {
        this.params = params;        
    }
    
    @Override
    public String queryParams(String param){        
        return params.get(param);
    }
}
