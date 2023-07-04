package omi_ri.utilities.api;

import org.testng.Assert;

public class Validation {


public void checkText(String text,String bodyAsString ){


    Assert.assertEquals(bodyAsString.contains(text), true, text);
    System.out.println("Passed");

    System.out.println("The text extected  is : "+text);
    if(bodyAsString.contains(text)){

        System.out.println("The passed  : "+text);

    }else {

        //can fail the script

    }

}

}
