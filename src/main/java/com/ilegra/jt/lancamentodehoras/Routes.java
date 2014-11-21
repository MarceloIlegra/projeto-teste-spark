package com.ilegra.jt.lancamentodehoras;


import java.util.HashMap;
import java.util.Map;
import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class Routes 
{
    public static void main( String[] args )
    {     
        
	get("/novo", (request, response) -> "Tela de Login");
        
        get("/listagem", (request, response) -> "Tela de Login");
        
        
        
        //get("/m", (request, response) -> new ModelAndView(null, "hello.mustache"), new MustacheTemplateEngine());

        Map map = new HashMap();
        map.put("name", "Sam");

        // hello.mustache file is in resources/templates directory
        get("/edit", (rq, rs) -> new ModelAndView(map, "hello.mustache"), new MustacheTemplateEngine());

	//get("/marcelo", (req, res) -> "My Name is Marcelo");
	//get("/paulo", (req, res) -> "My Name is Paulo");
	//get("/aline", (req, res) -> "My Name is Aline");

    }
}
