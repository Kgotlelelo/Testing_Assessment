package tests.srmServiceTests;


import io.restassured.response.Response;
import omi_ri.utilities.api.RestInteractionPoint;
import omi_ri.utilities.api.StatusCode;
import omi_ri.utilities.api.Validation;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ApiTesting {


    @Test
    public void iGetARequest() throws Exception {


        RestInteractionPoint restInteractionPoint = new RestInteractionPoint();
        Response response;
        Validation validation = new Validation();

        String endPoint ="https://dog.ceo/api/breeds/list/all";

        System.out.println(endPoint);

        response =restInteractionPoint.get(endPoint);


        response.prettyPrint();
        System.out.println(response.getStatusCode());

        System.out.println(response.getBody());
        System.out.println(response.asString());
        System.out.println(StatusCode.CODE_200.code);


        assertStatusCode(response.getStatusCode(), StatusCode.CODE_200);

        //Do a String contains
        String bodyAsString = response.asString();

        //verify That retriever is part of the list
        validation.checkText("retriever", bodyAsString);



    }

    public void assertStatusCode(int actualStatusCode, StatusCode statusCode){

        assertThat(actualStatusCode, equalTo(statusCode.code));

    }



}
