package exercise.controller;
import exercise.CityNotFoundException;
import exercise.model.City;
import exercise.repository.CityRepository;
import exercise.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


@RestController
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private WeatherService weatherService;

    // BEGIN
    @GetMapping(path = "/cities/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> getCity(@PathVariable Long id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException("City not found"));
        return weatherService.getWeatherByCityName(city.getName());
    }

    @GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Map<String, String>> searchCities(@RequestParam(required = false) String name) {
        List<City> cities = (Objects.isNull(name))
                ? cityRepository.findAll()
                : cityRepository.findByNameStartingWithIgnoreCase(name);
        return cities.stream()
                .sorted(Comparator.comparing(City::getName))
                .map(city -> {
                    Map<String, String> map = new HashMap<>();
                    Map<String, String> cityWeather = weatherService.getWeatherByCityName(city.getName());
                    map.put("temperature", cityWeather.get("temperature"));
                    map.put("name", city.getName());
                    return map;
                })
                .collect(Collectors.toList());
    }
    // END
}

