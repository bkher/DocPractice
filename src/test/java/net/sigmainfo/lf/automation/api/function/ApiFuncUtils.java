package net.sigmainfo.lf.automation.api.function;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.internal.mapping.Jackson2Mapper;
import com.jayway.restassured.mapper.ObjectMapper;
import com.jayway.restassured.mapper.factory.Jackson2ObjectMapperFactory;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import net.sigmainfo.lf.automation.api.constant.ApiParam;
import net.sigmainfo.lf.automation.api.dataset.address;
import net.sigmainfo.lf.automation.common.AbstractTests;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

/**
 * Created by           : Shaishav.s on 20-02-2017.
 * Test class           : ApiFuncUtils.java
 * Description          : Contains reusable methods used while API automation
 * Includes             : 1. Get request implementation
 *                        2. Post request implementation
 *                        3. Response verification methods
 */
@Component
public class ApiFuncUtils extends AbstractTests{


}
