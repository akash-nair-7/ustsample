package ust.carSearch.controllertest;


import com.fasterxml.jackson.databind.ObjectMapper;
import ust.carSearch.controller.Carcontroller;
import ust.carSearch.dto.CarDto;
import ust.carSearch.model.Car;
import ust.carSearch.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;


import java.util.Arrays;
import java.util.Collections;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WebMvcTest(Carcontroller.class)
public class CarControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CarService carService;

    @Test
    public void testGetAvailableCars() throws Exception {
        Car car1 = new Car(1, "Toyota", "grandvitra", true);
        when(carService.findAvailableCars()).thenReturn(Collections.singletonList(car1));

        mockMvc.perform(get("/api/cars/available"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].modelname").value("grandvitra"));
    }
@Test
public void testGetCarsByModelName() throws Exception {
    Car car1 = new Car(1, "Toyota", "grandvitra", true);
    when(carService.findCarsByModelName("grandvitra")).thenReturn(Collections.singletonList(car1));

    mockMvc.perform(get("/api/cars/model/grandvitra"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].modelname").value("grandvitra"));
}
    @Test
    public void testCreateCar() throws Exception {
        CarDto carDto = new CarDto();
        carDto.setBrand("Toyota");
        carDto.setModelName("grandvitra");
        String json = new ObjectMapper().writeValueAsString(carDto);

        mockMvc.perform(post("/api/cars")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.modelname").value("grandvitra"));
    }
    @Test
    public void testGetModelsByBrand() throws Exception {
        Car car1 = new Car(1, "Toyota", "grandvitra", true);
        Car car2 = new Car(2, "Toyota", "camry", true);
        when(carService.findModelsByBrand("Toyota")).thenReturn(Arrays.asList("grandvitra", "camry"));

        mockMvc.perform(get("/api/cars/models/Toyota"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").value("grandvitra"))
                .andExpect(jsonPath("$[1]").value("camry"));
    }




}