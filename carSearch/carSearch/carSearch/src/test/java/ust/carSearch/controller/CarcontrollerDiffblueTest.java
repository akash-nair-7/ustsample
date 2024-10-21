package ust.carSearch.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import ust.carSearch.dto.CarDto;
import ust.carSearch.service.CarService;
import ust.carSearch.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Carcontroller.class})
public class CarcontrollerDiffblueTest {

    @MockBean
    private CarService carService;

    @Autowired
    private Carcontroller carcontroller;

    private MockMvc mockMvc;

    @Test
    public void testGetAvailableCars() throws Exception {
        when(carService.findAvailableCars()).thenReturn(new ArrayList<>());
        mockMvc = MockMvcBuilders.standaloneSetup(carcontroller).build();

        mockMvc.perform(get("/api/cars/available"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    public void testFindCarsByModelName() throws Exception {
        String modelName = "Camry";
        Car car = new Car(1, "Toyota", modelName, true);
        when(carService.findCarsByModelName(modelName)).thenReturn(Collections.singletonList(car));

        mockMvc = MockMvcBuilders.standaloneSetup(carcontroller).build();

        mockMvc.perform(get("/api/cars/modelname").param("modelname", modelName))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].modelname").value(modelName));
    }

    @Test
    public void testSaveCar() throws Exception {
        CarDto carDto = new CarDto();
        carDto.setBrand("Tata");
        carDto.setModelName("Nexon");
        carDto.setPrice(750000.00);

        // Mock the saveCar method
        Car savedCar = new Car(2, carDto.getBrand(), carDto.getModelName(), true);
        when(carService.saveCar(carDto)).thenReturn(savedCar);

        mockMvc = MockMvcBuilders.standaloneSetup(carcontroller).build();

        mockMvc.perform(post("/api/cars")
                        .contentType("application/json")
                        .content("{\"brand\":\"Tata\",\"modelName\":\"Nexon\",\"price\":750000}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.modelname").value("Nexon"));
    }

    /*@Test
    public void testListModelsUnderBrand() throws Exception {
        String brand = "Toyota";
        Car car1 = new Car(1, brand, "Camry", true);
        Car car2 = new Car(2, brand, "Corolla", true);
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);

        // Mock the service method
        when(carService.findModelsByBrand(brand)).thenReturn(carList);

        mockMvc = MockMvcBuilders.standaloneSetup(carcontroller).build();

        mockMvc.perform(get("/api/cars/brand").param("brand", brand))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].modelname").value("Camry"))
                .andExpect(jsonPath("$[1].modelname").value("Corolla"));
    }*/
}
