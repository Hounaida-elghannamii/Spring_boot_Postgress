package com.example.postgre;

import com.google.gson.Gson;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@EnableScheduling
public class MyController {
    @RequestMapping("/hello")
    public String hello(){
        return "Hello";
    }
    @GetMapping(value = "/hounaidaa/{name}")
    private @ResponseBody  String getHelloC(@PathVariable(value="name") String name){
        String uri="https://v6.exchangerate-api.com/v6/f20dafcd007432a40f05580c/latest/USD";
        RestTemplate restTemplate=new RestTemplate();
        String result=restTemplate.getForObject(uri,String.class);
        Gson g = new Gson();
        Mycurrency cu=new Mycurrency();
        try {

            cu = g.fromJson(result, Mycurrency.class);

        }catch (Exception e){

        }

        ArrayList<String > keys = GetCurrenciesNemes(cu.conversion_rates);
        for(int i=0;i<keys.size();i++){
            DeviseEntity ins = new DeviseEntity(keys.get(i) , cu.conversion_rates.get(keys.get(i)).toString() , cu.time_last_update_utc);
            saveEmployeeX(ins);
        }
        return cu.time_last_update_utc;
    }
    private final Service employeeService;
    public MyController(Service employeeService){
        this.employeeService=employeeService;
    }
    public DeviseEntity saveEmployeeX(DeviseEntity deviseEntity){

        return employeeService.saveEmployee(deviseEntity);
    }
    @GetMapping
    public List<DeviseEntity> findAllEmploye(){
        return employeeService.findAllEmployee();
    }
    @GetMapping("/{id}")
    public Optional<DeviseEntity> findEmployeeById(@PathVariable("id") Long id){
        return employeeService.findById(id);
    }
    @PostMapping
    public DeviseEntity saveEmployee(@RequestBody DeviseEntity deviseEntity){
        return employeeService.saveEmployee(deviseEntity);
    }
    @PutMapping
    public DeviseEntity updateEmployee(@RequestBody DeviseEntity deviseEntity){
        return employeeService.updateEmoloyee(deviseEntity);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
    }
    private ArrayList<String> GetCurrenciesNemes(Hashtable<String, Double> map) {
        Enumeration<String> e = map.keys();
        ArrayList<String> cur = new ArrayList<String>();
        while (e.hasMoreElements()) {
            String key = e.nextElement();
            cur.add(key);
        }
        return cur;
    }

    public void deleteAll(){
        List<DeviseEntity>  list= employeeService.findAllEmployee();
        for (DeviseEntity d: list
             ) {
            employeeService.deleteEmployee(d.getId());
        }
    }


    @GetMapping("/hounaida/{name}")
    public DeviseEntity GetPrice(@PathVariable("name") String name){
        List<DeviseEntity> data=this.findAllEmploye();
        DeviseEntity exemple=new DeviseEntity() ;
        for (DeviseEntity ex : data)
        {
            if(name.equals(ex.getCurrencyName())){
                exemple=ex;
                System.out.println(ex.getCurrencyName());
                break;
            }

        }
        return exemple;

    }

    @Scheduled(fixedDelay = (60*60*1000)/10)
    public void calll(){
        deleteAll();
        getHelloC("MAD");

    }

}
