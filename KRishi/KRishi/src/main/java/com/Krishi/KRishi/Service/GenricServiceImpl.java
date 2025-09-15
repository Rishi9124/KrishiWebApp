//package com.Krishi.KRishi.Service;
//
//import com.Krishi.KRishi.Repository.GenricRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//import java.util.Optional;
//
//public class GenricServiceImpl<T ,ID> implements GenricService<T ,ID> {
//
//     public GenricService genricService ;
//     @Autowired
//     private final GenricRepository<T ,ID> repository ;
//      public  GenricServiceImpl(GenricRepository<T ,ID> repository, GenricRepository<T, ID> repository1){
//
//          this.repository = repository1;
//      }
//
//
//    @Override
//    public List<T> getAll() {
//        return (List<T>) repository.findAll();
//    }
//
//    @Override
//    public T save(T entity) {
//        return (T)repository.save(entity);
//    }
//
//    @Override
//    public Optional<T> findById(ID id) {
//        return (Optional<T>) repository.findById(id);
//    }
//
//    @Override
//    public void deleteById(ID id) {
//        repository.deleteById(id);
//    }
//
//    @Override
//    public T update(ID id, T entity) {
//          if(repository.existsById(id)){
//              return repository.save(entity);
//          }
//
//        throw  new RuntimeException( "Entity with id" + id + "not found");
//    }
//
//}
