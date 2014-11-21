package br.com.ilegra.jt.testespark;

import static spark.Spark.*;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "TEste novo mundo!" );
	get("/marcelo", (request, response) -> "My Name is Marcelo");

	//get("/marcelo", (req, res) -> "My Name is Marcelo");
	//get("/paulo", (req, res) -> "My Name is Paulo");
	//get("/aline", (req, res) -> "My Name is Aline");

    }
}
