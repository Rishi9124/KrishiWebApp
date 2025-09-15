//package com.Krishi.KRishi.Controller;
//
//import com.Krishi.KRishi.Service.GenricService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.yaml.snakeyaml.events.Event;
//
//import javax.swing.text.html.parser.Entity;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//public class BaseContoller<T , ID> {
//    @Autowired
//    private  final GenricService<T , ID>  service ;
//     public BaseContoller(GenricService<T , ID> service){
//         this.service = service;
//     }
//     @PostMapping
//    public T create(@RequestBody T entity){
//         return service.save(entity);
//     }
//
//     @GetMapping
//    public List<T> getAll(){
//         return service.getAll();
//     }
//
//     @GetMapping
//    public Optional<T> findById(@RequestBody ID id){
//         return service.findById(id) ;
//     }
//     @PostMapping
//    public  T update(@RequestBody ID id , @RequestBody T entity) {
//         return service.update(id , entity);
//     }
//     public void delete(@RequestBody ID id ){
//          service.deleteById(id);
//     }
//}
