package tests;

import base.BaseApiTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

@Feature("FakeStore Product API")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)   // ✅ Enforce order
public class FakeStoreApiTest extends BaseApiTest {

    static int productId;

    @Test
    @Order(1)
    @Story("Get All Products")
    @Description("Validate GET /products returns list of products")
    public void getAllProducts() {

        Response response =
                given()
                .when()
                    .get("/products")
                .then()
                    .statusCode(200)
                    .extract().response();

        int size = response.jsonPath().getList("$").size();
        assertTrue(size >= 10, "Product count should be >= 10");

        System.out.println("Total Products = " + size);
        response.jsonPath().getList("title").forEach(System.out::println);
    }

    @Test
    @Order(2)
    @Story("Get Product By ID")
    @Description("Validate GET /products/1 schema and status")
    public void getProductById() {

        given()
        .when()
            .get("/products/1")
        .then()
            .statusCode(200)
            .body(matchesJsonSchemaInClasspath("schemas/product-schema.json"))
            .log().body();
    }

    @Test
    @Order(3)
    @Story("Create Product")
    @Description("Validate POST /products creates a product")
    public void createProduct() {

        String payload = """
            {
              "title": "Wireless Mouse",
              "price": 799,
              "description": "High quality mouse",
              "category": "electronics",
              "image": "https://example.com/mouse.jpg"
            }
        """;

        Response response =
            given()
                .header("Content-Type", "application/json")
                .body(payload)
            .when()
                .post("/products")
            .then()
                .statusCode(anyOf(is(200), is(201)))
                .extract().response();

        productId = response.jsonPath().getInt("id");

        // ✅ Critical assertion
        assertTrue(productId > 0, "Product ID was not created properly");

        System.out.println("Created Product ID = " + productId);
    }

    @Test
    @Order(4)
    @Story("Update Product")
    @Description("Validate PUT /products updates product price")
    public void updateProduct() {

        assertTrue(productId > 0, "Product ID must exist before update");

        String payload = """
            {
              "price": 899
            }
        """;

        given()
            .header("Content-Type", "application/json")
            .body(payload)
        .when()
            .put("/products/" + productId)
        .then()
            .statusCode(200)
            .log().body();
    }

    @Test
    @Order(5)
    @Story("Delete Product")
    @Description("Validate DELETE /products removes product")
    public void deleteProduct() {

        assertTrue(productId > 0, "Product ID must exist before delete");

        given()
        .when()
            .delete("/products/" + productId)
        .then()
            .statusCode(anyOf(is(200), is(201)));

        System.out.println("Product deleted successfully");
    }
}
